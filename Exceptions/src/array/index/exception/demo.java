package array.index.exception;

public class demo {
    public static void main(String[]args){
        int vec[] = new int[100];
        for(int i=0;i<100;i++){
            vec[i] = i + 1;
        }

        try
        {
            System.out.println(vec[100]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Oops. Something went wrong!");
            System.out.println(e);
        }
        finally{
            System.out.println("I tried to do this one too");
        }
    }
}
