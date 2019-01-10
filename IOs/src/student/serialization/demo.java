package student.serialization;
import java.io.*;
import java.util.concurrent.ExecutionException;

public class demo {
    public static void main(String[]args)
    {
        String fname = args[0];
        String lname = args[1];
        int id = Integer.parseInt(args[2]);
        int tel = Integer.parseInt(args[3]);
        double markAvg = Double.parseDouble(args[4]);
        Student s1 = new Student(fname,lname,id,tel,markAvg);

        File stout_dir = new File("StudentsDir");
        stout_dir.mkdir();

        FileWriter out1 = null;
        BufferedWriter bw1 = null;
        try{
            out1 = new FileWriter("StudentsDir/" + args[0] + " " +args[1]);
            bw1 = new BufferedWriter(out1);
            bw1.write(s1.getfName() + " " + s1.getlName() + " " + s1.getId() + " " + s1.getTel() + " " + s1.getMarkAvg());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            if(bw1!=null){
                try {
                    bw1.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
}

class FindAStudent{
    public static void main(String[]args){
        int id_to_check = Integer.parseInt(args[0]);

        FileReader in = null;
        BufferedReader br = null;

        File student_dir = new File("StudentsDir");
        if(student_dir.exists())
        {
            File[] files_list = student_dir.listFiles();
            for(File single_stu_file: files_list){
                System.out.println("Check: " + single_stu_file.getName());
                try{
                    in = new FileReader(single_stu_file);
                    br = new BufferedReader(in);
                    String[] st_to_check = br.readLine().split(" ");
                    if(Integer.parseInt(st_to_check[2]) == id_to_check){
                        System.out.println("Match found");
                        return;
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else{
            System.out.println("There is no files in the specified directory");
        }
    }
}

class Student{
    private String fName;
    private String lName;
    private int id;
    private int tel;
    private double markAvg;

    public Student(String fName, String lName, int id, int tel, double markAvg) {
        this.fName = fName;
        this.lName = lName;
        this.id = id;
        this.tel = tel;
        this.markAvg = markAvg;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getId() {
        return id;
    }

    public int getTel() {
        return tel;
    }

    public double getMarkAvg() {
        return markAvg;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setMarkAvg(double markAvg) {
        this.markAvg = markAvg;
    }
}