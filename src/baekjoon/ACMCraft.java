package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// ACM.Craft 문제 - 1005번
public class ACMCraft {

    static int T, N, K, W;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] times, inDegree, dp;

    static void solution() {
        // dp 테이블 초기화
        dp = new int[N+1];

        // 진입 차수가 0 인 건물 큐에 추가 및 dp 테이블 값 셋팅
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
                dp[i] = times[i];
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == W) break; // 승리를 위한 건물 까지 도달했으면 break

            // 현재 건물의 상위 건물들 셋팅
            ArrayList<Integer> nodes = graph.get(now);
            for(int node : nodes){
                // 상위 건물의 경우 하위 건물이 건설된 뒤에 건설 할수 있으므로 큰 값으로 dp값 초기화
                dp[node] = Math.max(dp[node], dp[now] + times[node]);

                // 현재 건물 상위 건물의 진입차수 -1
                inDegree[node] -= 1;

                // 진입차수가 0이 된 건물 큐에 추가
                if(inDegree[node] == 0) {
                    q.offer(node);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            st = new StringTokenizer(br.readLine(), " ");

            // 건물 갯수, 건설 규칙 갯수
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // graph 초기화
            graph = new ArrayList<>();
            for(int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            // 건설 시간
            times = new int[N+1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            // 진입 차수
            inDegree = new int[N+1];
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                inDegree[b] += 1;
            }

            // 승릴를 위한 건물 인덱스
            W = Integer.parseInt(br.readLine());

            // 위상정렬 수행
            solution();

            sb.append(dp[W]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}