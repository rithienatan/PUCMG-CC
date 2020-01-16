/**
 * Estudo Dirigido 12
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 08/05/2016
 
   Exemplo0231
 
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
   
   public Contato (String nomeInicial, String foneInicial )
   {
      setErro ( 0 );
      if( nomeInicial == null || nomeInicial == "" )
      {
         setErro ( 1 );
      }
      else if ( foneInicial == null || foneInicial == "" )
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
      if( fone != null || fone != "" )
      {
         IO.println( "" + msn + "" + fone );
      }
   } 
}

public class Exemplo0231
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
         teste.setNome ( "nome3" );
         teste.setFone ( "3333-3333" );
         if ( teste.hasErro ( ) )
         {
            IO.println ( "Contato teste com erro " + teste.getErro ( ) );
         }
         else
         {
            IO.println ( "Contato teste nao nulo com " );
            teste.readNome ( "Nome: " );
            teste.readFone ( "Fone: " );
         } 
      } 
   } 

   public static void main ( String [ ] args )
   {
      Exemplo0231 teste = new Exemplo0231 ( );
      teste.acao( );
   } 
}