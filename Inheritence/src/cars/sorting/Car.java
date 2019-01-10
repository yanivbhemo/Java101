package cars.sorting;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Car{
    protected int horse_power;
    protected String type;

    public Car(int h_power_val,String type_val){
        this.horse_power = h_power_val;
        this.type=type_val;
    }

    public String toString(){
        String str = this.type + " - " + this.horse_power;
        return str;
    }
}

class SortByHP implements Comparator<Car>{
    public int compare(Car c1, Car c2)
    {
        return c1.horse_power - c2.horse_power;
    }
}

class SportCar extends Car{
    protected boolean premium;
    public SportCar(int h_power_val,String type_val,boolean premium){
        super(h_power_val,type_val);
        this.premium = premium;
    }
    public String toString(){
        String str = this.type + " - " + this.horse_power + " - " + this.premium;
        return str;
    }
}

class RacingCar extends SportCar{
    private String menufactor;
    public RacingCar(int h_power_val,String type_val,boolean premium,String menufactor_val)
    {
        super(h_power_val,type_val,premium);
        this.menufactor=menufactor_val;
    }

    public String toString(){
        String str = this.type + " - " + this.horse_power + " - " + this.premium + " - " + this.menufactor;
        return str;
    }
}
