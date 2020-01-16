import java.io.*;

public class Ator
{
  private int idAtor;
  private String nomeAtor;
  private String sexoAtor;

  //Contrutor generico
  public Ator()
  {
    this(0, "", "");
  }//end Ator

  //Construtor padrão
  public Ator(int idAtor, String nomeAtor, String sexoAtor)
  {
    this.idAtor = idAtor;
    this.nomeAtor = nomeAtor;
    this.sexoAtor = sexoAtor;
  }//end Ator

//---------- get(s) and set(s)-------------------------------------------------
  public int getIdAtor()
  {
    return(this.idAtor);
  }

  public void setIdAtor(int idAtor)
  {
    this.idAtor = idAtor;
  }

  public String getNomeAtor()
  {
    return(this.nomeAtor);
  }

  public void setNomeAtor(String nomeAtor)
  {
    this.nomeAtor = nomeAtor;
  }

  public String getSexoAtor()
  {
    return(this.sexoAtor);
  }

  public void setSexoAtor(int sexoAtor)
  {
    this.sexoAtor = sexoAtor;
  }
//----------end get(s) and set(s)----------------------------------------------

  public String toString()
  {
    return("\nID Ator...: " + this.idAtor +
           "\nNome: " + this.nomeAtor +
           "\nSexo: " + this.sexoAtor);
  }//end toString

  public byte[] getByteArray() throws IOException
  {
      ByteArrayOutputStream dados = new ByteArrayOutputStream();
      DataOutputStream saida = new DataOutputStream( dados );
      saida.writeInt(this.idAtor);
      saida.writeUTF(this.nomeAtor);
      saida.writeUTF(this.sexoAtor);
      return dados.toByteArray();
  }//end getByteArray

  public void setByteArray(byte[] b) throws IOException
  {
      ByteArrayInputStream dados = new ByteArrayInputStream(b);
      DataInputStream entrada = new DataInputStream(dados);
      this.idAtor = entrada.readInt();
      this.nomeAtor = entrada.readUTF();
      this.sexoAtor  = entrada.readUTF();
  }//end setByteArray
}//end classe
