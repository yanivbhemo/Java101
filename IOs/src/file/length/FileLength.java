package file.length;
import java.io.*;

public class FileLength
{
    public static void main(String[] args)
    {
        String filePath = args[0];
        File fileObject = new File(filePath);
        FileInputStream fis = null;
        int count;
        try {
            fis = new FileInputStream(args[0]);
            while((count = fis.read())!=-1){
                System.out.write(count);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        long fileSize = fileObject.length();
        System.out.println("The size of the file is " + fileSize + " bytes.");
    }
}