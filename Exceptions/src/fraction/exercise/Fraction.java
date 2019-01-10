package fraction.exercise;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator_val, int denominator_val){
        this.numerator=numerator_val;
        this.denominator = denominator_val;
    }

    public static Fraction divide(Fraction f1, Fraction f2) throws FractionDivideByZeroException{
        if(f2.numerator == 0)
        {
            throw new FractionDivideByZeroException("Fraction 2 is Zero");
        }
        Fraction result = new Fraction(f1.numerator * f2.denominator,f1.denominator * f2.numerator);
        return result;
    }
}

class FractionDivideByZeroException extends Exception{
    FractionDivideByZeroException(String msg){
        super(msg);
    }
}

class Demo{
    public static void main(String[]args){
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(0,5);
        try{
            Fraction.divide(f1,f2);
        }
        catch (FractionDivideByZeroException e){
            e.printStackTrace();
        }
    }
}
