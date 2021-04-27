package JVM07HowReflect;
import java.lang.reflect.Method;

/**
 * Created by Yangmingkai on 2021/4/27.
 */
public class Test {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class klass = Class.forName("Test");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
    }
}