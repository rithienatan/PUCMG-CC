package aed3;
import java.io.*;
import java.util.*;
import java.lang.reflect.Constructor;

public class ArquivoIndexado<T extends Entidade> {

    RandomAccessFile arquivo;
    String nomeArquivo;
    Constructor<T> construtor;
    ArvoreBMais_Int_Long indice1;
    ArvoreBMais_String_Int indice2;
    
    public ArquivoIndexado(Constructor<T> c, String n, String in1, String in2) throws Exception {
        nomeArquivo = n;
        construtor = c;
        arquivo = new RandomAccessFile(nomeArquivo, "rw");
        if(arquivo.length()<4)
            arquivo.writeInt(0);
        indice1 = new ArvoreBMais_Int_Long(10, in1);
        indice2 = new ArvoreBMais_String_Int(10, in2);
    }
    
    public int incluir(T obj) throws Exception {
        arquivo.seek(0);
        int id = arquivo.readInt();
        id++;
        arquivo.seek(0);
        arquivo.writeInt(id);

        arquivo.seek(arquivo.length());
        long endereco = arquivo.getFilePointer();
        obj.setId(id);
        arquivo.writeByte(' ');
        byte[] b = obj.getByteArray();
        arquivo.writeInt(b.length);
        arquivo.write(b);
        indice1.inserir(id, endereco);
        indice2.inserir(obj.getString(), obj.getId()); // o índice é indireto
        
        return id;
    }
    
    public Object[] listar() throws Exception {
        
        // Em um sistema real, o número de registros será muito superior ao que
        // um ArrayList poderia comportar em memória. Esta operação está aqui
        // apenas para facilitar a depuração do código
        ArrayList<T> lista = new ArrayList<>();
        arquivo.seek(4);
        byte lapide;
        byte[] b;
        int s;
        T l;
        while(arquivo.getFilePointer()<arquivo.length()) {
            l = construtor.newInstance();
            lapide = arquivo.readByte();
            s = arquivo.readInt();
            b = new byte[s];
            arquivo.read(b);
            l.setByteArray(b);
            if(lapide==' ')
                lista.add(l);
        }
        
        Object[] ls = lista.toArray();
        return ls;
    }
    
    public Entidade buscar(int id) throws Exception {
        
        T obj = construtor.newInstance();
        byte lapide;
        byte[] b;
        int s;
        long endereco;
        
        if( (endereco = indice1.buscar(id))>=0 ) {
            arquivo.seek(endereco);
            lapide = arquivo.readByte();
            s = arquivo.readInt();
            b = new byte[s];
            arquivo.read(b);
            obj.setByteArray(b);
            arquivo.seek(endereco);
            return obj;
        }
        else 
            return null;
    }

    public Entidade buscarString(String t) throws Exception {
        
        T obj = construtor.newInstance();
        byte lapide;
        byte[] b;
        int s;
        long endereco;
        int id;
        
        if( (id = indice2.buscar(t))>=0 ) {
            endereco = indice1.buscar(id);
            arquivo.seek(endereco);
            lapide = arquivo.readByte();
            s = arquivo.readInt();
            b = new byte[s];
            arquivo.read(b);
            obj.setByteArray(b);
            return obj;
        }
        else 
            return null;
    }
    
    
    public boolean excluir(int id) throws Exception {
        
        byte[] b;
        int s;
        T obj = construtor.newInstance();
        long endereco = indice1.buscar(id);
        arquivo.seek(endereco);
        arquivo.write('*');
        s = arquivo.readInt();
        b = new byte[s];
        arquivo.read(b);
        obj.setByteArray(b);
        indice1.excluir(id);
        indice2.excluir(obj.getString());
        
        return true;
    }
    
    public boolean alterar(T novoObj) throws Exception {
        byte[] b;
        int s;
        T obj = construtor.newInstance();
        long endereco = indice1.buscar(novoObj.getId());
        arquivo.seek(endereco);
        arquivo.write('*');
        s = arquivo.readInt();
        b = new byte[s];
        arquivo.read(b);
        obj.setByteArray(b);

        arquivo.seek(arquivo.length());
        endereco = arquivo.getFilePointer();
        arquivo.writeByte(' ');
        b = novoObj.getByteArray();
        arquivo.writeInt(b.length);
        arquivo.write(b);
        indice1.atualizar(novoObj.getId(), endereco);
        if(novoObj.getString().compareTo(obj.getString()) != 0) {
            indice2.excluir(obj.getString());
            indice2.inserir(novoObj.getString(), novoObj.getId());
        }
        return true;
    }    

}
