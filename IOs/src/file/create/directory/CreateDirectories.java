package file.create.directory;

import java.io.*;

public class CreateDirectories
{
    public static void main(String[] args)
    {
        File file = new File(args[0]);
        file.mkdir();
        boolean succeeded = file.exists();
        if(succeeded)
        {
            System.out.println("The directories were successfully created");
        }
        else
        {
            System.out.println("The directories were not created");
        }
    }
}