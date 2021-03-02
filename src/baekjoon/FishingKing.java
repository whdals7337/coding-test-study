package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 낚시왕 문제 - 17143번
public class FishingKing {

    static int R, C, M;
    static int result;
    static Shark[][] map;
    static ArrayList<Shark> sharks = new ArrayList<>();
    // 상하우좌
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void catchShark(int y) {
        for(int i = 0; i < R; i++) {
            // 만약 서있는 지점에 상어가 있으면 잡음
            if(map[i][y] != null) {
                Shark now = map[i][y];

                // 지도에서 상어 제거
                map[i][y] = null;

                // 잡은 상어의 크기
                result += now.size;
                sharks.remove(now);

                // 한마리만 잡을수 있으므로
                break;
            }
        }
    }

    static void move() {
        // 전체 상어 이동
        for(int i = 0; i < sharks.size(); i++) {
            sharks.get(i).updatePosition();
        }
    }

    // 이동후 상어리스트에서 살아남은 상어로만 map을 초기화
    static void survive() {
        map = new Shark[R][C];
        int size = sharks.size();
        for(int i = size - 1; i >= 0; i--) {
            Shark shark = sharks.get(i);
            // map의 위치가 비어있는 경우
            if(map[shark.x][shark.y] == null) {
                map[shark.x][shark.y] = shark;
            }
            // map의 위치에 상어가 있는 경우
            else {
                if(map[shark.x][shark.y].size > shark.size) {
                    sharks.remove(shark);
                }else {
                    sharks.remove(map[shark.x][shark.y]);
                    map[shark.x][shark.y] = shark;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(r, c, s, d, z);
            map[r][c] = shark;
            sharks.add(shark);
        }

        for(int i = 0; i < C; i++) {
            // 상어 낚시
            catchShark(i);

            // 상어 이동
            move();

            // 살아있는 상어
            survive();
        }

        System.out.println(result);
    }

    static class Shark {
        int x;
        int y;
        int speed;
        int dir;
        int size;

        public Shark(int x, int y, int speed, int dir, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

        // 상어의 실제 움직이면 되는 거리는 speed % ((넓이 - 1) * 2)
        // ((넓이 -1) * 2)는 상어가 제자리로 돌아오는데 필요한 속도로
        // 위 공식을 하면 가지고있는 속도%제자리로 돌오는데 필요한 속도
        // 그래서 제자리에서 나머지 만큼 움직인 거리가 욱직이면 되는 거리가 된다.
        // 상하로 움직이는 경우 넓이는 R
        // 좌우로 움직이는 경우 넓이는 C
        void updatePosition() {
            int move = this.speed;
            // 위 아래
            if(dir < 2) {
                move %= ((R-1) * 2);
                while (move > 0) {
                    if(x == 0) {
                        dir = 1;
                    }
                    if(x == R-1) {
                        dir = 0;
                    }
                    x += dx[dir];
                    move--;
                }
            }
            // 좌우
            else {
                move %= ((C-1) * 2);
                while (move > 0) {
                    if(y == 0) {
                        dir = 2;
                    }
                    if(y == C-1) {
                        dir = 3;
                    }
                    y += dy[dir];
                    move--;
                }
            }
        }
    }
}