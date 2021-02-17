package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;
    int cnt;
    int breakCount;

    public Position(int x, int y, int cnt, int breakCount) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.breakCount = breakCount;
    }
}

// 벽 부수고 이동하기 문제 - 2206번
public class BreakWallBFS {

    static int N, M;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static boolean[][][] visited;

    static void solution() {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(0,0,1,0));

        while (!q.isEmpty()) {
            Position now = q.poll();
            int nx = now.x;
            int ny = now.y;
            int nCnt = now.cnt;
            int nBreakCount = now.breakCount;

            // 목표 위치 도달
            if(nx == N-1 && ny == M-1) {
                ans = Math.min(ans, nCnt);
                continue;
            }

            // 4가지 방향으로 이동
            for(int i = 0; i < 4; i ++) {
                int tx = nx + dx[i];
                int ty = ny + dy[i];

                // 맵의 범위 안이 아닌 경우
                if(tx < 0 || tx >= N || ty < 0 || ty >=M) continue;

                // 벽을 부수고 온 경우
                if(nBreakCount == 1) {

                    // 미방문 했으면서 길인 경우
                    if(!visited[1][tx][ty] && map[tx][ty] == 0) {
                        // 방문 처리
                        visited[1][tx][ty] =true;
                        q.offer(new Position(tx,ty,nCnt+1,1));
                    }

                }

                // 벽을 부수지 않고 온 경우
                else {

                    // 가고자하는 노드가 벽인 경우
                    if(map[tx][ty] == 1) {

                        // 벽을 부시고 이곳을 방문한 적이 없는 경우
                        if(!visited[1][tx][ty]) {
                            // 뱍을 부시고 방문처리
                            visited[1][tx][ty] = true;
                            q.offer(new Position(tx, ty, nCnt+1, 1));
                        }
                    }
                    // 가고자하는 노드가 길인 경우
                    else if(map[tx][ty] == 0) {
                        if(!visited[0][tx][ty]) {
                            // 방문처리
                            visited[0][tx][ty] = true;
                            q.offer(new Position(tx,ty,nCnt+1,0));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[2][N][M];

        for(int i = 0 ; i <N; i++) {
            String row = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }
        solution();

        if(ans == Integer.MAX_VALUE) {
           System.out.println(-1);
        }else {
            System.out.println(ans);
        }
    }
}