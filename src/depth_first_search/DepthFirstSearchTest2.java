package depth_first_search;

import java.util.*;

public class DepthFirstSearchTest2 {

    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    public static boolean dfs(int x, int y){
        // 입력받은 좌표가 틀을 벗어나는 경우
        if(x < 0 || x >= n || y < 0 || y >= m){
            return false;
        }

        // 구멍이 뚫려 있는 영역인 경우
        if(graph[x][y] == 0){
            // 해당 영역을 1로 바꾸고 상하좌우 모두 1로 바꾸는 처리 후 true 반환
            graph[x][y] = 1;
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);
            return true;
        }
        // 칸막이가 있는 공간인 경우
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        // N, M을 공백을 기준으로 구분하여 입력 받기 (1<= n,m <=1000)
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                // 입력받은 값을 숫자로
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // dfs를 2차원 리스트 전체에서 사용
        for(int i=0; i<n; i++){
            for(int j=0; j < m; j++){
                // 2차원 배열 중 0인 경우 카운트
                if(dfs(i,j)){
                    count+=1;
                }
            }
        }

        System.out.println(count);
    }
}
