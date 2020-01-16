/*
 * Exemplo da criação de um RELACIONAMENTO 1:N entre livros e categorias
 * Algoritmos e Estruturas de Dados III
 * Marcos Kutova
 */
package aed3;

import java.util.Scanner;

public class Livros_N_N {

    private static Scanner console = new Scanner(System.in);
    private static ArquivoIndexado<Livro> arqLivros;
    private static ArquivoIndexado<Categoria> arqCategorias;
    private static ArquivoIndexado<Autor> arqAutores;
    private static ArquivoIndexado<Autoria> arqAutorias;
    private static ArvoreBMais_ChaveComposta idxCategoriaLivro;
    private static ArvoreBMais_ChaveComposta idxLivroAutoria;
    private static ArvoreBMais_ChaveComposta idxAutorAutoria;

    /**
     * Método principal, cujo objetivo é criar uma interface para o usuário
     */
    public static void main(String[] args) {

        try {

            arqLivros = new ArquivoIndexado<>(Livro.class.getConstructor(), "livros.db", "livros1.idx", "livros2.idx");
            arqCategorias = new ArquivoIndexado<>(Categoria.class.getConstructor(), "categorias.db", "categorias1.idx", "categorias2.idx");
            arqAutores = new ArquivoIndexado<>(Autor.class.getConstructor(), "autores.db", "autores1.idx", "autores2.idx");
            arqAutorias = new ArquivoIndexado<>(Autoria.class.getConstructor(), "autorias.db", "autorias1.idx", "autorias2.idx");
            idxCategoriaLivro = new ArvoreBMais_ChaveComposta(10, "categoria_livro.idx");
            idxLivroAutoria = new ArvoreBMais_ChaveComposta(10, "livro_autoria.idx");
            idxAutorAutoria = new ArvoreBMais_ChaveComposta(10, "autor_autoria.idx");
            
            
            // menu
            int opcao;
            do {
                System.out.println("\n\nGESTÃO DE LIVROS");
                System.out.println("-----------------------------\n");
                System.out.println("LIVROS                   CATEGORIAS             AUTORES                AUTORIA");
                System.out.println("11 - Listar              21 - Listar            31 - Listar            41 - Listar");
                System.out.println("12 - Incluir             22 - Incluir           32 - Incluir           42 - Incluir");
                System.out.println("13 - Alterar             23 - Alterar           33 - Alterar           ");
                System.out.println("14 - Excluir             24 - Excluir           34 - Excluir           44 - Excluir");
                System.out.println("15 - Buscar por ID       25 - Buscar por ID     35 - Buscar por ID     45 - Livros do autor");
                System.out.println("16 - Buscar por título   26 - Buscar por nome   36 - Buscar por nome   46 - Autores do livro");
                System.out.println("                         27 - Listar livros");
                System.out.println("\n0 - Sair");
                System.out.print("\nOpcao: ");
                try {
                    opcao = Integer.valueOf(console.nextLine());
                } catch(java.lang.NumberFormatException e) {
                    opcao = -1;
                }

                switch(opcao) {
                    case 11: listarLivros(); break;
                    case 12: incluirLivro(); break;
                    case 13: alterarLivro(); break;
                    case 14: excluirLivro(); break;
                    case 15: buscarLivro(); break;
                    case 16: buscarLivroPorTitulo(); break;

                    case 21: listarCategorias(); break;
                    case 22: incluirCategoria(); break;
                    case 23: alterarCategoria(); break;
                    case 24: excluirCategoria(); break;
                    case 25: buscarCategoria(); break;
                    case 26: buscarCategoriaPorNome(); break;
                    case 27: listarLivrosCategoria(); break;

                    case 31: listarAutores(); break;
                    case 32: incluirAutor(); break;
                    case 33: alterarAutor(); break;
                    case 34: excluirAutor(); break;
                    case 35: buscarAutor(); break;
                    case 36: buscarAutorPorNome(); break;

                    case 41: listarAutorias(); break;
                    case 42: incluirAutoria(); break;
                    case 44: excluirAutoria(); break;
                    case 45: listarLivrosDoAutor(); break;
                    case 46: listarAutoresDoLivro(); break;

                    case 0: break;
                    default: System.out.println("Opção inválida!");
                }

            } while(opcao!=0);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    

    public static void listarLivros() throws Exception {

        Object[] obj = arqLivros.listar();
        Livro l;

        System.out.println("\nLISTA DE LIVROS");
        for(int i=0; i<obj.length; i++) {
            l = (Livro)obj[i];
            System.out.println( "\nID.......: " + l.id +
                                "\nTítulo...: " + l.titulo +
                                "\nPreço....: " + String.format("%.2f", l.preco) +
                                "\nCategoria: " + ((Categoria)arqCategorias.buscar(l.idCategoria)).getString() + " (id "+l.idCategoria+")" );
        }
        pausa();

    }
   
    public static void incluirLivro() throws Exception {
       
        String titulo;
        String autor;
        float  preco;
        int    idCategoria;
        Categoria cat;

        System.out.println("\nINCLUSÃO DE LIVRO");
        System.out.print("Título: ");
        titulo = console.nextLine();
        System.out.print("Preço: ");
        preco = Float.parseFloat(console.nextLine());

        System.out.print("Categoria: ");
        idCategoria = Integer.parseInt(console.nextLine());
        if((cat = (Categoria)arqCategorias.buscar(idCategoria))!=null )
            System.out.println("           "+cat.getString());
        else {
            System.out.println("Categoria não encontrada");
            pausa();
            return;
        }

        System.out.print("\nConfirma inclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='s' || confirma=='S') {
            Livro obj = new Livro(-1, titulo, preco, idCategoria);
            int id = arqLivros.incluir(obj);
            idxCategoriaLivro.inserir(idCategoria, id);
            System.out.println("Livro incluído com ID: "+id);
        }

        pausa();
    }

   
   public static void alterarLivro() throws Exception {
       
        System.out.println("\nALTERAÇÃO DE LIVRO");

        int id;
        System.out.print("ID do livro: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0) 
            return;

        Livro obj;
        if( (obj = (Livro)arqLivros.buscar(id))!=null ) {
            System.out.println( "\nID.......: " + obj.id +
                                "\nTítulo...: " + obj.titulo +
                                "\nPreço....: " + String.format("%.2f", obj.preco) +
                                "\nCategoria: " + ((Categoria)arqCategorias.buscar(obj.idCategoria)).getString() + " ("+obj.idCategoria+")" );
            int idCategoriaAnterior = obj.idCategoria;
            
            String titulo;
            String autor;
            float  preco;
            int    idCategoria;
            Categoria cat;
            
            System.out.print("\nNovo título: ");
            titulo = console.nextLine();
            System.out.print("Novo preço: ");
            String auxPreco = console.nextLine();
            if(auxPreco.compareTo("")==0)
                preco=-1f;
            else
                preco = Float.parseFloat(auxPreco);
            System.out.print("Nova categoria: ");
            String auxCat = console.nextLine();
            if(auxCat.compareTo("")==0)
                idCategoria=-1;
            else {
                idCategoria = Integer.parseInt(auxCat);
                if((cat = (Categoria)arqCategorias.buscar(idCategoria))!=null )
                    System.out.println("                "+cat.getString());
                else {
                    System.out.println("Categoria não encontrada");
                    pausa();
                    return;
                }
            }

            if(titulo.length()>0 || preco>=0 || idCategoria>=0) {
                System.out.print("\nConfirma alteração? ");
                char confirma = console.nextLine().charAt(0); 
                if(confirma=='s' || confirma=='S') {

                obj.titulo = (titulo.length()>0 ? titulo : obj.titulo);
                obj.preco = (preco>=0?preco:obj.preco);
                obj.idCategoria = (idCategoria>=0?idCategoria:obj.idCategoria);

                if( arqLivros.alterar(obj) ) 
                        System.out.println("Livro alterado.");
                        if(idCategoria>=0) {
                            idxCategoriaLivro.excluir(idCategoriaAnterior, obj.id);
                            idxCategoriaLivro.inserir(idCategoria, obj.id);
                        } else
                        System.out.println("Livro não pode ser alterado.");
                }
            }
        }
        else
            System.out.println("Livro não encontrado");
        pausa();

    }
  
   
    public static void excluirLivro() throws Exception {

        System.out.println("\nEXCLUSÃO DE LIVRO");

        int id;
        System.out.print("ID do livro: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0) 
            return;

        int[] idsAutorias = idxLivroAutoria.lista(id);
        if(idsAutorias.length>0) {
            System.out.println("Livro não pode ser excluído por possuir autores vinculados");
            pausa();
            return;
        }             

        Livro obj;
        if( (obj = (Livro)arqLivros.buscar(id))!=null ) {
             System.out.println( "\nID.......: " + obj.id +
                                 "\nTítulo...: " + obj.titulo +
                                 "\nPreço....: " + String.format("%.2f", obj.preco) +
                                 "\nCategoria: " + ((Categoria)arqCategorias.buscar(obj.idCategoria)).getString() + " (id "+obj.idCategoria+")" );

             System.out.print("\nConfirma exclusão? ");
             char confirma = console.nextLine().charAt(0);
             if(confirma=='s' || confirma=='S') {
                 if( arqLivros.excluir(id) ) {
                     idxCategoriaLivro.excluir(obj.idCategoria, obj.id);
                     System.out.println("Livro excluído.");
                 }
             }
        }
        else
            System.out.println("Livro não encontrado");
        pausa();

    }
   
   
    public static void buscarLivro() throws Exception {

        System.out.println("\nBUSCA DE LIVRO POR CÓDIGO");

        int codigo;
        System.out.print("Código: ");
        codigo = Integer.valueOf(console.nextLine());
        if(codigo <=0) 
            return; 

        Livro obj;
        if( (obj = (Livro)arqLivros.buscar(codigo))!=null ) {
             System.out.println( "\nID.......: " + obj.id +
                                 "\nTítulo...: " + obj.titulo +
                                 "\nPreço....: " + String.format("%.2f", obj.preco) +
                                 "\nCategoria: " + ((Categoria)arqCategorias.buscar(obj.idCategoria)).getString() + " (id "+obj.idCategoria+")" );
        }
        else
            System.out.println("Livro não encontrado");
        pausa();
    }
    
    public static void buscarLivroPorTitulo() throws Exception {

        System.out.println("\nBUSCA DE LIVRO POR TÍTULO");

        String titulo;
        System.out.print("Título: ");
        titulo = console.nextLine();

        Livro obj;
        if( (obj = (Livro)arqLivros.buscarString(titulo))!=null ) {
             System.out.println( "\nID.......: " + obj.id +
                                 "\nTítulo...: " + obj.titulo +
                                 "\nPreço....: " + String.format("%.2f", obj.preco) +
                                 "\nCategoria: " + ((Categoria)arqCategorias.buscar(obj.idCategoria)).getString() + " (id "+obj.idCategoria+")" );
        }
        else
            System.out.println("Livro não encontrado");
        pausa();
    }

    public static void listarCategorias() throws Exception {

        Object[] obj = arqCategorias.listar();

        System.out.println("\nLISTA DE CATEGORIAS");
        for(int i=0; i<obj.length; i++) {
            System.out.println((Categoria)obj[i]);
        }
        pausa();

    }

    public static void incluirCategoria() throws Exception {

        String nome;

        System.out.println("\nINCLUSÃO DE CATEGORIA");
        System.out.print("Nome: ");
        nome = console.nextLine();

        System.out.print("\nConfirma inclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='s' || confirma=='S') {
            Categoria obj = new Categoria(-1, nome);
            int id = arqCategorias.incluir(obj);
            System.out.println("Categoria incluída com ID: "+id);
        }

        pausa();
    }


    public static void alterarCategoria() throws Exception {

        System.out.println("\nALTERAÇÃO DE CATEGORIA");

        int id;
        System.out.print("ID da categoria: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0) 
            return;

        Categoria obj;
        if( (obj = (Categoria)arqCategorias.buscar(id))!=null ) {
             System.out.println(obj);

             String nome;

             System.out.print("\nNovo nome: ");
             nome = console.nextLine();

             if(nome.length()>0) {
                 System.out.print("\nConfirma alteração? ");
                 char confirma = console.nextLine().charAt(0);
                 if(confirma=='s' || confirma=='S') {

                 obj.nome = (nome.length()>0 ? nome : obj.nome);

                 if( arqCategorias.alterar(obj) ) 
                         System.out.println("Categoria alterada.");
                     else
                         System.out.println("Categoria não pode ser alterada.");
                 }
             }
        }
        else
            System.out.println("Categoria não encontrada");
        pausa();

    }


    public static void excluirCategoria() throws Exception {

        System.out.println("\nEXCLUSÃO DE CATEGORIA");

        int id;
        System.out.print("ID da categoria: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0) 
            return;

        int[] idsLivros = idxCategoriaLivro.lista(id);
        if(idsLivros.length>0) {
            System.out.println("Categoria não pode ser excluída por possuir livros");
            pausa();
            return;
        }       
        
        Categoria obj;
        if( (obj = (Categoria)arqCategorias.buscar(id))!=null ) {
             System.out.println(obj);

             System.out.print("\nConfirma exclusão? ");
             char confirma = console.nextLine().charAt(0);
             if(confirma=='s' || confirma=='S') {
                 if( arqCategorias.excluir(id) ) {
                     System.out.println("Categoria excluída.");
                 }
             }
        }
        else
            System.out.println("Categoria não encontrada");
        pausa();

    }


    public static void buscarCategoria() throws Exception {

        System.out.println("\nBUSCA DE CATEGORIA POR ID");

        int id;
        System.out.print("ID da categoria: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0) 
            return; 

        Livro obj;
        if( (obj = (Livro)arqCategorias.buscar(id))!=null )
            System.out.println(obj);
        else
            System.out.println("Categoria não encontrada");
        pausa();

    }

    public static void buscarCategoriaPorNome() throws Exception {

        System.out.println("\nBUSCA DE CATEGORIA POR NOME");

        String nome;
        System.out.print("Nome: ");
        nome = console.nextLine();

        Categoria obj;
        if( (obj = (Categoria)arqCategorias.buscarString(nome))!=null ) 
            System.out.println(obj);
        else
            System.out.println("Categoria não encontrada");
        pausa();
    }

    public static void listarLivrosCategoria() throws Exception {

        Livro l;

        System.out.println("\nLISTA DE LIVROS POR CATEGORIA");
        int id;
        System.out.print("ID da categoria: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0) 
            return; 

        int[] idsLivros = idxCategoriaLivro.lista(id);
        for(int i=0; i<idsLivros.length; i++) {
            l = (Livro)arqLivros.buscar(idsLivros[i]);
            System.out.println( "\nID.......: " + l.id +
                                "\nTítulo...: " + l.titulo +
                                "\nPreço....: " + String.format("%.2f", l.preco) +
                                "\nCategoria: " + ((Categoria)arqCategorias.buscar(l.idCategoria)).getString() + " (id "+l.idCategoria+")" );
        }
        pausa();

    }
   
    public static void listarAutores() throws Exception {

        Object[] obj = arqAutores.listar();

        System.out.println("\nLISTA DE AUTORES");
        for(int i=0; i<obj.length; i++) {
            System.out.println((Autor)obj[i]);
        }
        pausa();

    }

    public static void incluirAutor() throws Exception {

        String nome;

        System.out.println("\nINCLUSÃO DE AUTOR");
        System.out.print("Nome: ");
        nome = console.nextLine();

        System.out.print("\nConfirma inclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='s' || confirma=='S') {
            Autor obj = new Autor(-1, nome);
            int id = arqAutores.incluir(obj);
            System.out.println("Autor incluída com ID: "+id);
        }

        pausa();
    }


    public static void alterarAutor() throws Exception {

        System.out.println("\nALTERAÇÃO DE AUTOR");

        int id;
        System.out.print("ID do autor: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0) 
            return;

        Autor obj;
        if( (obj = (Autor)arqAutores.buscar(id))!=null ) {
             System.out.println(obj);

             String nome;

             System.out.print("\nNovo nome: ");
             nome = console.nextLine();

             if(nome.length()>0) {
                 System.out.print("\nConfirma alteração? ");
                 char confirma = console.nextLine().charAt(0);
                 if(confirma=='s' || confirma=='S') {

                 obj.nome = (nome.length()>0 ? nome : obj.nome);

                 if( arqAutores.alterar(obj) ) 
                         System.out.println("Autor alterado.");
                     else
                         System.out.println("Autor não pode ser alterado.");
                 }
             }
        }
        else
            System.out.println("Autor não encontrado");
        pausa();

    }


    public static void excluirAutor() throws Exception {

        System.out.println("\nEXCLUSÃO DE AUTOR");

        int id;
        System.out.print("ID dO AUTOR: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0) 
            return;

        int[] idsAutorias = idxAutorAutoria.lista(id);
        if(idsAutorias.length>0) {
            System.out.println("Autor não pode ser excluído por possuir livros");
            pausa();
            return;
        }       
        
        Autor obj;
        if( (obj = (Autor)arqAutores.buscar(id))!=null ) {
             System.out.println(obj);

             System.out.print("\nConfirma exclusão? ");
             char confirma = console.nextLine().charAt(0);
             if(confirma=='s' || confirma=='S') {
                 if( arqCategorias.excluir(id) ) {
                     System.out.println("Autor excluído.");
                 }
             }
        }
        else
            System.out.println("Autor não encontrado");
        pausa();

    }


    public static void buscarAutor() throws Exception {

        System.out.println("\nBUSCA DE AUTOR POR ID");

        int id;
        System.out.print("ID do autor: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0) 
            return; 

        Autor obj;
        if( (obj = (Autor)arqAutores.buscar(id))!=null )
            System.out.println(obj);
        else
            System.out.println("Autor não encontrado");
        pausa();

    }

    public static void buscarAutorPorNome() throws Exception {

        System.out.println("\nBUSCA DE AUTOR POR NOME");

        String nome;
        System.out.print("Nome: ");
        nome = console.nextLine();

        Autor obj;
        if( (obj = (Autor)arqAutores.buscarString(nome))!=null ) 
            System.out.println(obj);
        else
            System.out.println("Autor não encontrado");
        pausa();
    }

    public static void listarAutorias() throws Exception {

        Object[] obj = arqAutorias.listar();
        Autoria a;

        System.out.println("\nLISTA DE AUTORIAS");
        for(int i=0; i<obj.length; i++) {
            a = (Autoria)obj[i];
            System.out.println( "\nID....: " + a.id +
                                "\nTítulo: " + ((Livro)arqLivros.buscar(a.idLivro)).getString() + " (id "+a.idLivro+")" + 
                                "\nAutor.: " + ((Autor)arqAutores.buscar(a.idAutor)).getString() + " (id "+a.idAutor+")" );
        }
        pausa();

    }

    public static void incluirAutoria() throws Exception {
       
        int    idLivro, idAutor;
        Livro  l;
        Autor  a;

        System.out.println("\nINCLUSÃO DE AUTORIA");

        System.out.print("ID Livro: ");
        idLivro = Integer.parseInt(console.nextLine());
        if((l = (Livro)arqLivros.buscar(idLivro))!=null )
            System.out.println("           "+l.getString());
        else {
            System.out.println("Livro não encontrado");
            pausa();
            return;
        }

        System.out.print("ID Autor: ");
        idAutor = Integer.parseInt(console.nextLine());
        if((a = (Autor)arqAutores.buscar(idAutor))!=null )
            System.out.println("           "+a.getString());
        else {
            System.out.println("Autor não encontrado");
            pausa();
            return;
        }

        System.out.print("\nConfirma inclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='s' || confirma=='S') {
            Autoria obj = new Autoria(-1, idLivro, idAutor);
            int id = arqAutorias.incluir(obj);
            idxLivroAutoria.inserir(idLivro, id);
            idxAutorAutoria.inserir(idAutor, id);
            System.out.println("Autoria incluído com ID: "+id);
        }

        pausa();
    }
  
   
    public static void excluirAutoria() throws Exception {

        System.out.println("\nEXCLUSÃO DE AUTORIA");

        int id;
        System.out.print("ID da autoria: ");
        id = Integer.valueOf(console.nextLine());
        if(id <=0) 
            return;

        Autoria obj;
        if( (obj = (Autoria)arqAutorias.buscar(id))!=null ) {
            System.out.println( "\nID....: " + obj.id +
                                "\nTítulo: " + ((Livro)arqLivros.buscar(obj.idLivro)).getString() + " (id "+obj.idLivro+")" + 
                                "\nAutor.: " + ((Autor)arqAutores.buscar(obj.idAutor)).getString() + " (id "+obj.idAutor+")" );

             System.out.print("\nConfirma exclusão? ");
             char confirma = console.nextLine().charAt(0);
             if(confirma=='s' || confirma=='S') {
                 if( arqAutorias.excluir(id) ) {
                     idxLivroAutoria.excluir(obj.idLivro, obj.id);
                     idxAutorAutoria.excluir(obj.idAutor, obj.id);
                     System.out.println("Autoria excluída.");
                 }
             }
        }
        else
            System.out.println("Autoria não encontrado");
        pausa();

    }
   
    public static void listarLivrosDoAutor() throws Exception {

        System.out.println("\nLISTA DE LIVROS DE UM AUTOR");

        int idAutor;
        Autoria a;

        System.out.print("ID do autor: ");
        idAutor = Integer.valueOf(console.nextLine());
        if(idAutor <=0) 
            return;
        System.out.println(((Autor)arqAutores.buscar(idAutor)).getString() + " (id "+idAutor+")" );
        System.out.println("Livros:");

        int[] idsAutorias = idxAutorAutoria.lista(idAutor);
        for(int i=0; i<idsAutorias.length; i++) {
            a = (Autoria)arqAutorias.buscar(idsAutorias[i]);
            System.out.println( "- "+((Livro)arqLivros.buscar(a.idLivro)).getString() + " (id "+a.idLivro+")" ); 
        }
        pausa();

    }
   
    public static void listarAutoresDoLivro() throws Exception {

        System.out.println("\nLISTA DE AUTORES DE UM LIVRO");

        int idLivro;
        Autoria a;

        System.out.print("ID do livro: ");
        idLivro = Integer.valueOf(console.nextLine());
        if(idLivro <=0) 
            return;
        System.out.println(((Livro)arqLivros.buscar(idLivro)).getString() + " (id "+idLivro+")" );
        System.out.println("Autores:");

        int[] idsAutorias = idxLivroAutoria.lista(idLivro);
        for(int i=0; i<idsAutorias.length; i++) {
            a = (Autoria)arqAutorias.buscar(idsAutorias[i]);
            System.out.println( "- "+((Autor)arqAutores.buscar(a.idAutor)).getString() + " (id "+a.idAutor+")" ); 
        }
        pausa();

    }
   
   

    public static void pausa() throws Exception {
        System.out.print("\nPressione ENTER para continuar ...");
        console.nextLine();
    }
    

}
