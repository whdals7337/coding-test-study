package shortest_path;

import java.util.Arrays;
import java.util.Scanner;

public class FloyedWarshall {

    public static final int INF = (int)1e9;
    // 노드의 갯수, 간선의 갯수
    public static int n, m;

    // 2차원 배열(그래프) - 최대노드 갯수가 500이라고 가정
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단거리 테이블을 모두 무한으로 초기화
        for(int i = 0; i < 501; i++){
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
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        // 플로이드 워셜 알로리즘 수행 (기존 거리와 k를 거쳐가는 경우 비교)
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <=n; a++){
                for(int b = 1; b<=n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 수행된 결과를 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }
    }
}
