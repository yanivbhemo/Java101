package numeric.base.translation;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Demo {
    public static void main(String[]args){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        int num = reader.nextInt();
        System.out.println("Enter a base: ");
        int base = reader.nextInt();
        reader.close();
        int result = 0;
        try {
            result = ConvertBase(num,base);
        }
        catch (InCorrectParsingException e){
            e.printStackTrace();
        }
        System.out.println(result);

        //System.out.println(num + " in base " + base + " = " + result);
    }

    public static int ConvertBase(int num,int base) throws InCorrectParsingException
    {
        if(base > 10) throw new InCorrectParsingException("Impossible to convert HEX base to int");
        return parseInt(Integer.toString(num,base));
    }
}

class InCorrectParsingException extends Exception{
    InCorrectParsingException(String msg){
        super(msg);
    }
}