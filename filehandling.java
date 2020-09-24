import java.io.IOException;
import java.io.RandomAccessFile;

public class filehandling
{ 
    public static void main(String[] args) throws IOException 
    { 
        RandomAccessFile raf1 = new RandomAccessFile("test.txt", "rw");
        RandomAccessFile raf2 = new RandomAccessFile("target.txt", "rw");


        raf1.seek(0);
        try 
        {
            raf1.seek(0);
            raf1.writeInt(7);
            raf1.writeInt(5);
            raf1.writeInt(77);
            raf1.writeInt(7743);
            raf1.writeInt(377);
            raf1.writeInt(737);
            raf1.writeInt(7337);
            raf1.writeInt(3);
            raf1.writeInt(737);
            
            raf1.seek(0);
            while (raf1.getFilePointer()<raf1.length())
               System.out.println(raf1.readInt());
    
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        finally
        {
            raf1.close();
            raf2.close();
        }
    } 
} 