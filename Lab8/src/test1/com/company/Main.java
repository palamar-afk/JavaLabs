package test1.com.company;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception
    {
        calculateResult();
        FileHandler.saveToFile("This is text that must be saved");
    }

    public static void calculateResult(){
        for (Method method : AnnotationHandler.class.getMethods())
        {
            if(method.isAnnotationPresent(Annotation.class))
            {
                try
                {
                    var ann = method.getAnnotation(Annotation.class);
                    System.out.println((int) method.invoke(new AnnotationHandler(), ann.fieldA(), ann.fieldB()));
                }
                catch(Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
                return;
            }
        }
    }
}
