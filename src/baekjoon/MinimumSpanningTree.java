package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    private int start;
    private int end;
    private int distance;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getDistance() {
        return distance;
    }

    public Node(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance, o.distance);
    }
}

// 최소 스패닝 트리(최소 신장 트리) - 1197번
public class MinimumSpanningTree {

    static int v, e;
    static ArrayList<Node> graph = new ArrayList<>();
    static int[] parents;

    // 부모 찾기
    static int findParent(int a) {
        if(parents[a] == a) return a;
        else return findParent(parents[a]);
    }


    // 부모 합치기
    static void combineParent(int a, int b) {
        int aParent = findParent(a);
        int bParent = findParent(b);

        if(aParent < bParent) parents[bParent] = aParent;
        else parents[aParent] = bParent;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int result = 0;

        parents = new int[v + 1];
        for(int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < e; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            graph.add(new Node(a, b, c));
        }
        Collections.sort(graph);

        for(int i = 0; i < e; i++) {
            Node node = graph.get(i);
            int start = node.getStart();
            int end = node.getEnd();

            // 싸이클 미발생시
            if(findParent(start) != findParent(end)) {

                // 트리 연결
                combineParent(start, end);

                // 간선 값 +
                result += node.getDistance();
            }
        }
        System.out.println(result);
    }
}