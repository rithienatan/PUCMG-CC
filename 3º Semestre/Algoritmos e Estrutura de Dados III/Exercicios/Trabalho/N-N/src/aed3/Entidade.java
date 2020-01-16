package aed3;
import java.io.*;

public interface Entidade  {
    
    public void setId(int codigo);
    public int getId();
    public String getString();   // retorna um campo string qualquer (nome, título, descricao, etc.)

    public byte[] getByteArray() throws IOException;
    public void setByteArray(byte[] b) throws IOException;
    
}
