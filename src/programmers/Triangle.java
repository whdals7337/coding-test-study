package programmers;

// 프로그래머스 정수삼각형 문제
class Triangle {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length + 1];
        dp[0][0] = triangle[0][0];

        // 삼각형 맨 왼쪽은 바로 위의 값과의 합이 dp값
        for(int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
        }

        for(int i = 1; i < triangle.length; i++) {
            for(int j = 1; j < triangle[i].length; j++) {
                // 구하고자하는 위치의 바로 위와 대각선 위의 값 중 큰값과의 합
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        // dp 맨 마지막 줄에서 가장 큰값
        int answer = 0;
        for(int value : dp[triangle.length-1]) {
            answer = Math.max(answer, value);
        }
        return answer;
    }
}