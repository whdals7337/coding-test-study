package programmers;

// 프로그래머스 등굣길 문제
class GoToSchool {

    static final int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];

        // 웅덩이를 map에 표시
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = 1;
        }
        // 집 dp 초기화
        dp[1][1] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                // 집위치는 위에서 초기화 해서 넘어감
                if(i== 1 && j == 1) continue;
                // 웅덩이의 경우 넘어감 - 해당위치 dp 값은 0
                if(map[i][j] == 1) continue;
                // 위, 아래 dp의 합으로 셋팅
                dp[i][j] = dp[i-1][j] % MOD + dp[i][j-1] % MOD;
            }
        }
        return dp[n][m] % MOD;
    }
}