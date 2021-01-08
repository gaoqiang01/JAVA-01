import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @param
 * @author silent
 * @time 9:48 2021/1/8
 * @description 自定义classloader 加载自定义文件
 */
public class HelloClassLoader extends ClassLoader{


    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloClassLoader().findClass("Hello");
            Method method = helloClass.getDeclaredMethod("hello");
            method.invoke(helloClass.newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException |
                IllegalAccessException | InstantiationException|
                InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     *  load  class
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String s) throws ClassNotFoundException {
        byte[] classData = loadFile(s);
        return defineClass(s, classData, 0, classData.length);
    }


    /**
     * 加载文件信息
     * @param path 文件路径
     * @return
     */
    private byte[] loadFile(String path){

        try {
            String newPth=path.replace(".", File.pathSeparator) + ".xlass";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(newPth);
            ByteArrayOutputStream outByte = new ByteArrayOutputStream();
            int nextValue;
            while ((nextValue = inputStream.read()) != -1) {
                outByte.write(nextValue);
            }
            byte[] bytes = outByte.toByteArray();
            return decode(bytes);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;

    }

    /**
     * 编码
     * @param xlass
     * @return
     */
    private byte[] decode(byte[] xlass) {
        for (int i = 0; i < xlass.length; i++) {
            xlass[i] = (byte) (255 - xlass[i]);
        }
        return xlass;
    }




}
