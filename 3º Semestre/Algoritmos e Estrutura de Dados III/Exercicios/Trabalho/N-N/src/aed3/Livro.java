package aed3;
import java.io.*;

public class Livro implements Entidade {
    protected int    id;
    protected String titulo;
    protected float  preco;
    protected int    idCategoria;
    
    public Livro(int c, String t, float p, int i) {
        this.id = c;
        this.titulo = t;
        this.preco = p;
        this.idCategoria = i;
    }
    public Livro() {
        this.id = 0;
        this.titulo = "";
        this.preco = 0f;    
        this.idCategoria = -1;
    }
    
    public void setId(int c) {
        this.id = c;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getString() {
        return this.titulo;
    }
    
    public String toString() {
        return "\nID.......: " + this.id +
               "\nTítulo...: " + this.titulo +
               "\nPreço....: " + String.format("%.2f", this.preco) +
               "\nCategoria: " + this.idCategoria;
    }
    
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream dados = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( dados );
        saida.writeInt(this.id);
        saida.writeUTF(this.titulo);
        saida.writeFloat(this.preco);
        saida.writeInt(this.idCategoria);
        return dados.toByteArray();        
    }
    
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream dados = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(dados);
        this.id = entrada.readInt();
        this.titulo = entrada.readUTF();
        this.preco = entrada.readFloat();
        this.idCategoria = entrada.readInt();
    }


}
