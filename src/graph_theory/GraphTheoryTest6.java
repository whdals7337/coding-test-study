package graph_theory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge2 implements Comparable<Edge2> {
    private int nodeA;
    private int nodeB;
    private int distance;

    public Edge2(int a, int b, int distance){
        this.nodeA = a;
        this.nodeB = b;
        this.distance = distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public int compareTo(Edge2 other) {
        return Integer.compare(this.distance, other.distance);
    }
}

class Position implements Comparable<Position>{
    private int value;
    private int index;

    public Position (int value, int index){
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    public int compareTo(Position other){
        if(this.value == other.value){
            return Integer.compare(this.index, other.index);
        }
        return Integer.compare(this.value, other.value);
    }
}
// 행성 터널 문제
public class GraphTheoryTest6 {
    public static int n;
    public static int[] parents = new int[1000001];
    public static ArrayList<Edge2> edges = new ArrayList<>();

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

        // 부모테이블상의 부모를 자기자신으로 초기화
        for(int i=1; i<=n; i++){
            parents[i] = i;
        }

        ArrayList<Position> arrayX = new ArrayList<>();
        ArrayList<Position> arrayY = new ArrayList<>();
        ArrayList<Position> arrayZ = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            arrayX.add(new Position(x, i));
            arrayY.add(new Position(y, i));
            arrayZ.add(new Position(z, i));
        }

        Collections.sort(arrayX);
        Collections.sort(arrayY);
        Collections.sort(arrayZ);

        for(int i = 0; i < n-1; i++){
            edges.add(new Edge2(arrayX.get(i).getIndex(), arrayX.get(i+1).getIndex(), arrayX.get(i+1).getValue() - arrayX.get(i).getValue()));
            edges.add(new Edge2(arrayY.get(i).getIndex(), arrayY.get(i+1).getIndex(), arrayY.get(i+1).getValue() - arrayY.get(i).getValue()));
            edges.add(new Edge2(arrayZ.get(i).getIndex(), arrayZ.get(i+1).getIndex(), arrayZ.get(i+1).getValue() - arrayZ.get(i).getValue()));
        }
        Collections.sort(edges);

        int result = 0;
        for(int i = 0; i<edges.size(); i++){
            Edge2 now = edges.get(i);
            int cost = now.getDistance();
            int nodeA = now.getNodeA();
            int nodeB = now.getNodeB();

            if(findParent(nodeA) != findParent(nodeB)){
                unionParent(nodeA, nodeB);
                result += cost;
            }
        }
        System.out.println(result);
    }
}
