/**
 * Estudo Dirigido 12
 *
 *
 * Nome: Rithie Natan   Versão: 0.1
 * Matrícula: 541488    Data: 08/05/2016
 
   Exemplo0240
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
   public String fone2;

   public Contato ( )
   {
      nome = null;
      fone = null;
      fone2 = null;
   } 
   
   public String getNome ( )
   {
      return ( nome );
   } 

   public String getFone ( )
   {
      return ( fone );
   }
 
   public String getFone2 ( )
   {
      return ( fone2 );
   }
   
   public void setNome ( String novoNome )
   {
      nome = novoNome;
   } 

   public void setFone ( String novoFone )
   {
      fone = novoFone;
   }
   
   public void setFone2 ( String novoFone )
   {
      fone2 = novoFone;
   }
   
   private boolean validFone ( )
   {
      boolean resposta = false;
      int posicao;
      int tamanho = fone.length( );
      
      for( posicao = 0; posicao < tamanho; posicao = posicao + 1 )
      {
         if( fone.charAt( posicao ) >= '0' || fone.charAt( posicao ) <= '9' || 
             fone.charAt( posicao ) >= '-')
         {
            resposta = true;
         }
         if( fone2.charAt( posicao ) >= '0' || fone2.charAt( posicao ) <= '9' || 
             fone2.charAt( posicao ) >= '-')
         {
            resposta = true;
         }  
      }
      return( resposta );
   }
   
   public Contato (String nomeInicial, String foneInicial, String fone2Inicial )
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
      else
      {
         setNome( nomeInicial );
         setFone( foneInicial );
         setFone( fone2Inicial );
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
   
   public void readFone2 ( String msn )
   {
      if( validFone( ) )
      {
         IO.println( "" + msn + "" + fone2 );
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
   
   public int telefones( )
   {
      int n = 0;
      
      if( validFone( ) )
      {
         n = n + 1;
      }
      return( n );
   } 
   
   public void setFone2a( String telefone )
   {
      String novoFone2;
      if( validFone( ) )
      {
         novoFone2 = IO.readString( "Digite o novo fone2: " );
         telefone = novoFone2;
      }
   }
   
   public void setFone2b( String telefone )
   {
      String novoFone2;
      if( validFone( ) )
      {
         novoFone2 = IO.readString( "Digite o novo fone2: " );
         telefone = novoFone2;
      }
   }
   
   public void setFone2c( String telefone )
   {
      if( validFone( ) )
      {
         telefone = null;
      }
   }  
}

public class Exemplo0240
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
         teste.setFone2 ( "1111-1111" );
         int n = teste.telefones( );
         //teste.fromFile ( "Pessoa1.txt" );
         if ( teste.hasErro ( ) )
         {
            IO.println ( "Contato teste com erro " + teste.getErro ( ) );
         }
         else
         {
            IO.println ( "Contato teste nao nulo com " );
            teste.readNome ( "Nome: " );
            teste.readFone ( "Fone: " );
            teste.readFone2 ( "Fone2: " );
            IO.println( "Quantos telefones: " + n );
            
            teste.setFone2a ( "3333-3333" );
            teste.setFone2b ( "3333-3333" );
            teste.setFone2c ( "3333-3333" );
            
            teste.toFile ( "Pessoa1.txt" );
         } 
      } 
   } 

   public static void main ( String [ ] args )
   {
      Exemplo0240 teste = new Exemplo0240( );
      teste.acao( );
   } 
}