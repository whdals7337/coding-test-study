package programmers;

// 프로그래머스 도둑질 문제
class Thief {
    public int solution(int[] money) {
        int[][] dp = new int[2][money.length];
        // 첫번째 포함 경우
        dp[0][0] = money[0]; dp[0][1] = money[0];
        // 두번째 포함 경우
        dp[1][0] = 0; dp[1][1] = money[1];

        // 첫번째를 포함 경우 - 마지막 db 값은 구하지 않음(첫번째 선택시 마지막 불가능)
        for(int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2] + money[i]);
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2] + money[i]);
        }

        // 두번째를 포함 경우 - 마지막 가능
        return Math.max(dp[0][money.length-2], dp[1][money.length-1]);
    }
}