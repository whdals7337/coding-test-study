package programmers;

// 프로그래머스 피보나치 수 문제
class Fibo {
    public static int[] dp;
    public int solution(int n) {
        dp = new int[n + 1];
        return fibo(n) % 1234567;
    }

    public static int fibo(int n) {
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        if(dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
    }
}