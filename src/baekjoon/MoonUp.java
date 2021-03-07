package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 달이 차오른다, 가자. 문제 - 1194번
class Dot {
    int x;
    int y;
    int key;
    int time;

    public Dot(int x, int y, int key, int time) {
        this.x = x;
        this.y = y;
        this.key = key;
        this.time = time;
    }
}

public class MoonUp {

    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new char[N][M];
        visited = new boolean[N][M][1 << 6];
        Dot start = null;
        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);

                // 출발지점
                if(map[i][j] == '0') {
                    start = new Dot(i,j,0, 0);
                }
            }
        }

        System.out.println(BFS(start));
    }

    static int BFS(Dot start) {
        Queue<Dot> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y][start.key] = true;

        while (!q.isEmpty()) {
            Dot now = q.poll();

            for(int i = 0; i < 4; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];
                int tKey = now.key;

                // 미로 범위 안
                if(tx < 0 || tx >= N || ty < 0 || ty >= M)  continue;

                // 탈출한 경우
                if(map[now.x][now.y] == '1') return now.time;

                // 벽인 경우
                if(map[tx][ty] == '#') continue;

                // 문이면서 키가 없는 경우
                if('A' <= map[tx][ty] && map[tx][ty] <= 'F') {
                    if((tKey & (1 << (map[tx][ty] - 'A'))) == 0) continue;
                }

                // 키인 경우
                if('a' <= map[tx][ty] && map[tx][ty] <= 'f') {
                    tKey = tKey | (1 << (map[tx][ty] - 'a'));
                }

                // 이미 동일한 키 목록으로 방문한 경우
                if(visited[tx][ty][tKey]) continue;

                // 방문 처리
                visited[tx][ty][tKey] = true;
                q.offer(new Dot(tx, ty, tKey, now.time + 1));
            }
        }
        return -1;
    }
}