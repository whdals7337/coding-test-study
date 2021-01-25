package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//RGB 거리 문제 - 1149번
public class RGB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[3][N];
        int[][] c = new int[3][N];

        // 갑 셋팅
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                c[j][i] = Integer.parseInt(st.nextToken());
                if(i == 0) dp[j][i] = c[j][i];
            }
        }

        // dp 채우기
        for(int i = 1; i < N; i++) {
            dp[0][i] = c[0][i] + Math.min(dp[1][i-1], dp[2][i-1]);
            dp[1][i] = c[1][i] + Math.min(dp[0][i-1], dp[2][i-1]);
            dp[2][i] = c[2][i] + Math.min(dp[0][i-1], dp[1][i-1]);
        }
        System.out.println(Math.min(dp[0][N-1], Math.min(dp[1][N-1], dp[2][N-1])));
    }
}