#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <signal.h>

#define SERVER_PORT 51975
#define MAX_LINE 257
int flag;
FILE * Arq;

void Destrava()
{ /* Detrava flag se pacote nao chegar a tempo */
	flag = 1;
}

int AbreArquivo ( int socket, struct sockaddr_in cliente, char NomeArquivo[30] )
{ /* Abre arquivo solicitado para leitura, indicando sucesso ou insucesso para o cliente */
	char Mensagem [MAX_LINE];
	int tam_cin = sizeof (cliente);
	Mensagem[0] = '\0';
	Arq = fopen (NomeArquivo, "r" );
	if (Arq == NULL) { /* Erro an abertura do arquivo */
		fprintf ( stdout, "Erro na abertura do arquivo!\n" );
		strcpy ( Mensagem, "Erro na abertura do arquivo!");
		if ( sendto (socket, Mensagem, strlen (Mensagem) + 1, 0, (struct sockaddr *) &cliente, tam_cin) < 0) {
			fprintf ( stdout, "Erro no envio de Mensagem para cliente.\n" );
			exit (1);			
		}
		fprintf (stdout, "Mensagem de insucesso encaminhada para o cliente.\n"); 
		return 1;
	}
	else {
		fprintf ( stdout, "Arquivo aberto com sucesso.\n" );
		strcpy ( Mensagem, "Arquivo aberto com sucesso.");
		if ( sendto (socket, Mensagem, strlen (Mensagem) + 1, 0, (struct sockaddr *) &cliente, tam_cin) < 0) {   
			fprintf ( stdout, "Erro no envio de Mensagem para cliente.\n");	
			exit (1);
		};
		fprintf (stdout, "Mensagem de sucesso encaminhada para o cliente.\n"); 
		return 0;
	};
};

int PegaBloco ( char bloco[MAX_LINE] )
{ /* recupera um bloco de até 256 bytes do arquivo e retorna 0 se não for final do arquivo ou 1 se for final */
	int i = 0;
	do {
		bloco[i] = fgetc (Arq);
		i ++;
	} while ( (i<256) && (bloco[i-1] != EOF) );

	if ( bloco[i-1] == EOF )
		bloco [i-1] = '\0';
	else
		bloco[i]='\0';
	if ( strlen(bloco) < 256 ) 
		return 1; /* fim de arquivo */
	else
		return 0;
};

void MontaPacote ( int * W, char pacote[MAX_LINE+1], char bloco[MAX_LINE] )
{ /* monta o pacote a ser transmitido colocando no primeiro byte o número da janela e a partir do 1o byte o bloco recuperado do arquivo */
	pacote[0] = '\0';
	if (*W == 0) {
		strcpy ( pacote, "0");
		strcat (pacote, bloco);
		*W = 1;
	} else {
		strcpy ( pacote, "1");
		strcat (pacote, bloco);
		*W = 0;
	}
}; 

int AguardaACK ( int socket, struct sockaddr_in cliente )
{ /* Dispara um signal alarm por 3 segundos, destravando o loop em caso de timeout, ou interrompe caso chegue a confirmação. Devolve 0 se estourou ACK ou 1 se tiver recebido o ACK */
	int tamanho;
	char sACK[30];
	char Mensagem[MAX_LINE];
	int tam_cin = sizeof (cliente);

	/* ativa alarme para aguardar por um tempo determinado o ACK */
	signal (SIGALRM, Destrava);
	flag = 0;
	alarm(3);
	sACK[0] = '\0';
	Mensagem[0] = '\0';

	fprintf ( stdout, "Aguardando ACK.\n");

	while ( !flag ) {
		/* recebe confirmacao ou novo pedido de abertura*/
		tamanho = recvfrom(socket, sACK, sizeof(sACK), MSG_DONTWAIT, (struct sockaddr *) &cliente, &tam_cin);
		if (tamanho > 0 ) { /* recebeu pacote */
			/* verifica se eh novo pedido */
			if (!strncmp (sACK, "ACK ", 4)) { /* eh um ACK */
				/* destaiva signal */
				alarm (0);
				fprintf ( stdout, "Servidor recebeu um %s.\n", sACK);
				flag = 1;
				return 1;
			}					
			else { /* eh um novo pedido de arquivo */
				fprintf ( stdout, "Servidor Ocupado!\n");
				strcpy ( Mensagem, "Servidor ocupado!");
					
				if ( sendto (socket, Mensagem, strlen (Mensagem) + 1, 0,(struct sockaddr *) &cliente, tam_cin) < 0){
					perror ("Erro no envio de Mensagem apra cliente");			
					exit (1);
				}
			}
		};
	};

	fprintf ( stdout, "Estourou o timer, encaminha pacote de novo. \n");
	return 0;
};

