package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다리놓기 문제
public class Bridge {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int testcase = Integer.parseInt(st.nextToken());

        for(int tc = 0; tc < testcase; tc++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st2.nextToken());
            int M = Integer.parseInt(st2.nextToken());

            // 점화식 dp[N][M] = dp[N][M-1] + dp[N-1][M-1]
            int[][] dp  = new int[N+1][M+1];

            for(int n = 2; n <= N; n++) {
                dp[n][1] = 0;
            }

            for(int m = 1; m <= M; m++) {
                dp[1][m] = m;
            }

            for(int a = 2; a <= N; a++){
                for(int b = 2; b <= M; b++) {
                    dp[a][b] = dp[a][b-1] + dp[a-1][b-1];
                }
            }

            System.out.println(dp[N][M]);

        }
    }
}