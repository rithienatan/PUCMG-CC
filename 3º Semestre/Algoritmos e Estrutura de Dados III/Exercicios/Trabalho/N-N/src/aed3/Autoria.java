package aed3;
import java.io.*;

public class Autoria implements Entidade {
    protected int   id;
    protected int   idLivro;
    protected int   idAutor;
    // quaisquer outros dados específicos da autoria devem ser incluidos aqui
    // por exemplo, poderíamos incluir a lista de capítulos dos quais este autor
    // participou neste livro
    
    public Autoria(int c, int l, int a) {
        this.id = c;
        this.idLivro = l;
        this.idAutor = a;
    }
    public Autoria() {
        this.id = 0;
        this.idLivro = 0;
        this.idAutor = 0;
    }
    
    public void setId(int c) {
        this.id = c;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getString() {
        return idLivro+""+idAutor;
    }
    
    public String toString() {
        return "\nID...: " + this.id +
               "\nLivro: " + this.idLivro +
               "\nAutor: " + this.idAutor;
    }
    
    public byte[] getByteArray() throws IOException {
        ByteArrayOutputStream dados = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream( dados );
        saida.writeInt(this.id);
        saida.writeInt(this.idLivro);
        saida.writeInt(this.idAutor);
        return dados.toByteArray();        
    }
    
    public void setByteArray(byte[] b) throws IOException {
        ByteArrayInputStream dados = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(dados);
        this.id = entrada.readInt();
        this.idLivro = entrada.readInt();
        this.idAutor = entrada.readInt();
    }


}
