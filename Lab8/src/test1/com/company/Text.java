package test1.com.company;

import annotations.Save;
import annotations.SaveToFile;
import annotations.Saver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

@SaveToFile(path="text.txt")
public class Text {
    @Save(isText = true)
    public String text;

    @Saver(isSaverText = true)
    public void saveText(String path, Field textField) throws IOException, IllegalAccessException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(buildBufferLineArray(textField));
        fileOutputStream.close();
    }

    @Saver(isSaverText = false)
    private byte[] buildBufferLineArray(Field field) throws IllegalAccessException {
        return (field.getName() + "=" + field.get(this) + '\n').getBytes(StandardCharsets.UTF_8);
    }
}
