package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    private final int index;
    private final int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

// 프로그래머스 배달 문제
class Delivery {
    static List<List<Node>> graph = new ArrayList<>();
    static int[] d;
    static int INF = 2_000 * 50 + 1;

    public int solution(int N, int[][] road, int K) {
        d = new int[N + 1];
        Arrays.fill(d, INF);
        for (int i = 0 ; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] street : road) {
            int nodeA = street[0];
            int nodeB = street[1];
            int cost = street[2];

            graph.get(nodeA).add(new Node(nodeB, cost));
            graph.get(nodeB).add(new Node(nodeA, cost));
        }

        dijkstra();

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (d[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        d[1] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nIdx = node.getIndex();
            int nCost = node.getCost();

            if (d[nIdx] < nCost) {
                continue;
            }

            List<Node> nodes = graph.get(nIdx);
            for (Node next : nodes) {
                int cost = next.getCost() + nCost;

                if (cost < d[next.getIndex()]) {
                    d[next.getIndex()] = cost;
                    pq.offer(new Node(next.getIndex(), cost));
                }
            }
        }
    }
}