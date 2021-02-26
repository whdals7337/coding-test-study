package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class TwoBead {
    int rx;
    int ry;
    int bx;
    int by;
    int count;

    public TwoBead(int rx,int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}

// 구슬 탈출 2 문제 - 13460번
public class BeadEscape{

    static int N,M;
    static char[][] map;
    static boolean[][][][] visited;
    static int result = -1;

    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(TwoBead twoBall) {
        Queue<TwoBead> q = new LinkedList<>();
        q.offer(twoBall);

        // 빨간 구슬과 파란구슬의 위치 방문 처리
        visited[twoBall.rx][twoBall.ry][twoBall.bx][twoBall.by]= true;

        while (!q.isEmpty()) {
            TwoBead now = q.poll();

            if(now.count > 10) {
                result = -1;
                return;
            }

            // 파란색이 빠져나간 경우
            if(map[now.bx][now.by] == 'O') {
                continue;
            }

            // 빨간 색이 빠져나가고 파란색은 빠져 나가지않은 경우
            if(map[now.rx][now.ry] == 'O') {
                result = now.count;
                return;
            }

            //상하좌우로 기울이기
            for(int i = 0; i < 4; i++) {

                // 기울였을때 파란 구슬이 도달하는 지점으로 이동
                int bx = now.bx;
                int by = now.by;
                while(true) {
                    bx += dx[i];
                    by += dy[i];
                    // 빠져나간 경우
                    if(map[bx][by] == 'O') break;
                    // 벽을 만난 경우
                    else if(map[bx][by] == '#'){
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }
                }

                /// 기울였을때 빨간 구슬이 도달하는 지점으로 이동
                int rx = now.rx;
                int ry = now.ry;
                while(true) {
                    rx += dx[i];
                    ry += dy[i];
                    // 빠져나간 경우
                    if(map[rx][ry] == 'O') break;
                        // 벽을 만난 경우
                    else if(map[rx][ry] == '#'){
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }
                }

                // 만약 두개의 위치가 동일하고 둘의 위치가 빠져나가는 위치가 아닌 경우 - 앞선 두개의 구슬 이동에서 서로에 대한 고려를 하지않고 이동하였기 때문에
                if(bx == rx && by == ry && map[rx][ry] != 'O') {
                    // 이동한 거리가 더 긴 쪽이 덜 이동하게 처리
                    int r_dis = Math.abs(now.rx - rx) + Math.abs(now.ry - ry);
                    int b_dis = Math.abs(now.bx - bx) + Math.abs(now.by - by);

                    // 빨간 구슬이 더 이동한 경우
                    if(r_dis > b_dis) {
                        rx -= dx[i];
                        ry -= dy[i];
                    }
                    // 파란 구슬이 더 이동한 경우
                    else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }

                // 기울였을때 구슬들이 도달하는 지점을 방문 처리 후 큐에 추가 - 두 구슬 중 이전과 하나라도 다르다면 다른결과가 있을수 있음
                if(!visited[rx][ry][bx][by]) {
                    // 방문처리
                    visited[rx][ry][bx][by] = true;
                    // 두 구슬을 큐에 추가
                    q.offer(new TwoBead(rx, ry, bx, by, now.count + 1));
                }
            }

        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map= new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'R') {
                   rx = i;
                   ry = j;
                }
                else if(map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        bfs(new TwoBead(rx, ry, bx, by,0));
        System.out.println(result);
    }
}