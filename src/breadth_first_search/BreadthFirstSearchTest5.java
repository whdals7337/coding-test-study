package breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Country {
    private int x;
    private int y;

    public Country(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

// 삼성전자 SW 역량테스트 - 인구 이동 문제
public class BreadthFirstSearchTest5{
    public static int n, l, r;
    public static int result = 0;
    public static int[][] graph = new int[50][50];
    public static int[][] unitedIndexes = new int[50][50];

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static void bfs(int x, int y ,int index){
        // 연합 목록
        ArrayList<Country> united = new ArrayList<>();
        united.add(new Country(x, y)); // 연합에 추가
        Queue<Country> q = new LinkedList<>();
        q.offer(new Country(x,y));
        unitedIndexes[x][y] = index; // 현재 연합의 번호 할당
        int summary = graph[x][y]; // 현재 연합의 전체 인구 수
        int count = 1; // 현재 연합의 국가 수
        while(!q.isEmpty()){
            Country now = q.poll();
            int targetX = now.getX();
            int targetY = now.getY();

            // 상하좌우 돌아거면서 연합 조건 검증
            for(int i = 0; i < 4; i++){
                int nx = targetX + dx[i];
                int ny = targetY + dy[i];

                //지도 안이면서 특정 연합에 속하지않은 나라인 경우
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && unitedIndexes[nx][ny] == -1){
                    int gap = Math.abs(graph[targetX][targetY] - graph[nx][ny]);
                    // 두나라의 인구 차이가 특정 조건에 맞는 경우
                    if(gap >= l && gap <= r){
                        q.offer(new Country(nx, ny));
                        unitedIndexes[nx][ny] = index; // 연합 번호 할당
                        summary += graph[nx][ny]; // 연합 총인구수에 추가
                        count += 1; // 연합 국가 수 + 1
                        united.add(new Country(nx, ny)); // 연합에 추가
                    }
                }
            }
        }

        // 연합 국가끼리 인구를 분배
        for (int i = 0; i < united.size(); i++) {
            x = united.get(i).getX();
            y = united.get(i).getY();
            graph[x][y] = summary / count;
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        while(true){
            // 각 나라의 연합 번호 초기화
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    unitedIndexes[i][j] = -1;
                }
            }
            
            //연합 숫자 초기화
            int index = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    // 연합에 속하지 않은 경우 => 해당 나라를 기준을 연합 조회 및 인구 이동
                    if(unitedIndexes[i][j] == -1){
                        bfs(i, j, index);
                        index += 1;
                    }
                }
            }
            // 모든 인구 이동이 끝난 경우 => 연합 인덱스가 n * n라는 이야기는 각자의 나라가 혼자서 연합을 이루고 있다는 말 => 연합의 수 == 나라의 수
            if (index == n * n) break;
            result += 1;
        }

        // 인구 이동 횟수 출력
        System.out.println(result);
    }
}