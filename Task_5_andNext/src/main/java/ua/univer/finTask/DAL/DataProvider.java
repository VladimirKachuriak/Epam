package ua.univer.finTask.DAL;




import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class DataProvider<T> {
    String connection;

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public void write(T obj){
        try(XMLEncoder out = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream(Filepath.Path+connection)))){
            out.writeObject(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public T read(){
        XMLDecoder in= null;
        T obj = null;
        try {
            in = new XMLDecoder( new BufferedInputStream(
                    new FileInputStream(Filepath.Path+connection)));
            obj = (T) in.readObject();
            in.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("File not found");
        }
        return  obj;
    }
}
