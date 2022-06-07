#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <time.h>
#include <signal.h>

#define SERVER_PORT 51975
#define MAX_LINE 257

FILE * Arq;  
int flag;
char pacote[MAX_LINE+1];

void Destrava ()
{ /* Destrava flag se pacote do servidor nao voltar a tempo */
	flag = 1;
}

void PedeAberturaArquivo ( int socket, struct sockaddr_in servidor, char NomeArquivo[30] ) {
/* encaminha para servidor nome de arquivo a ser aberto e printa o sucesso ou insucesso */
	char p[MAX_LINE + 1];
	int len;
	int tam_sin = sizeof(servidor);

	/* manda nome do arquivo para servidor */
	if (sendto (socket, NomeArquivo, strlen(NomeArquivo) +1, 0, (struct sockaddr *)&servidor, sizeof (servidor)) < 0 ) {
		perror("simple-tftp: Erro Send to do Nome do Arquivo");
		exit (1);
	};

	signal (SIGALRM, Destrava);
	alarm (10);
	flag = 0;

	while ( ! flag ){
		/* recebe sucesso ou falha do servidor na abertura do arquivo */
		len = recvfrom (socket, p, sizeof(p), MSG_DONTWAIT, (struct sockaddr *)&servidor, &tam_sin);
		if ( len > 0 ) {
			alarm (0);
			flag = 1;
		};
	};

	if (len < 0){
		perror("simplex-tftp: Servidor nao respondeu!");
		exit (1);
	};

	if ( !strncmp ( p, "Arquivo aberto com sucesso.", 15) ) {
		fprintf ( stdout, "Arquivo aberto com sucesso no servidor.\n");
	} else {
		fprintf (stdout,"Erro: %s\n", p);
		exit (1);
	}
}

int RecebePacote ( int socket, struct sockaddr_in servidor ){

	int tamanho;
	int tam_sin = sizeof (servidor);

	signal (SIGALRM, Destrava);
	flag = 0;
	alarm (10);
	pacote[0] = '\0';
	while (!flag) {
		tamanho = recvfrom (socket, pacote, sizeof(pacote), MSG_DONTWAIT, (struct sockaddr *)&servidor, &tam_sin);
		if ( tamanho > 0 ) {
			alarm (0);
			flag = 1;
		}
	}

	if (tamanho < 0 ) {
		perror("simplex-talk-udp: Servidor parou de enviar!");
		exit (1);					
	}
	fprintf (stdout, "Recebeu um pacote de %d bytes da janela %c.\n", tamanho-1, pacote[0]);
	return tamanho;
}

char GravaBloco ( int tamanho ){
/* grava em arquivo o bloco recebdio e devolve a proxima janela esperada */
				
	int i;
	char retorno;
	
	for ( i=1; i < (tamanho-1); i++ )
		fputc (pacote [i], Arq);

	fprintf ( stdout, "Colocou bloco de dados no arquivo.\n" );

	/* indica qual eh o proximo bloco esperado */

	if ( pacote[0] == '0' ){
		retorno = '1';
	}
	else {
		retorno = '0';
	}
	return retorno;
}
	
int EnviaACK (int socket, struct sockaddr_in servidor, int erro, char w) {

	int len;
	int i, j;
	char sACK[30];
	int ACK = 0;

	j = rand()%100;
	if ( j < erro ) {
		/* forca erro no recebimento do pacote */
		/* Nao faz nada com informacao que chegou */
		fprintf ( stdout, "Forcou erro no recebimento.\n");
	}
	else {
		/* pacote chegou sem "erro" */
		fprintf ( stdout, "Recebeu sem erros.\n");

		j = rand () % 100;
		if ( j >= erro ) {
			if ( w == '0')
				strcpy (sACK , "ACK 0");
			else
				strcpy (sACK, "ACK 1");

			if ( sendto (socket, sACK, strlen(sACK) +1, 0, (struct sockaddr *)&servidor, sizeof (servidor) ) < 0 ) {
				perror ("simplex-tftp: Erro ACK.");
				exit (1);
			};
			ACK = 1;
			fprintf (stdout, "Mandou %s.\n", sACK);
		}
		else {
			fprintf (stdout, "Forcou erro de envio de ACK.\n");
		}
	} 
	return ACK;
}

int main (int argc, char * argv[]) {
	FILE *fp;
	struct hostent *hp;
	struct sockaddr_in sin; /* estrutura das informações do servidor */
	struct sockaddr_in cin; /* estrutura das informações do cliente */
	char *host;
	char bloco[MAX_LINE]; /* variavel com o bloco de dados do arquivo */
	char NomeArq[30]; /* variavel com nome do arquivo passado como parametro de chamada do cliente */
	int s;
	int erro; /* porcentagem de erro requerida */
	int len;
	int tam_sin; /* recebe o tamanho da estrutura do servidor */
	char Esperado;
	int i; /* para loop de escrita no arquivo */
	int ACK; /* aponta se ACK foi mandado ou nao */


	/*confere se os tres parametros foram digitados */
	if (argc == 4) {
		host = argv[1];
		strcpy (NomeArq, argv[2]);
		erro = atoi (argv[3]);
	} else {
		fputs ("Quantidade de paramentros incorreta, digite: ", stdout );
		fputs ("cliarq nome_host nome_arq <0-100>", stdout);
	}

	/* testa para ver se erro digitado pelo usuario estah entre 0 e 100 */
	if (erro <0 || erro > 100) {
		fprintf (stdout, "Erro deve estar entre 0 e 100.\n");
		exit (1);
	}
	
	/* traduz nome do host para endereço IP do par */
	hp = gethostbyname (host);
	if (!hp) {
		fprintf (stderr, "simple-tftp: host desconhecido: %s\n", host );
		exit (1);
	}

	/* monta estrutura de dados do endereço */
	bzero ((char *) &sin, sizeof (sin));
	sin.sin_family = AF_INET;
	bcopy(hp->h_addr, (char*)&sin.sin_addr, hp->h_length);
	sin.sin_port = htons (SERVER_PORT);

	cin.sin_family = AF_INET;
	cin.sin_port = htons(0);
	cin.sin_addr.s_addr= htonl(INADDR_ANY);

	/* abertura ativa */
	if ((s= socket (AF_INET, SOCK_DGRAM, 0)) < 0 ) {
		perror ("simplex-talk-udp: socket");
		exit (1);
	}

	if (bind (s, (struct sockaddr*) &cin, sizeof(cin)) <0){
		perror ("simplex-talk-udp: bind");
		exit (1);
	};

	/* texto para melhorar interface com usuário */
	fprintf ( stdout, "Nome do arquivo pedido> %s \n", NomeArq );
	fprintf ( stdout, "Porcentagem de erro requerida> %d %\n", erro );
	
	PedeAberturaArquivo (s, sin, NomeArq);

	/* abre arquivo para escrita */
	Arq = fopen ("arquivo_recebido.txt", "w");

	/* o primeiro pacote esperado eh da janela 0 */
	Esperado = '0'; 

	/* incializando a semente de aleatoriedade */
	srand ( time (NULL) );

	do { /* enquanto nao for fim de arquivo faca */
		ACK = 0;
		do { /* enquanto nao enviar o ack */
			pacote[0] = '\0';
			len = RecebePacote ( s, sin );
			if ( pacote[0] == Esperado )
				Esperado = GravaBloco ( len );
			else
				fprintf ( stdout, "perdeu ACK na rede.\n");
				
			ACK = EnviaACK ( s, sin, erro, pacote[0] ); 

		} while ( ! ACK );
	} while ( len == 258  );

	fclose (Arq);

}
