package ByteDance;

import java.util.Scanner;

/**
 * Created by ymk on 2019/3/16.
 * 这道题应该是动态规划的题,
 * 一群人围成圈,根据分数给他们发奖品,每人至少一个奖品,比左右的分数高的人奖品也必须要比左右的奖品多
 *
 */
public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- >= 0) {
            int m = scanner.nextInt();
            int[] score = new int[m+2];
            int[] prize = new int[m+2];

            for (int i = 1; i < m+1; i++) {
                score[i] = scanner.nextByte();
            }
            score[0]=score[m];
            score[m+1]=score[1];

            int result=0;

            for (int i : prize) {
                prize[1]=1;
            }


            for (int i = 1; i < m+1; i++) {
                if(score[i]<score[i-1]&&score[i]<score[i+1]){
                    prize[i]=1;
                }else if(score[i]>=score[i-1]&&score[i]>=score[i+1]){
                    prize[i] = Math.max(prize[i-1],prize[i+1])+1;
                }else if(score[i]>score[i-1]&&score[i]<=score[i+1]){
                    prize[i] = Math.min(prize[i-1],prize[i+1])+1;
                }else if(score[i]<=score[i-1]&&score[i]>score[i+1]){
                    prize[i] = Math.min(prize[i-1],prize[i+1])+1;
                }
                if(i==1){
                    prize[m + 1] = prize[i];
                }else if (i==m){
                    prize[0] = prize[i];
                }
            }


            for (int i = 1; i < m+1; i++) {
                result += prize[i];
            }
            System.out.println(result);

        }
    }
}
