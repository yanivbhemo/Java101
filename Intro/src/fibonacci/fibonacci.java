package fibonacci;

public class fibonacci {
    public static int printFib(int prev, int curr ,int counter)
    {
        if(counter<=0)
            return curr;
        if(prev == 0)
            System.out.print(prev + " " + curr + " ");
        else
            System.out.print(curr + " ");
        return printFib(curr,curr+prev,--counter);
    }
    public static void main(String [] args)
    {
        printFib(0,1,20);
    }
}
