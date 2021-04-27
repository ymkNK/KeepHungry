package JVM07HowReflect;

/**
 * Created by Yangmingkai on 2021/4/26.
 */
public class CustomTest {
    private void testPrivate() {
        System.out.println("this is a private method in Test.class");
    }
    public void testPublic(){
        System.out.println("this is a public method in Test.class");
    }

    private int privateValue = 1;

}
