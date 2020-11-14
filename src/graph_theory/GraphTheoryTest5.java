package graph_theory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Node implements Comparable<Node> {
    private int x;
    private int y;
    private int distance;

    public Node(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    public int compareTo(Node other){
        return Integer.compare(this.distance, other.distance);
    }
}
// 어두운 길 문제
public class GraphTheoryTest5 {
    // 집 개수, 도로 개수
    public static int n, m;
    public static int[] parents = new int[200000];
    public static ArrayList<Node> nodes = new ArrayList<Node>();

    public static int findParent(int x){
        if(parents[x] == x) return x;
        else return findParent(parents[x]);
    }

    public static void unionParent(int a, int b){
        int a_parent = findParent(a);
        int b_parent = findParent(b);
        if(a_parent > b_parent) parents[a_parent] = b_parent;
        else parents[b_parent] = a_parent;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 자기 자신을 부모로 셋팅
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        // 집 사이의 도로 비용 정보 셋팅
        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int distance = sc.nextInt();
            nodes.add(new Node(x, y, distance));
        }

        // 비용이 낮은 순서로 정렬
        Collections.sort(nodes);

        int allCost = 0; // 모든 가로수 비용
        int savedCost = 0; // 최소 가로수 비용
        for(int i = 0; i < nodes.size(); i++){
            Node node = nodes.get(i);
            int a = node.getX();
            int b = node.getY();
            int cost = node.getDistance();
            allCost += cost;

            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                savedCost += cost;
            }
        }

        // 졀약 가능한 비용
        int saveMoney = allCost - savedCost;
        System.out.println(saveMoney);
    }
}
