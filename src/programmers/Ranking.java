package programmers;

import java.util.Arrays;

// 프로그래머스 순위 문제
class Ranking {
    static final int MAx = 10000;
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] dp = new int[n+1][n+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, MAx);
        }

        for(int[] re : results) {
            dp[re[0]][re[1]] = 1;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            boolean checker = true;
            for(int j = 1; j <= n; j++) {
                if (i == j) continue;
                if(dp[i][j] == MAx && dp[j][i] == MAx) {
                    checker = false;
                }
            }
            if (checker) answer++;
        }
        return answer;
    }
}