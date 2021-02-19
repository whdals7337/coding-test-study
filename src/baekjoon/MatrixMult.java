package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행렬 곱셈 순서 문제 - 11049번
public class MatrixMult {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][2]; // 0:  행, 1: 열
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        // gap이 1인 경우의 dp 초기화( 행 * 열 * 열)
        for(int i = 0; i < n-1; i++) {
            dp[i][i + 1] = matrix[i][0] * matrix[i][1] * matrix[i+1][1];
        }

        // gap이 2 이상인 경우
        for(int gap = 2; gap < n; gap++) {
            for(int i = 0; i+gap < n; i++) {
                int j = i+gap;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k = i; k < j; k++) {
                    // dp[i][k] + dp[k+1][j]은 앞선 계산의 최소값 + 마지막 행렬과의 계산값
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1]));
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}