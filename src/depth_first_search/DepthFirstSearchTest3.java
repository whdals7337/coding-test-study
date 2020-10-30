package depth_first_search;

import java.util.Scanner;

// 삼성전저 SW 역량테스트 - 연구소 문제
class DepthFirstSearchTest3 {

    // 연구소 크기(n x m), 바이러스 퍼진 결과
    public static int n, m, result = 0;
    // 연구소 지도
    public static int[][] map = new int[8][8];
    // 시뮬레이션할 연구소 지도
    public static int[][] temp = new int[8][8];

    // 4가지 방향에 대한 배열
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    // DFS 를 통한 바이러스 퍼트림
    public static void virus(int x, int y){
        for(int i = 0; i < 4; i++ ){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어 나지 않도록 조건
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(temp[nx][ny] == 0){
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    // 빈칸 COUNT
    public static int getScore(){
        int score = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(temp[i][j] == 0){
                    score += 1;
                }
            }
        }
        return score;
    }

    // 방벽 3개를 세운 모든 경우의 수에 대한 DFS 수행
    public static void dfs(int count){
        // 방벽이 3개인 경우
        if(count == 3){
            // 연구실 지도를 시뮬레이션할 맵에 값 복사
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    temp[i][j] = map[i][j];
                }
            }

            // 시뮬레이션 지도에서 바이러스 DFS 수행
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(temp[i][j] == 2){
                        virus(i, j);
                    }
                }
            }
            // 남아있는 빈칸의 합 중 가장 큰 값을 남김
            result = Math.max(result, getScore());
            return;
        }
        // 방벽이 3개가 아닌 경우
        else {
            // 맵 전체에 대해서 방벽을 세우는 경우를 재귀적 방법으로 수행
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(map[i][j] == 0){
                        map[i][j] = 1;
                        count += 1;
                        dfs(count);
                        // map은 연구소 지도로 상태가 유지되어야하기때문에 dfs를 수행 시키도록 한뒤 원상 복귀
                        map[i][j] = 0;
                        count -= 1;

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        //연구실 지도 초기화
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(result);
    }
}
