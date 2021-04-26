package JVM07HowReflect;

import java.lang.reflect.Field;

/**
 * Created by ymkNK on 2021-04-26.
 */
public class HowJvmReflect {


    /**
     * Created by ymk.
     * 1. 举例来说，我们可以通过 Class 对象枚举该类中的所有方法，我们还可以通过 Method.setAccessible（位于 java.lang.reflect 包，该方法继承自 AccessibleObject）绕过 Java 语言的访问权限，在私有方法所在类之外的地方调用该方法。
     **/
    public static void case1() throws IllegalAccessException {
        System.out.println("===case 1===");
        Test test = new Test();
//        Boolean testPrivate = test.testPrivate();
        Class<Test> testClass = Test.class;

        for (Field declaredField : testClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            System.out.println("Test:" + declaredField.getName() + "=" + declaredField.get(test));
        }
    }


    public static void main(String[] args) throws IllegalAccessException {
        case1();

    }
}
