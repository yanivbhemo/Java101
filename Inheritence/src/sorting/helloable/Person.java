package sorting.helloable;

interface Helloable{
    default public void sayGoodMorning(){
        System.out.println("Good Morning");
    }
    default public void sayGoodEvening(){
        System.out.println("Good Evening");
    }
}

public class Person implements Helloable {

}

class FrenchPerson extends Person{

}
