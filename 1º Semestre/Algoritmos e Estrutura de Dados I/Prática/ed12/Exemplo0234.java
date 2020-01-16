/**
 * Estudo Dirigido 12
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 08/05/2016
 
   Exemplo0234
 
 *@version 01
*
*/
import IO.*;

class Contato
{
   private int erro;
  
   public boolean hasErro ( )
   {
      return ( getErro( ) != 0 );
   } 
   
   public int getErro ( )
   {
      return ( erro );
   } 

   private void setErro ( int codigo )
   {
      erro = codigo;
      
      switch( erro )
      {
         case 1:
            IO.println( "1. ERROR: Nome Inválido!" );
            break;
         case 2:
            IO.println( "2. ERROR: Fone Inválido!" );
            break;
         case 3:
            IO.println( "3. ERRO: Problema ao copiar!" );
            break;
      } 
   }

   public String nome;
   public String fone;

   public Contato ( )
   {
      nome = null;
      fone = null;
   } 
   
   public String getNome ( )
   {
      return ( nome );
   } 

   public String getFone ( )
   {
      return ( fone );
   }
 
   public void setNome ( String novoNome )
   {
      nome = novoNome;
   } 

   public void setFone ( String novoFone )
   {
      fone = novoFone;
   }
   
   private boolean validFone ( )
   {
      boolean resposta = false;
      int posicao;
      int tamanho = fone.length( );
      
      for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
      {
         if( fone.charAt( posicao ) >= 'A' || fone.charAt( posicao ) <= 'Z' || 
             fone.charAt( posicao ) >= 'a' || fone.charAt( posicao ) <= 'z' || 
             fone == "" || fone == null )
         {
            resposta = true;
         }
      }
      return( resposta );
   }
   
   public Contato (String nomeInicial, String foneInicial )
   {
      setErro ( 0 );
      if( nomeInicial == null || nomeInicial == "" )
      {
         setErro ( 1 );
      }
      else if ( validFone( ) )
      {
         setErro ( 2 );
      }
      else if( nomeInicial != null && foneInicial != null )
      {
         setNome( nomeInicial );
         setFone( foneInicial );
      } 
   }
   
   public String toString ( )
   {
      return ( ""+nome+" - "+fone );
   } 
   
   public Contato clone ( )
   {
      Contato copia = new Contato ( );
      if ( copia == null || hasErro( ) )
      {
         setErro ( 3 );
      }
      else
      {
         if ( copia != null )
         {
            copia.setNome ( getNome( ) );
            copia.setFone ( getFone( ) );
         } 
      } 
      return ( copia );
   } 
   
   public void readNome ( String msn )
   {
      if( nome != null || nome != "" )
      {
         IO.println( "" + msn + "" + nome );
      }
   }
   
   public void readFone ( String msn )
   {
      if( validFone( ) )
      {
         IO.println( "" + msn + "" + fone );
      }
   }
   
   public void fromFile( String namefile )
   {
      FILE arquivo = new FILE( FILE.INPUT, namefile );
      String line;
      
      line = arquivo.readln( );
      
      if( line == null )
      {
         IO.println( "ERRO: Aqruivo vazio!" );
      }
      else
      {
         IO.println( "Tamanho do arquivo: "+line );
         
         while( !arquivo.eof( ) )
         {
            line = arquivo.readln( );
            
            nome = line;
         
            line = arquivo.readln( );
         
            fone = line;
         }
         arquivo.close( );
      } 
   }
   
   public void toFile( String namefile )
   {
      FILE arquivo = new FILE( FILE.OUTPUT, namefile );
      int contador = 0;
      
      if(  nome != null || nome != "" || validFone( ) )
      {
         contador = contador + 1;
      }
      arquivo.println( ""+contador );
      
      arquivo.println( ""+nome );
      arquivo.println( ""+fone );
      
      arquivo.close( );
   }   
}

public class Exemplo0234
{
   public void acao ( )
   {
      Contato teste = new Contato ( );
      
      if ( teste == null )
      {
         IO.println ( "Contato teste nulo" );
      }
      else
      {
         //teste.setNome ( "nome3" );
         //teste.setFone ( "3333-3333" );
         teste.fromFile ( "Pessoa1.txt" );
         if ( teste.hasErro ( ) )
         {
            IO.println ( "Contato teste com erro " + teste.getErro ( ) );
         }
         else
         {
            IO.println ( "Contato teste nao nulo com " );
            teste.readNome ( "Nome: " );
            teste.readFone ( "Fone: " );
            //teste.toFile ( "Pessoa1.txt" );
         } 
      } 
   } 

   public static void main ( String [ ] args )
   {
      Exemplo0234 teste = new Exemplo0234 ( );
      teste.acao( );
   } 
}