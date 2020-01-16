/**
 * @author Rithie Natan Carvalhaes Prado
 * Data: 27/11/2018
 */

import java.io.*;
import java.util.Scanner;

public class Crud {

	private static RandomAccessFile arq;
	private static RandomAccessFile index;
	private static RandomAccessFile gen;
	private static Scanner input;
	private static int genID;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int choice = -1;

		System.out.println("Bem-vindo ao CRUD de filmes!");
		try{
			index = new RandomAccessFile("index.db","rw");
			arq = new RandomAccessFile("filme.db","rw");
			gen = new RandomAccessFile("generos.db","rw");

			int id;

			while(choice != 0) {
				System.out.println("---------------------------------\nMain Menu:\n"+
						"0 - Sair;\n"+
						"1 - Menu de Filmes;\n"+
						"2 - Menu de Generos\n------------------------------------");
				choice = input.nextInt();
				if(choice == 1) {
					while(choice != -1) {
						System.out.println("-----------------------------------------------\nMenu de filmes:\n"+
								"0 - Voltar;\n"+
								"1 - Incluir filme;\n"+
								"2 - Alterar filme;\n"+
								"3 - Excluir filme;\n"+
								"4 - Consultar filme;\n-----------------------------------------------");
						choice = input.nextInt();

						switch(choice) {
							case 0:
								choice = -1;
								break;
							case 1:
								boolean temGenero = hasGen();
								if(temGenero) {
									Filme filme = criarObjetoFilme();
									System.out.println("CRIADO O FILME = "+filme.getTitulo());

									if(filme != null) {
										create(filme,-1);
									}
								} else {
									System.out.println("Não há generos cadastrados. Cadastre pelo menos 1 genero!");
								}

								break;
							case 2:
								System.out.println("Insira o ID do filme a ser alterado: ");
								id = input.nextInt();
								System.out.print("Deseja confirmar a alteração? Insira (1): ");
								if(input.nextByte() == 1) {
									update(id);
								}
								break;
							case 3:
								System.out.print("Insira o ID do filme a ser excluído: ");
								id = input.nextInt();
								System.out.print("Deseja confirmar a exclusão? Insira (1): ");

								if(input.nextByte() == 1) {
									delete(id);
								}

								break;
							case 4:
								System.out.print("Insira o ID do filme a ser pesquisado: ");
								id = input.nextInt();
								read(id);
								break;
							default:
								System.out.println("Opção inválida!");
								break;
						}
					}
				} else if (choice == 2) {
					while (choice != -1) {
						System.out.println("-------------------------------------\nMenu de Generos:\n"+
								"0 - Voltar;\n"+
								"1 - Inserir Genero;\n"+
								"2 - Alterar Genero;\n"+
								"3 - Excluir Genero;\n"+
								"4 - Consultar Genero;\n-----------------------------------");
						choice = input.nextInt();
						switch(choice) {
							case 0 :
								choice = -1;
								break;
							case 1:
								createGen(-1);
								break;
							case 2:
								updateGen();
								break;
							case 3:
								deleteGen();
								break;
							case 4:
								readGen();
								break;

						}
					}
				} else {
					index.close();
					arq.close();
					gen.close();

				}
			}
		} catch (IOException ioException ) {
			ioException.printStackTrace();
		}

