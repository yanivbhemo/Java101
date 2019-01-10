package utility_methods;

public class digits {
    public static int numOfDigits(int num)
    {
        int counter=0;
        while(num > 0)
        {
            counter++;
            num /= 10;
        }
        return counter;
    }
    public static int sumOfDigits(int num)
    {
        int sum=0;
        while(num > 0)
        {
            sum+=num%10;
            num /= 10;
        }
        return sum;
    }
}