void EnviaPacote (int socket, struct sockaddr_in cliente, char pacote[MAX_LINE+1]) {
/* Funcao de envio do pacote de dados recuperados do arqvuio solicitado */

	int tam_cin = sizeof ( cliente );
	fprintf ( stdout, "%d\n", strlen(pacote) );
	/* envia bloco de dados com numero da janela */
	if ( sendto (socket, pacote, strlen (pacote) +1, 0, (struct sockaddr *) & cliente, tam_cin) < 0 )
	{	perror ("Erro no envio de pacote para cliente");
		exit (1);
	}
			
	fprintf (stdout, " Pacote %c enviado para cliente.\n ", pacote[0] );
};

int main (int argc, char * argv[]) {
	struct sockaddr_in sin; /* estrutura de endereço do servidor */
	struct sockaddr_in client; /* estrutura de endereço do cliente */
	char pacote[MAX_LINE+1]; /* pacote com o numero da janela (0 ou 1) e o buffer de no maximo 256 bytes recuperado do arquivo desejado */
	char bloco[MAX_LINE]; /* buffer com string recuperada do arquivo solicitado pelo cliente */
	char NomeArq[30]; /* string com nome doa rquivo solicitado */
	int eof = 0; /* variavel que indica final de arquivo */
	int ACK = 0; /* variavel que indica ACK recebido */
	int len;
	int tam_cin; /* tamanho da estrutura do cliente */
	int s;
	int W;
	int limite_tentativas;

	/* monta estrutura de dados do endereço */
	bzero ((char *) &sin, sizeof (sin));
	sin.sin_family = AF_INET;
	sin.sin_addr.s_addr = INADDR_ANY;
	sin.sin_port = htons (SERVER_PORT);

	/* configura abertura passiva */
	if ((s= socket (AF_INET, SOCK_DGRAM, 0)) < 0) {
		perror ("servidor arquivos: socket");
		exit (1);
	};
	
	if ((bind(s, (struct sockaddr*)&sin, sizeof(sin))) < 0 ) {
		perror("servidor arquivos: bind");
		exit (1);
	};

	/* entra em loop infinito para atender varios clientes, um por vez  */
	while (1)
	{
		tam_cin = sizeof (client);

		fprintf ( stdout, "Aguardando novo cliente.\n");
		/* recebe primeiro pacote do cliente com nome do arquivo desejado */
		len = recvfrom(s, NomeArq, sizeof(NomeArq), 0, (struct sockaddr *) &client, &tam_cin);
		
		/* se len < 0 indica erro no recebimento */
		if (len < 0) {
			perror("servidor arquivo: recvfrom");
			exit (1);
		};
		fprintf (stdout, "Recebeu um pedido do arquivo %s.\n", NomeArq);

		/* Abre arquivo para leitura */
		eof = AbreArquivo ( s, client, NomeArq );

		W = 0; /* primeiro bloco a ser transmitido */
		while ( !eof ) {    /* faca enquanto o arquivo nao acabar */
			/* recupera um bloco de pelo menos 256 bytes do Arquivo */
			eof = PegaBloco ( bloco );

			/* monta pacote que sera transmitido */
			MontaPacote ( &W, pacote, bloco );

			ACK = 0;
			limite_tentativas = 0;
			do {
				/* enquanto nao receber ACK retransmite o mesmo pacote varias vezes */
				EnviaPacote ( s, client, pacote );

				/* Aguarda ACK ou estoura o timeout */
				ACK = AguardaACK ( s, client );
				if ( ! ACK && limite_tentativas > 15 ) {
					fprintf ( stdout, "Excedeu 16 tentativas de envio do mesmo pacote.\n");
					ACK = 1;
					eof = 1;
				}
				limite_tentativas = limite_tentativas + 1;

			} while ( ! ACK ); /* faca enquanto nao receber confirmacao */
		} /* faca enquanto o arquivo nao terminar */
		if ( Arq != NULL ) fclose (Arq);
	}; /* fim da comunicacao com um cliente */
};
