package additional.members.exercise;
import java.lang.reflect.*;

public class ReflectionDemo
{
    private static String name;
    private static int blanks;

    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out
                    .println("\nERROR: You should give a name of ONE class !");
            return;
        }
        name = args[0];
        Class classObj;
        try
        {
            classObj = Class.forName(name);
            System.out
                    .println("The following report regards " + name + " : \n");
            if (!printSuperClasses(classObj))
            {
                System.out.println("This classObj doesn't"
                        + " extend any other classObj !");
            }
            printConstructors(classObj);
            printMethods(classObj);
            printFields(classObj);
        } catch (ClassNotFoundException e)
        {
            System.out.println("Class not found.");
        }
    }

    public static void printBlanks()
    {
        for (int i = 0; i < blanks; i++)
        {
            System.out.print(" ");
        }
    }

    public static boolean printSuperClasses(Class classObj)
    {
        if (classObj == null)
        {
            return false;
        } else
        {
            printSuperClasses(classObj.getSuperclass());
            System.out.println(classObj.getName());
            if (!classObj.getName().equals(name))
            {
                printBlanks();
                System.out.println("|");
                printBlanks();
                System.out.print("+--");
                blanks += (classObj.getName().length());
            }
            return true;
        }
    }

    public static void printConstructors(Class classObj)
    {
        Constructor[] constructors = classObj.getDeclaredConstructors();
        System.out.println("\nCONSTRUCTORS");
        System.out.println("============");
        for (int i = 0; i < constructors.length; i++)
        {
            System.out.println("constructor num." + (i + 1));
            System.out.println("-----------------");
            Constructor c = constructors[i];
            Class[] paramTypes = c.getParameterTypes();
            String constructorName = c.getName();
            System.out.print(Modifier.toString(c.getModifiers()));
            System.out.print(constructorName + "(");
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j > 0)
                {
                    System.out.print(" , ");
                }
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class classObj)
    {
        Method[] methods = classObj.getDeclaredMethods();
        System.out.println("\nMETHODS");
        System.out.println("=======");
        for (int i = 0; i < methods.length; i++)
        {
            System.out.println("method num." + (i + 1));
            System.out.println("------------");
            Method m = methods[i];
            Class retType = m.getReturnType();
            Class[] paramTypes = m.getParameterTypes();
            String methodName = m.getName();
            System.out.print(Modifier.toString(m.getModifiers()));
            System.out.print(retType.getName() + " " + methodName + "(");
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j >= 0)
                {
                    if (j>0) System.out.print(", ");
                    System.out.print(paramTypes[j].getName());
                }
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();
        System.out.println("\nFIELDS");
        System.out.println("======");
        for (int i = 0; i < fields.length; i++)
        {
            System.out.println("field num." + (i + 1));
            System.out.println("-----------");
            Field f = fields[i];
            Class type = f.getType();
            String fieldName = f.getName();
            System.out.print(Modifier.toString(f.getModifiers()));
            System.out.println(" " + type.getName() + " " + fieldName + ";");
        }
    }
}