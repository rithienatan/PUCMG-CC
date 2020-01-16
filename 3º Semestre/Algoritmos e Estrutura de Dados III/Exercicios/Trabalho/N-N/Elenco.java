import java.io.*;

public class Elenco
{
  private int idElenco;
  private int idFilme;
  private int idAtor;
  private String nomePersonagem;

  //Construtor generico
  public Elenco()
  {
    this(0, 0, 0, "");
  }//end Elenco

  //Construtor padrão
  public Elenco(int idElenco, int idFilme, int idAtor, String nomePersonagem)
  {
    this.idElenco = idElenco;
    this.idFilme = idFilme;
    this.idAtor = idAtor;
    this.nomePersonagem = nomePersonagem;
  }//end Elenco

  //---------- get(s) and set(s)-----------------------------------------------
   public int getIdElenco()
   {
     return(this.idElenco);
   }

   public void setIdElenco(int idElenco)
   {
     this.idElenco = idElenco;
   }

    public int getIdAtor()
    {
      return(this.idAtor);
    }

    public void setIdAtor(int idAtor)
    {
      this.idAtor = idAtor;
    }

    public String getNomePersonagem()
    {
      return(this.nomePersonagem);
    }

    public void setNomePersonagem(String nomePersonagem)
    {
      this.nomeAtor = nomePersonagem;
    }

    public int getIdFilme()
    {
      return(this.idFilme);
    }

    public void setIdFilme(int idFilme)
    {
      this.idFilme = idFilme;
    }
  //----------end get(s) and set(s)--------------------------------------------

  public String toString()
  {
    return("\nID Elenco...: " + this.idElenco +
           "\nID Filme...: " + this.idFilme +
           "\nID Ator: " + this.nomeAtor +
           "\nPersonagem: " + this.nomePersonagem);
  }//end toString

  public byte[] getByteArray() throws IOException
  {
      ByteArrayOutputStream dados = new ByteArrayOutputStream();
      DataOutputStream saida = new DataOutputStream( dados );
      saida.writeInt(this.idElenco);
      saida.writeInt(this.idFilme);
      saida.writeInt(this.idAtor);
      saida.writeUTF(this.nomePersonagem);
      return dados.toByteArray();
  }//end getByteArray

  public void setByteArray(byte[] b) throws IOException
  {
      ByteArrayInputStream dados = new ByteArrayInputStream(b);
      DataInputStream entrada = new DataInputStream(dados);
      this.idElenco = entrada.readInt();
      this.idFilme = entrada.readInt();
      this.idAtor = entrada.readUTF();
      this.nomePersonagem = entrada.readUTF();
  }//end setByteArray
}//end class
