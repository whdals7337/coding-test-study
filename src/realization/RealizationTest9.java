package realization;

import java.util.*;

class Node{
    private int time;
    private char direction;

    public Node(int time, char direction){
        this.time = time;
        this.direction = direction;
    }

    public int getTime(){
        return this.time;
    }

    public char getDirection(){
        return this.direction;
    }
}

class Position{
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class RealizationTest9 {
    // 보드의 크기, 사과의 개수, 뱀의 방향 변환 횟수
    public static int n, k, l;
    // 맵 정보
    public static int[][] map = new int[101][101];
    // 방향 전환 정보
    public static ArrayList<Node> info = new ArrayList<>();
    //방향 설정 (동, 남, 서, 북)
    public static int[] dx = {0, 1, 0 , -1};
    public static int[] dy = {1, 0, -1 , 0};

    // 방향 전환
    public static int turn(char c, int direction){
        if(c == 'L'){
           direction = (direction == 0) ? 3 : direction-1;
        } else {
            direction = (direction == 3) ? 0 : direction + 1;
        }
        return direction;
    }

    public static int simulate(){
        int x = 1, y = 1; // 처음 뱀의 위치
        map[x][y] = 2; // 뱀의 머리의 위치를 2( 0은 벽, 1은 사과, 2는 뱀의 몸)
        int direction = 0; // 방향
        int time = 0; // 시간
        int index = 0; // 회전 정보 인덱스
        // 뱀의 위치
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 맵의 범위안, 뱀의 몸통이 없는 위치인 경우
            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && map[nx][ny] != 2) {
                // 사과가 있다면 이동 후에 꼬리 제거
                if(map[nx][ny] == 0){
                    map[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                    Position prev = q.poll();
                    map[prev.getX()][prev.getY()] = 0;
                }
                // 사과가 있다면 이동만 진행
                else if(map[nx][ny] == 1) {
                    map[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                }
            }
            // 벽이나 뱀의 몸통에 부딪히는 경우
            else {
                time += 1;
                break;
            }

            // 다음 위치로 머리를 이동
            x = nx;
            y = ny;
            time += 1;

            // 회전해야하는 목록이 있고 회전 해야하는 시간인 경우 회전
            if(index < l && time == info.get(index).getTime()){
                direction = turn(info.get(index).getDirection(), direction);
                // 다음 목록을 가르키도록 +1
                index += 1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        // 사과 위치 맵에 셋팅
        for (int i = 0; i < k; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
        }

        l = sc.nextInt();

        //방향 전환 정보 셋팅
        for(int i =0; i<l; i++){
            int t = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(t,c));
        }

        System.out.println(simulate());
    }
}
