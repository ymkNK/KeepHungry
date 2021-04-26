package JVM07HowReflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ymkNK on 2021-04-26.
 */
public class HowJvmReflect {


    /**
     * Created by ymk.
     * 1. 举例来说，我们可以通过 Class 对象枚举该类中的所有方法，我们还可以通过 Method.setAccessible（位于 java.lang.reflect 包，该方法继承自 AccessibleObject）绕过 Java 语言的访问权限，在私有方法所在类之外的地方调用该方法。
     **/
    public static void case1() throws IllegalAccessException, InvocationTargetException {
        System.out.println("===case 1===");
        Test test = new Test();
//        test.testPrivate();
//        System.out.println(test.privateValue);

        Class<Test> testClass = Test.class;

        for (Field declaredField : testClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            System.out.println("Test:" + declaredField.getName() + "=" + declaredField.get(test));
        }
        for (Method declaredMethod : testClass.getDeclaredMethods()) {
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(test);
        }

    }


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        case1();

    }
}
