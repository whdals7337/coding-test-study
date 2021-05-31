package programmers;

// 프로그래머스 삼각 달팽이 문제
class TriangleSnail {
    public int[] solution(int n) {
        int max = n * (n + 1) / 2;
        int[][] matrix = new int[n][n];
        int[] answer = new int[max];

        // 시작 지점 초기화
        int x = 0, y = 0;
        int value = 1;
        matrix[0][0] = 1;

        while (value < max) {
            // 왼쪽 - 위에서 아래로
            while (x + 1 < n && matrix[x + 1][y] == 0) {
                matrix[++x][y] = ++value;
            }

            // 아래 - 왼쪽에서 오른쪽으로
            while (y + 1 < n && matrix[x][y + 1] == 0) {
                matrix[x][++y] = ++value;
            }

            // 오른쪽 아래에서 대각선 위로
            while (y - 1 > 0 && x - 1 > 0 && matrix[x - 1][y - 1] == 0) {
                matrix[--x][--y] = ++value;
            }
        }
        int idx = 0;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx] = matrix[i][j];
                idx++;
            }
        }
        return answer;
    }
}