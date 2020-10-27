package graph_theory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge( int distance, int nodeA, int nodeB){
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance(){
        return this.distance;
    }

    public int getNodeA(){
        return this.nodeA;
    }

    public int getNodeB(){
        return  this.nodeB;
    }

    @Override
    public int compareTo(Edge other) {
        if(this.distance < other.distance){
            return -1;
        }
        return 1;
    }
}

public class Kruskal {
    public static int[] parent = new int[100001]; // 부모테이블

    public static int findParent(int x){
        // 루트 노드를 재귀적으로 호출하여 찾음
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        // 루트 노드 중 큰 값을 작은 값으로 초기화
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {

        // 노드의 개수, 간선의 개수
        int v, e;
        ArrayList<Edge> edges = new ArrayList<>(); // 노드간의 간선과 비용을 담을 리스트
        int result = 0; // 신장트리의 모든 비용의 합

        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모테이블상의 부모를 자기자신으로 초기화
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        // 간선을 입력받음
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost,a,b));
        }

        // 간선을 비용순으로 정렬
       Collections.sort(edges);

        //간선을 확인면서 신장트리로
        for(int i =0; i < edges.size(); i++){
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            // 사이클이 발생하지 않는 경우
            if(findParent(a) != findParent(b)){
                unionParent(a,b);
                result+= cost;
            }
        }

        System.out.println(result);
    }
}