		System.out.println("Obrigado por utilizar o CRUD!");
	}//end main()

	/**
	 * Cria o genero
	 * @param id do genero a ser criado
	 * @param nome do genero a ser criado
	 * */
	public static void createGen(int idGen) {
		input = new Scanner(System.in);
		System.out.print("Digite o Genero: ");
		String genero = input.nextLine();

		try {
			if(searchGen(genero)) {
				System.out.println("Genero ja cadastrado!");
			} else {
				if(idGen == -1) {
					if(gen.length() == 0) {
						idGen = 0;
					} else {
						gen.seek(0);
						idGen = gen.readInt();
						idGen++;
					}
				}
				gen.seek(0);
				gen.writeInt(idGen);
				Genero novoGen = new Genero(genero,idGen);
				gen.seek(gen.length());
				novoGen.writeObject(gen);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//end createGen()

	/**
	 * Altera um genero existente
	 * */
	public static void updateGen() {
		input = new Scanner(System.in);
		boolean continuar = true;
		System.out.print("Digite o ID do genero a ser alterado: ");
		int idGen = input.nextInt();
		int id = -1;
		long ponteiro = searchGenPointer(idGen);

		try {
			if(ponteiro != -1) {
				gen.seek(ponteiro);
				gen.writeChar('*');
				createGen(idGen);
			} else {
				System.out.println("Genero inexistente!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}//end updateGen()

	/**
	 * Deleta um genero existente
	 * */
	public static void deleteGen() {
		input = new Scanner(System.in);
		System.out.print("Digite o ID do genero a ser excluido: ");
		int idGen = input.nextInt();
		boolean continuar = isEmpty(idGen);
		long ponteiro = searchGenPointer(idGen);

		if(continuar) {
			try {
				if(ponteiro != -1) {
					gen.seek(ponteiro);
					gen.writeChar('*');
				} else {
					System.out.println("Genero inexsitente");
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Ha filmes ligados a esse genero!");
		}
	}//end deleteGen()

	/**
	 * Consulta a existencia de um genero
	 * */
	public static void readGen(){
		input = new Scanner(System.in);
		System.out.print("Digite o ID genero que deseja procurar: ");
		int idGen = input.nextInt();
		long ponteiro = searchGenPointer(idGen);

		try {
			if(ponteiro != -1) {
				gen.seek(ponteiro);
				gen.readChar();
				short tam = gen.readShort();
				byte[] dados = new byte[tam];
				gen.read(dados);
				Genero genero = new Genero();
				genero.setByteArray(dados);

				System.out.println("O genero procurado é: " + genero.getNomeGenero());
				listaFilmes(genero.getID());
			} else {
				System.out.println("Genero inexistente!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}//end readGen()

	/**
	 * Procura o ponteiro do genero escolhido
	 * @param id do genero a ser procurado
	 * @return ponteiro para a posicao do genero no arquivo
	 * */
	public static long searchGenPointer(int id) {
		int idLido;
		long address = -1;
		boolean continuar = true;

		try{
			gen.seek(4);
			while(gen.getFilePointer() < gen.length() && continuar) {
				long auxPointer = gen.getFilePointer();
				char aux = gen.readChar();
				short tam = gen.readShort();
				byte[] dados = new byte[tam];
				gen.read(dados);
				Genero genero = new Genero();
				genero.setByteArray(dados);

				if(aux != '*' && genero.getID() == id) {
					address = auxPointer;
					continuar = false;
				}

			}
		} catch(IOException e) {
			e.printStackTrace();
		}

		return address;
	}//end searchGenPointer()

	/**
	 * Lista os filmes de um genero
	 * @param ID do genero desejado
	 * */
	public static void listaFilmes(int genero) {
		try {
			char aux = '*';
			arq.seek(4);
			byte[] array;

			while(arq.getFilePointer() < arq.length()) {
				aux = arq.readChar();
				int tam = arq.readShort();
				array = new byte[tam];
				for(int i = 0; i < tam; i++) {
					array[i] = arq.readByte();
				}


				Filme filme = new Filme();
				filme.setByteArray(array);
				if(filme.getIDGenero() == genero && aux != '*') {
					System.out.println();
					System.out.print(filme);
					System.out.println();
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}//end listaFilmes()

	/**
	 * Confere se um genero possui filmes cadastrados
	 * @param ID do genero desejado
	 * @return true se existir filmes e false se nao existir
	 * */
	private static boolean isEmpty(int idGen) {
		boolean resp = true;
		try {
			arq.seek(4);
			while(arq.getFilePointer() < arq.length() && resp) {
				char aux = arq.readChar();
				int tam = arq.readShort();
				byte[] array = new byte[tam];
				for(int i = 0; i < tam; i++) {
					array[i] = arq.readByte();
				}

				Filme filme = new Filme();
				filme.setByteArray(array);
				if(filme.getIDGenero() == idGen && aux != '*') {
					resp = false;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return resp;
	}//end isEmpty()

	/**
	 * Procura a existencia do genero
	 * @param genero a ser pesquisado
	 * @return true se ja existir ou false se nao existir
	 * */
	public static boolean searchGen(String genero) {
		boolean resp = false;

		try {
			gen.seek(4);
			while(gen.getFilePointer() < gen.length() && !resp) {
				char aux = gen.readChar();
				short tam = gen.readShort();
				byte[] dados = new byte[tam];
				gen.read(dados);
				Genero novoGen = new Genero();
				novoGen.setByteArray(dados);
				if(genero.equals(novoGen.getNomeGenero()) && aux != '*') {
					resp = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resp;
	}//end searchGen()

	/**
	 * Procura a existencia do genero pelo ID
	 * @param ID do genero a ser pesquisado
	 * @return true se existir genero com esse ID e false se nao existir
	 * */
	public static boolean searchGen(int genero) {
		boolean resp = false;
		Genero novoGen = new Genero();

		try {
			gen.seek(4);
			while(gen.getFilePointer() < gen.length() && !resp) {
				char auxC = gen.readChar();
				short tam = gen.readShort();
				byte[] dados = new byte[tam];
				gen.read(dados);
				novoGen.setByteArray(dados);

				if(novoGen.getID() == genero && auxC != '*') {
					resp = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(resp) {
			System.out.println("Genero escolhido: " + novoGen.getNomeGenero());
		}

		return resp;
	}//end searchGen()


	/**
	 * Escreve o filme no arquivo
	 * @param uma instancia de filme a ser gravada
	 * @param id do filme a ser gravado
	 * */
	public static void create(Filme filme, int id){
		try {
			if(id == -1) {
				if(arq.length() == 0) {
					id = 0;
				} else {
					arq.seek(0);
					id = arq.readInt();
					id++;
				}
			}
			arq.seek(0);
			arq.writeInt(id);
			arq.seek(arq.length());
			index.seek(searchIndex(id));
			index.writeInt(id);
			index.writeLong(arq.getFilePointer());
			filme.setId(id);
			filme.writeObject(arq);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}//end create()

	/**
	 * Deleta o filme do arquivo(alterando a lapide
	 * @param id do filme a ser deletado
	 * */
	public static void delete(int id) {
		long pointArq = searchPointer(id);
		if(pointArq !=-1){

			try{
				arq.seek(pointArq);
				arq.writeChar('*');
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		else
			System.out.println("Filme não encontrado!");
	}//end delete()

	/**
	 * Altera as informacoes do filme selecionado
	 * @param id do filme a ser alterado
	 * */
	public static void update(int id){
		long pointArq = searchPointer(id);

		if(pointArq !=-1){

			try{
				arq.seek(pointArq);
				arq.writeChar('*');
				Filme filme = criarObjetoFilme();
				create(filme,id);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		else
			System.out.println("Filme não encontrado!");

	}//end update()

	/**
	 * Pesquisa as informacoes de um filme no arquivo
	 * @param id do filme a ser pesquisado
	 * */
	public static void read(int id){
		long pointerArq = searchPointer(id);
		System.out.println(pointerArq);

		if(pointerArq != -1){
			try{
				arq.seek(pointerArq);
				if(arq.readChar() != '*') {
					int tam = arq.readShort();

					byte[] registro = new byte[tam];

					for(short i = 0 ; i < tam; i++)
						registro[i] = arq.readByte();

					Filme filme  = new Filme();

					filme.setByteArray(registro);
					System.out.println(filme.toString());
				} else {
					System.out.println("Filme não encontrado!");
				}

			}catch(IOException e ){
				e.printStackTrace();
			}
		} else {
			System.out.println("Filme não encontrado!");
		}
	}//end read()

	/**
	 * Encontra o ponteiro do inicio de um registro
	 * @param id do registro cujo ponteiro eh desejado
	 * @return ponteiro do registro desejado
	 * */
	private static long searchPointer(int id) {
		int idLido;
		long address = -1;
		boolean continuar = true;

		try {
			index.seek(0);
			while((index.getFilePointer() < index.length()) && continuar) {
				idLido = index.readInt();
				address = index.readLong();
				if(id == idLido) {
					continuar = false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return address;
	}//end searchPointer()

	/**
	 * Cria um objeto de filme com as informacoes da entrada
	 * @return uma instancia de Filme criada
	 * */
	public static Filme criarObjetoFilme(){
		Scanner input = new Scanner(System.in);
		String titulo,tituloOriginal,pais,diretor,sinopse;
		boolean existe = false;
		int idGen = -1;
		short ano;
		short min;

		Filme filme = null;

		System.out.print("Titulo: ");
		titulo = input.nextLine();

		System.out.print("Titulo Original: ");
		tituloOriginal = input.nextLine();

		System.out.print("Pais de origem: ");
		pais = input.nextLine();

		System.out.print("Diretor: ");
		diretor = input.nextLine();

		System.out.print("Sinopse: ");
		sinopse = input.nextLine();

		System.out.print("Ano: ");
		ano = input.nextShort();

		System.out.print("Minutos filme: ");
		min = input.nextShort();

		while(!existe) {
			System.out.print("Digite o ID do genero: ");
			idGen = input.nextInt();
			existe = searchGen(idGen);
			if(!existe) {
				System.out.println("ID inexistente!");
			}
		}


		System.out.print("Insira 1 para confirma inclusão ou 0 para cancelar: ");
		if(input.nextByte() == 1) {
			filme = new Filme(titulo,tituloOriginal,pais,ano,min,diretor,sinopse,idGen);
		}

		return filme;
	}//end criarObjetoFilme()

	/**
	 * Procura o endereco do filme no indice
	 * @param id do filme a ser procurado
	 * @return posicao do registro no arquivo
	 * */
	private static long searchIndex(int id) {
		long address = -1;
		int idLido =1;
		boolean continuar = true;
		try {
			address = index.length();
			index.seek(0);
			while((index.getFilePointer() < index.length()) && continuar) {
				long aux = index.getFilePointer();
				idLido = index.readInt();
				index.readLong();
				if(idLido == id) {
					continuar = false;
					address = aux;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return address;
	}//end searchIndex()

	/**
	 * Pesquisa a existencia de pelo menos 1 genero valido
	 * @return true se existir pelo menos 1 genero valido ou false se nao existir nenhum
	 * */
	public static boolean hasGen() {
		boolean resp = false;

		try{
			gen.seek(4);
			while(gen.getFilePointer() < gen.length() && !resp) {
				char auxC = gen.readChar();
				short tam = gen.readShort();
				gen.skipBytes(tam);
				if(auxC != '*') {
					resp = true;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

		return resp;
	}//end hasGen()
}//end Crud
