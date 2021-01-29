package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추 문제 - 1012번
public class Cabbage {

    static int m, n, k;
    static int[][] map;
    // 동서남북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void DFS(int x, int y) {
        map[x][y] = 0;

        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if((tx>=0 && tx<m && ty>=0 && ty<n)) {
                if(map[tx][ty] != 0) {
                    DFS(tx, ty);
                }
            }
        }
    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        map[x][y] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            x = now[0];
            y = now[1];

            for(int i = 0; i < 4; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if((tx>=0 && tx<m && ty>=0 && ty<n)) {
                    if(map[tx][ty] == 1) {
                        q.offer(new int[]{tx, ty});
                        map[tx][ty] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new int[m][n];

            k = Integer.parseInt(st.nextToken());

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            int count = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] == 1) {
                        BFS(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}