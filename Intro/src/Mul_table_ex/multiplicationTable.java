package Mul_table_ex;

public class multiplicationTable {
    public static void printTable()
    {
        int table[][] = new int[10][10];
        for(int i=0; i<=10;i++)
        {
            System.out.print(i+"  - ");
            for(int j=0;j<=10;j++)
            {
                System.out.print(i*j+"      ");
            }
            System.out.println();
        }
    }

    public static void main(String []args)
    {
        printTable();
    }
}
