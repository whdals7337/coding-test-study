package programmers;

// 프로그래머스 프렌즈4블록 문제
class Friends4Block {
    // 아래, 오른쪽, 오른쪽 아래
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    static int[][] matrix;
    static int answer;

    public int solution(int m, int n, String[] board) {
        matrix = new int[m][n];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = board[i].charAt(j) - 'A';
            }
        }
        while (clear()) {
            move();
        }
        return answer;
    }

    static boolean clear() {
        int[][] temp = twoDimensionalArrayDeepCopy(matrix);
        int count = 0;

        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean isWillRemove = true;

                for (int k = 0; k < 3; k++) {
                    int tx = i + dx[k];
                    int ty = j + dy[k];

                    if (!isRanged(tx, ty) || matrix[i][j] != matrix[tx][ty]) {
                        isWillRemove = false;
                        break;
                    }
                }

                if (isWillRemove) {
                    if (!isAlreadyRemove(temp[i][j])) {
                        temp[i][j] = -1;
                        count++;
                    }

                    for (int k = 0; k < 3; k++){
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if (!isAlreadyRemove(temp[tx][ty])) {
                            temp[tx][ty] = -1;
                            count++;
                        }
                    }
                }
            }
        }
        matrix = temp;
        answer += count;
        return count > 0;
    }

    static void move() {
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == -1) {
                    int x = i;
                    while (x > 0 && matrix[x][j] == -1) {
                        x--;
                    }
                    matrix[i][j] = matrix[x][j];
                    matrix[x][j] = -1;
                }
            }
        }
    }

    static int[][] twoDimensionalArrayDeepCopy(int[][] arr) {
        int[][] temp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0 ; j < arr[i].length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

    static boolean isAlreadyRemove(int val) {
        return val == -1;
    }

    static boolean isRanged(int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}