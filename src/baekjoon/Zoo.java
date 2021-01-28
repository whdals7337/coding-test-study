package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 동물원 문제 - 1309번
public class Zoo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int MOD = 9901;

        // dp[x][0] : x번째 줄 우리에 아무것도 안 넣은 경우
        // dp[x][1] : x번째 줄 왼쪽 우리에 넣은 경우
        // dp[x][2] : x번째 줄 오른쪽 우리에 넣은 경우
        long[][] dp = new long[n+1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for(int i = 2; i <= n; i++) {
            // i번째 줄에 안넣는 경우의 수는 i-1번째 줄에 안넣는경우 + 왼쪽에 넣는 경우 + 오른쪽에 넣은 경우
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) %MOD;

            // i번째 줄에 왼쪽에 넣는 경우의 수는 i-1번째 줄에 안넣는경우 + 오른쪽에 넣은 경우
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) %MOD;

            // i번째 줄에 오른쪽에 넣는 경우의 수는 i-1번째 줄에 안넣는경우 + 왼쪽에 넣은 경우
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) %MOD;
        }

        long total = dp[n][0] + dp[n][1] + dp[n][2];
        System.out.println(total%MOD);
    }
}