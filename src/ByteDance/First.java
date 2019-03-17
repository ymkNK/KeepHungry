package ByteDance;


import java.util.Scanner;

/**
 * Created by ymk on 2019/3/16.
 * 这个就是1024,输入N,有64,16,4,1的硬币,问每次找的最少的硬币数目
 */
public class First {
    public static Integer MAX = 1024;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer rest = MAX;
        Integer coinNumber = 0;
        Integer coin64 = 0;
        Integer coin16 = 0;
        Integer coin4 = 0;
        Integer coin1 = 0;

        rest = MAX - n;

        coin64 = rest / 64;
        rest = rest % 64;

        coin16 = rest / 16;
        rest = rest % 16;

        coin4 = rest / 4;
        rest = rest % 4;

        coin1 = rest;

        coinNumber = coin1 + coin4 + coin16 + coin64;
        System.out.println(coinNumber);
    }

}
