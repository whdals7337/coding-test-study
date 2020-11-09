package dynamic_programming;

import java.util.ArrayList;
import java.util.Scanner;

// 병사 배치하기 문제
public class DynamicProgrammingTest7 {

    public static ArrayList<Integer> arr = new ArrayList<Integer>();
    public static int[] dp = new int[2000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++ ) {
            arr.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // 자신 보다 큰 수일 경우 수열
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr.get(j) > arr.get(i)){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
        }

        // 열외해야 하는 병사의 최소 수를 출력
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(n - maxValue);
    }
}
