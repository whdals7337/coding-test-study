package programmers;

import java.util.PriorityQueue;

// 프로그래머스 섬 연결하기 문제
class Bridge implements Comparable<Bridge> {
    int a;
    int b;
    int cost;

    public Bridge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    public int compareTo(Bridge other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class BridgeConnect {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        for(int[] cost : costs){
            pq.offer(new Bridge(cost[0], cost[1], cost[2]));
        }

        while (!pq.isEmpty()) {
            Bridge now = pq.poll();
            int nodeA = now.a;
            int nodeB = now.b;
            int cost = now.cost;

            if(find(nodeA) != find(nodeB)) {
                union(nodeA, nodeB);
                answer += cost;
            }
        }

        return answer;
    }

    public int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA > parentB) {
            parent[parentA] = parentB;
        }else {
            parent[parentB] = parentA;
        }
    }
}