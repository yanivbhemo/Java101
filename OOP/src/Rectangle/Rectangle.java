package Rectangle;

public class Rectangle {
    int side1, side2;
    public Rectangle(int side1_val,int side2_val)
    {
        this.side1 = side1_val;
        this.side2 = side2_val;
    }

    public int getArea()
    {
        return this.side1 * this.side2;
    }
}