package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1, 2, 3 더하기 문제 - 9095번
public class OneTwoThreePlus {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (T --> 0) {
            int n = Integer.parseInt(br.readLine());
            if(n >= 4) {
                for(int i = 4; i <= n; i++) {
                    if(dp[i] == 0) {
                        dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
                    }
                }
            }
            System.out.println(dp[n]);
        }
    }
}