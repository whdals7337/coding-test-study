package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로 문제 - 1753번
class ShortestPathNode implements Comparable<ShortestPathNode> {
    int index;
    int distance;

    public ShortestPathNode(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int compareTo(ShortestPathNode other) {
        return  Integer.compare(this.distance, other.distance);
    }
}

public class ShortestPath {

    static int V, E, K;
    static ArrayList<ArrayList<ShortestPathNode>> graph = new ArrayList<>();
    static int INF = (int)1e9;
    static int[] dp;

    static void dijkstra(int start) {
        PriorityQueue<ShortestPathNode> pq = new PriorityQueue<>();
        pq.offer(new ShortestPathNode(start, 0));
        dp[start] = 0;

        while (!pq.isEmpty()) {
            ShortestPathNode now = pq.poll();
            if(dp[now.index] < now.distance) continue;

            ArrayList<ShortestPathNode> nodes = graph.get(now.index);
            for (ShortestPathNode node : nodes) {
                int cost = node.distance + now.distance;

                if(cost < dp[node.index]) {
                    dp[node.index] = cost;
                    pq.offer(new ShortestPathNode(node.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        for(int i = 0; i<= V; i++) {
            graph.add(new ArrayList<>());
        }

        dp = new int[V+1];
        Arrays.fill(dp, INF);

        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < E; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            graph.get(u).add(new ShortestPathNode(v,w));
        }
    
        // 다익스트라 알고리즘 적용
        dijkstra(K);

        for(int i = 1; i <= V; i++) {
            System.out.println(dp[i] == INF ? "INF" : String.valueOf(dp[i]));
        }
    }
}