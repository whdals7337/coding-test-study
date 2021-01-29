package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1로 만들기 문제 - 1463번
public class MakeOne {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int[] dp = new int[x+1];
        dp[1] = 0;
        for(int i = 2; i <= x; i++) {
            // 1 더하는 경우
            dp[i] = dp[i-1] + 1;
            // 2 로 나누어 떨어지는 경우
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            // 3 으로 나눠어 떨어지는 경우
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[x]);
    }
}