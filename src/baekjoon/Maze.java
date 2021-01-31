package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색 문제 - 2178번
public class Maze {
    static int n, m;
    static int[][] dp;
    static boolean[][] visited;

    // 동서남북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0; i < 4; i++) {
                int tx = now[0] + dx[i];
                int ty = now[1] + dy[i];

                // 미로를 벗어나는 경우
                if(tx < 0 || tx >= n || ty < 0 || ty >= m) continue;

                // 이미 방문했거나 벽인 경우
                if(visited[tx][ty] || dp[tx][ty] == 0) continue;

                // now 에서 한칸 이동한 값이 타겟 지점까지 거리
                dp[tx][ty] = dp[now[0]][now[1]] + 1;
                visited[tx][ty] = true;
                q.offer(new int[]{tx,ty});

            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                dp[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        System.out.println(dp[n-1][m-1]);
    }
}