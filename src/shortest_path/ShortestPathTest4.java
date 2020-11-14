package shortest_path;

import java.util.Arrays;
import java.util.Scanner;

// 정확한 순위 문제
public class ShortestPathTest4 {

    public static final int INF = (int)1e9;
    // 학생의 수, 성적비교 횟수
    public static int n, m;

    // 2차원 배열(그래프) - 최대 학생 수 500명
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
        for(int i=0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 비용이 작은 경우만 남김
            graph[a][b] = 1;
        }

        // 플로이드 워셜 알로리즘 수행 (기존 거리와 k를 거쳐가는 경우 비교)
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <=n; a++){
                for(int b = 1; b<=n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int count = 0;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if (graph[i][j] != INF || graph[j][i] != INF) {
                    cnt += 1;
                }
            }
            if(cnt == n){
                count += 1;
            }
        }
        System.out.println(count);
    }
}
