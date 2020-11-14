package shortest_path;

import java.util.Arrays;
import java.util.Scanner;

// 플로이드 문제
public class ShortestPathTest3 {

    public static final int INF = (int)1e9;
    // 도시 개수, 버스 개수
    public static int n, m;

    // 2차원 배열(그래프) - 최대 도시 갯수 100개
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
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // 비용이 작은 경우만 남김
            graph[a][b] = Math.min(graph[a][b], c);
        }

        // 플로이드 워셜 알로리즘 수행 (기존 거리와 k를 거쳐가는 경우 비교)
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <=n; a++){
                for(int b = 1; b<=n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
