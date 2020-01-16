import IO.*;

class Matriz
{
   public Object [][]tabela;
   
   public Matriz()
   {
      tabela = null;
   }
   
   public Matriz (int linha, int coluna)
   {
      if (linha <= 0 || coluna <= 0)
      {
         IO.println("ERRO: quantidade inválida!!");
      }
      else
      {
         tabela = new Object [linha][coluna];
      }
   }
   
   public int lines()
   {
      int linha = 0;
      
      if (tabela != null)
      {
         linha = tabela.length;
      }
      return(linha);
   }
   
   public int columns()
   {
      int coluna = 0;
      
      if (tabela != null)
      {
         coluna = tabela[0].length;
      }
      return(coluna);
   }
   
   public void printMatrix()
   {
      int x, y, linha, coluna;
      
      if(tabela == null)
      {
         IO.println("ERRO. Matriz vazia!!");
      }
      else
      {
         linha = lines();
         coluna = columns();
         
         IO.println("Matriz com "+linha+" x "+coluna+" posições: ");
         
         for ( x = 0; x < linha; x = x + 1 )
         {
            for ( y = 0; y < coluna; y = y + 1 )
            {
               IO.print ( "\t"+ tabela [ x ][ y ] );
            } 
            IO.println ( );
         } 
      }
   }
}

public class matriz01
{
   public static void main (String []args)
   {
      
   }
}