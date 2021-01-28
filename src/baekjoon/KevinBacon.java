package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 케빈 베이컨의 6단계 법칙 문제 - 1389번
public class KevinBacon {

    static int N, M, result;
    static int MAXVALUE = 101; // 사람과 사람 사이 최대 관계: 100
    static int[][] graph = new int[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], MAXVALUE);
            graph[i][i] = 0;
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // 플로이드 워셜 알로리즘 수행 (기존 거리와 k를 거쳐가는 경우 비교)
        for(int k = 1; k <= N; k++){
            for(int a = 1; a <=N; a++){
                for(int b = 1; b<=N; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int minValue = 10001; // 최대관계 100 * 100명
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                sum += graph[i][j];
            }
            if(minValue > sum) {
                minValue = sum;
                result = i;
            }
        }

        System.out.println(result);
    }
}