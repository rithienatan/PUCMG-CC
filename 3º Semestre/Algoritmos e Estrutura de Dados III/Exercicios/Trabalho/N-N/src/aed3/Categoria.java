package aed3;
import java.io.*;

public class Categoria implements Entidade {
    protected int    id;
    protected String nome;
    
    public Categoria(int c, String n) {
        this.id = c;
        this.nome = n;
    }
    public Categoria() {
        this.id = 0;
        this.nome = "";
    }
    
    public void setId(int c) {
        this.id = c;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getString() {
        return this.nome;
    }
    
    public String toString() {
        return "\nCódigo...: " + this.id +
               "\nCategoria: " + this.nome ;
    }
    
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream dados = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( dados );
        saida.writeInt(this.id);
        saida.writeUTF(this.nome);
        return dados.toByteArray();        
    }
    
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream dados = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(dados);
        this.id = entrada.readInt();
        this.nome = entrada.readUTF();
    }


}
