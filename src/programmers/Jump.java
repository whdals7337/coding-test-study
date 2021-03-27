package programmers;

// 프로그래머스 멀리 뛰기 문제
class Jump {
    static final int MOD = 1234567;
    public long solution(int n) {
        int[] dp = new int[2001];
        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] * 2 + (dp[i-1] - dp[i-2])) % MOD;
        }
        return dp[n];
    }
}