package shapes;

import org.w3c.dom.css.Rect;

abstract class Shape
{
    public abstract double area();
    public String toString()
    {
        String str="The area is " + area();
        return str;
    }
}

class Circle extends Shape{
    private int radius;
    Circle(int radius_val)
    {
        this.radius = radius_val;
    }

    @Override
    public double area() {
        return 0.5*2*3.141*radius*radius;
    }
}

class Rectangle extends Shape{
    private int x;
    private int y;
    Rectangle(int x_val, int y_val){
        this.x=x_val; this.y=y_val;
    }
    @Override
    public double area() {
        return x*y;
    }
}

    //Check your classes using the following application:
class Test {
        public static void main(String args[]) {
            Shape vec[] = {new Circle(3), new Rectangle(4, 5), new Circle(4), new Circle(8)};
            for (int index = 0; index < vec.length; index++) {
                System.out.println(vec[index]);
            }
        }
    }