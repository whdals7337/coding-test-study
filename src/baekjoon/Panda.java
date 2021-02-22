package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 욕심쟁이 판다 - 1937번
public class Panda {

    static int n, result;
    static int[][] map, dp;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int DFS(int x, int y) {
        if(dp[x][y] != -1) return dp[x][y];

        int temp = 1;
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            // 범위 내부 여부
            if(tx < 0 || tx >= n || ty < 0 || ty >= n) continue;

            // 이동 가능한 경우
            if(map[x][y] < map[tx][ty] && !visited[tx][ty]) {
                visited[tx][ty] = true;
                temp = Math.max(temp, DFS(tx,ty) + 1);
                visited[tx][ty] = false;
            }
        }
        return dp[x][y] = temp;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = true;
                result = Math.max(result, DFS(i,j));
                visited[i][j] = false;
            }
        }
        System.out.println(result);
    }
}