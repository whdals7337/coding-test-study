package programmers;

// 프로그래머스 가장 큰 정사각형 찾기 문제
class BiggestRec {
    public int solution(int [][]board) {
        int r_len = board.length;
        int c_len = board[0].length;
        int answer = 0;

        int[][] dp = new int[r_len][c_len];
        for(int i = 0; i < r_len; i++) {
            dp[i][0] = board[i][0];
            answer = Math.max(answer, dp[i][0]);
        }

        for(int i = 0; i < c_len; i++) {
            dp[0][i] = board[0][i];
            answer = Math.max(answer, dp[0][i]);
        }

        for(int i = 1; i < r_len; i++) {
            for (int j = 1; j < c_len; j++) {
                int target = board[i][j];
                if(target == 0) {
                    dp[i][j] = 0;
                }else {
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    int leftUp = dp[i-1][j-1];

                    dp[i][j] = Math.min(up, Math.min(left, leftUp)) + 1;
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer*answer;
    }
}