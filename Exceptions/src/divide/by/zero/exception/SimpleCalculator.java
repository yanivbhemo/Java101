package divide.by.zero.exception;
import java.awt.*;
import java.awt.event.*;


class ImpossibleComputationException extends Exception
{
    //complete the missing code
    ImpossibleComputationException(String msg){
        super(msg);
    }
}

public class SimpleCalculator implements ActionListener
{

    private Button bt1, bt2, bt3, bt4;
    private TextField tf1, tf2, tf3;
    private double result;
    private Frame frame;
    private Panel panel1, panel2, panel3;

    public static void main (String args[])
    {
        SimpleCalculator operator = new SimpleCalculator();
        operator.go();
    }

    public void doPlus()
    {
        result = Double.parseDouble(tf1.getText()) + Double.parseDouble(tf2.getText());
        tf3.setText(String.valueOf(result));
    }

    public void doMinus()
    {
        result = Double.parseDouble(tf1.getText()) - Double.parseDouble(tf2.getText());
        tf3.setText(String.valueOf(result));
    }

    public void doMult()
    {
        result = Double.parseDouble(tf1.getText()) * Double.parseDouble(tf2.getText());
        tf3.setText(String.valueOf(result));
    }

    public void doDiv() throws ImpossibleComputationException
    {
        if (Double.parseDouble(tf2.getText())==0)
        {
            //complete the missing code
            throw new ImpossibleComputationException("You can't divide in ZERO");

        }
        else
        {
            result = Double.parseDouble(tf1.getText()) / Double.parseDouble(tf2.getText());
            tf3.setText(String.valueOf(result));
        }
    }

    public void go()
    {
        frame = new Frame("Simple Calculator");
        bt1 = new Button("+");
        bt2 = new Button("-");
        bt3 = new Button("*");
        bt4 = new Button("/");
        tf1 = new TextField(20);
        tf2 = new TextField(20);
        tf3 = new TextField(53);
        panel1 = new Panel();
        panel2 = new Panel();
        panel3 = new Panel();
        frame.setLayout(new GridLayout(3,1));
        panel1.add(tf1);
        panel1.add(tf2);
        panel2.add(bt1);
        panel2.add(bt2);
        panel2.add(bt3);
        panel2.add(bt4);
        panel3.add(tf3);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.setSize(400, 200);
        frame.setBackground(Color.blue);
        frame.setVisible(true);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        frame.addWindowListener(new WindowAdapter()
                                {
                                    public void windowClosing(WindowEvent event)
                                    {
                                        frame.dispose();
                                        System.exit(0);
                                    }
                                }
        );
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if (e.getActionCommand()=="+")
            {
                doPlus();
            }
            else
            {
                if (e.getActionCommand()=="-")
                {
                    doMinus();
                }
                else
                {
                    if (e.getActionCommand()=="*")
                    {
                        doMult();
                    }
                    else
                    {
                        doDiv();
                    }
                }
            }
        }
        catch(ImpossibleComputationException ex)
        {
            tf3.setText(ex.getMessage());
        }
        catch(NumberFormatException ex2)
        {
            tf3.setText("One of the parameters can't be converted to integer number");
        }
    }
} 