package Numbers_For_Loop;

public class NumLoop {
    public static void check_numbers_div()
    {
        for(int i=1;i<=100;i++)
        {
            if(i%2==0)
                System.out.println(i+" is divided by 2");
            if(i%3==0)
                System.out.println(i+" is divided by 3");
            if(i%4==0)
                System.out.println(i+" is divided by 4");
            if(i%5==0)
                System.out.println(i+" is divided by 5");

        }
    }
    public static void main(String[] args)
    {
        check_numbers_div();
    }
}
