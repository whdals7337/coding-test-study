package programmers;

import java.util.Arrays;

// 프로그래머스 거스름돈 문제
class Change {
    static final int MOD = 1000000007;
    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length + 1][n + 1];

        // 동전 금액 정렬
        // 테스트케이스에서 정렬된 값을 주기 대문에 없어도 통과하지만
        // 정렬된 순서로 준다고 하지않았기 때문에 원래라면 필요합니다.
        Arrays.sort(money);

        // dp 0 초기화
        dp[0][0] = 1;

        // r = 사용하는 동전종류의 개수, c = 만들고자하는 금액
        for(int r = 1 ; r <= money.length; r++){
            for(int c = 0 ; c <= n; c++){
                // 구하고자하는 비용이 동전의 값보다 작은 경우
                if(c < money[r - 1]){
                    // 이용하고자하는 동전으로는 어떤 경우의 수도 추가할 수 없음
                    dp[r][c] = dp[r - 1][c] % MOD;
                }
                // 구하고자하는 비용이 동전의 값과 같은 경우
                else if(c == money[r - 1]){
                    // 해당 동전하나로 거슬러주는 경우를 추가.
                    dp[r][c] = dp[r - 1][c] + 1 % MOD;
                }
                // 구하고자하는 비용이 동전의 값보다 큰 경우
                else {
                    // 종류를 덜 사용해서 해당 비용을 만드는 경우 + 만들고자 하는 비용 - 동전의 값을 만드는 경우
                    dp[r][c] = dp[r - 1][c] + dp[r][c - money[r - 1]] % MOD;
                }
            }
        }
        return dp[money.length][n];
    }
}