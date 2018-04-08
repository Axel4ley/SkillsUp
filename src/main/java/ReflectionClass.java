import java.lang.annotation.Annotation;
import java.lang.reflect.*;


        /*
        Программа принимает параметром полное доменное имя класса (например, java.lang.String).
        Необходимо вывести на экран: имя класса, модификаторы доступа,
        generic-параметры, реализуемые интерфейсы, аннотации, иерархию наследования,
        список полей, методов и конструкторов.
        */


public class ReflectionClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class class1 =  Class.forName(args[0]);
        System.out.println("Class name: " + class1.getName());
        System.out.println("Class modifiers: " + Modifier.toString(class1.getModifiers()));
        System.out.printf("Generic: %s, %n", class1.getTypeName());


        Type[] typer = class1.getTypeParameters();
        for (Type typerrr : typer) {
            System.out.println( "Type: " + typerrr.getTypeName());
        }

        System.out.println();
        Field[] fields1 =  class1.getFields();
        for(Field field : fields1) {
            System.out.println(field.getName() + " " + field.getType().getName() + " ");
        }

        Constructor[] constructors = class1.getConstructors();
        for (Constructor constr : constructors) {
            System.out.println("Constructors: ");
            System.out.println(constr);
        }


        Field[] fields2 = class1.getFields();
        if (fields2.length != 0) {
            System.out.println();
            System.out.println("Fields: ");
            for (Field f : fields2) {
                System.out.println(f);
            }
        } else {}

        System.out.println();
        System.out.println("Interfaces: ");
        Class[] interfaces = class1.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c.getSimpleName());
        }


        System.out.println();
        System.out.println("Methods and modifiers: ");
        Method[] methods = class1.getDeclaredMethods();
        for (Method m : methods) {
            System.out.print("Method name: " + m.getName() + " >> ");
            System.out.print("Modifiers: " + Modifier.toString(m.getModifiers()));
            Annotation[] annotations = m.getAnnotations();
            for (Annotation an : annotations) {

                System.out.println(" >> " + " annotations: " + an.annotationType().getSimpleName());
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Super Class is:" + class1.getSuperclass());
    }
}
