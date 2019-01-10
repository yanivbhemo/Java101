package reverse.order.copy;

import java.io.*;

public class demo {
    public static void main(String[]args){
        FileReader in = null;
        FileWriter out = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

//        FileInputStream fis = null;
//        FileOutputStream fos = null;

        try{
//            fis = new FileInputStream(args[0]);
//            fos = new FileOutputStream(args[1]);
            in = new FileReader(args[0]);
            out = new FileWriter(args[1]);
            br = new BufferedReader(in);
            bw = new BufferedWriter(out);

            String currentLine = null;
            currentLine = br.readLine();
            while(currentLine!=null){
                System.out.println(currentLine);
                bw.write(currentLine,0,currentLine.length());
                bw.newLine();
                currentLine = br.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Exception appened");
        }
        finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(bw!=null) {
                try {
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
