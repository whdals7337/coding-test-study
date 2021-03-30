package programmers;

// 프로그래머스 퀴드압축 후 개수 세기 문제
class QuadImpress {
    private static int[] answer;

    private static void dfs(int n, int x, int y, int[][] arr) {
        if (n == 1) {
            answer[arr[x][y]]++;
            return;
        }
        if (isSame(n, x, y, arr)) {
            return;
        }

        dfs(n / 2, x, y, arr);
        dfs(n / 2, x + n / 2, y, arr);
        dfs(n / 2, x, y + n / 2, arr);
        dfs(n / 2, x + n / 2, y + n / 2, arr);
    }

    public static boolean isSame(int n, int x, int y, int[][] arr) {
        int temp = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (temp != arr[i][j]) {
                    return false;
                }
            }
        }
        answer[temp]++;
        return true;
    }

    public int[] solution(int[][] arr) {
        answer = new int[2];
        dfs(arr.length, 0, 0, arr);
        return answer;
    }
}