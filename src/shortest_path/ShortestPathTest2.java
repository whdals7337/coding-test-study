package shortest_path;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestPathTest2 {

    public static final int INF = (int)1e9;
    // 회사의 갯수, 도로의 갯수, 거쳐갈 회사, 최종 목적지
    public static int n, m, x, k;

    // 2차원 배열(그래프) - 최대 회사 갯수 100개
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단거리 테이블을 모두 무한으로 초기화
        for(int i = 0; i < 101; i++){
            Arrays.fill(graph[i], INF);
        }

        // 자기자산의 최단거리 0으로 초기화
        for(int a = 1; a <= n; a++){
            for(int b = 1; b<=n; b++){
                if(a == b) graph[a][b] = 0;
            }
        }

        // 각 간선의 값들을 입력 받아서 최단 거리 테이블 초기화
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        // 플로이드 워셜 알로리즘 수행 (기존 거리와 k를 거쳐가는 경우 비교)
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <=n; a++){
                for(int b = 1; b<=n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 전체 테이블 출력
        for(int i= 1; i < n+1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 계산 대상 거리인 경우
                if((i == 1 && j == k) ||( i == k && j == x)){
                    System.out.print("\""+graph[i][j]+"\"" + " ");
                }
                // 계산 대상이 아닌 경우
                else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }

        int distance = graph[1][k] + graph[k][x];

        // 회사에 도달할 수 없는경우 (불가능이 10억이므로 10억 이상인경우는 도달할 수 없음을 의미)
        if(distance >= INF){
            System.out.println(-1);
        }
        // 회사에 도달할 수 있는 경우
        else {
            System.out.println(distance);
        }
    }
}
