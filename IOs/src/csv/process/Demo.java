package csv.process;
import java.io.*;

class SaleEntry{
    private String title;
    private int fee;
    private int amount;

    public SaleEntry(String title, int fee, int amount) {
        this.title = title;
        this.fee = fee;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

public class Demo {
    public static void main(String[]args){
        String csvFilePath = args[0];
        BufferedReader br = null;
        String line = "";
        String delimeter = ",";

        try{
            br = new BufferedReader(new FileReader(csvFilePath));
            long sum = 0;
            br.readLine();
            while((line = br.readLine())!=null){
                String[] record = line.split(delimeter);
                sum += (Float.parseFloat(record[1]) * Float.parseFloat(record[2]));
            }
            System.out.println("Amount of sales: " + sum);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(br!=null){
                try{
                    br.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
