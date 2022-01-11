package test1.com.company;
import annotations.Save;
import annotations.SaveToFile;
import annotations.Saver;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Predicate;

public class FileHandler {

    private static final String filePath = Text.class.getAnnotation(SaveToFile.class).path();

    public static void saveToFile(String text) throws Exception {
        Method foundedMethodForSave =
                tryFindMethod(x -> x.isAnnotationPresent(Saver.class) && x.getAnnotation(Saver.class).isSaverText());

        Field textField = Arrays.stream(Text.class.getFields())
                .filter(x -> x.isAnnotationPresent(Save.class) && x.getAnnotation(Save.class).isText())
                .findFirst()
                .orElse(null);

        if(textField == null)
            throw new Exception("Field is not found");
        Text textContainer = new Text();
        textContainer.text = text;
        foundedMethodForSave.invoke(textContainer, filePath, textField);
    }


    private static Method tryFindMethod(Predicate<Method> condition) throws Exception {
        Method method = Arrays.stream(Text.class.getMethods())
                .filter(condition)
                .findFirst()
                .orElse(null);

        if(method == null)
            throw new Exception("Method is not found");
        return method;
    }
}
