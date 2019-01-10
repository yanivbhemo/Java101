package rivate.members.access;

//Access from outer class to inner class
class Employee{
    private String name;
    int age;
    private int salary;
    private Manager boss;

    public Employee(){
        this.name = "John Doe";
        this.age = 24;
        this.salary = 5300;
        boss = new Manager();
    }

    class Manager{
        private int bonus;
        private boolean company_car;
        private Employee e1;

        public Manager(){
            this.bonus = 1000;
            this.company_car = true;
            this.e1 = new Employee();
        }
    }
}

public class demo {
    public static void main(String[]args){
        Employee e1 = new Employee();
        System.out.println(e1.age);

        return;
    }
}