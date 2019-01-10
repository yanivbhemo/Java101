package cars.sorting;
import java.util.Arrays;

public class SortingCarsDemo
{
    public static void main(String[] args)
    {
        Car vec[] = new Car[4];
        vec[0] = new SportCar(180,"Toyota Celica",true);
        vec[1] = new Car(20,"Susita");
        vec[2] = new RacingCar(300,"Ferari",true,"ABC Company");
        vec[3] = new Car(56,"Carmel Ducas");

        System.out.println("before sorting...");
        for(int i=0; i<vec.length; i++)
        {
            System.out.println(vec[i]);
        }

        Arrays.sort(vec,new SortByHP());

        System.out.println("\nafter sorting...");
        for(int i=0; i<vec.length; i++)
        {
            System.out.println(vec[i]);
        }
    }

}
