package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 외판원 순회 문제 - 2098번
public class Salesman {

    static int N;
    static int[][] distances;
    static int[][] dp;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N][1<<N];
        for(int[] arr : dp) {
            Arrays.fill(arr, INF);
        }

        distances = new int[N][N];
        for(int i =0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N;  j++) {
                distances[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tps(0, 1));
    }

    static int tps(int node, int bitsMask) {
        // 마지막 도시를 방문한 경우
        if(bitsMask == (1 << N) - 1) {
            // 마지막으로 방문한 도시에서 0번 도시로 갈 수 없는 경우
            if(distances[node][0] == 0) {
                return INF;
            }
            // 마지막으로 방문한 도시에서 0번 도시로 가는 거리 리턴
            return distances[node][0];
        }

        // 이미 계산된 경우
        if(dp[node][bitsMask] != INF) {
            return dp[node][bitsMask];
        }

        // 지금의 노드에서 다음 노드을 가는 경우
        for(int nextNode = 0; nextNode< N; nextNode++) {
            // 다음 노드의 비트 마스크
            int nextBitsMask = bitsMask | (1 << nextNode);

            // 현재 노드에서 다음 노드로 갈수 없거나 이미 방문한 경우
            if(distances[node][nextNode] == 0 || (bitsMask & (1 << nextNode)) != 0) {
                continue;
            }
            dp[node][bitsMask] = Math.min(dp[node][bitsMask], tps(nextNode, nextBitsMask) + distances[node][nextNode]);
        }
        return dp[node][bitsMask];
    }
}