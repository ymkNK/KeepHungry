package ByteDance;

import java.util.Scanner;

/**
 * Created by ymk on 2019/3/16.
 * 字符串处理的问题
 * AAA形式的变成AA的
 * AABB形式的变成AAB的
 */
public class Spell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        while (n-- >= 0) {
            String inputStr = scanner.nextLine();
            String regex1 = "([a-zA-Z])\\1{2}";
            String regex2 = "([a-zA-Z])\\1{1}([a-zA-Z])\\2{1}";


            int iter = inputStr.length() / 2;
            while (iter-- >= 0) {
                inputStr = inputStr.replaceAll(regex1, "$1$1");
            }

            iter = inputStr.length() / 2;
            while (iter-- >= 0) {
                inputStr = inputStr.replaceAll(regex2, "$1$1$2");
            }
            if (inputStr.equals(""))
                continue;
            System.out.println(inputStr);
        }
    }
}
