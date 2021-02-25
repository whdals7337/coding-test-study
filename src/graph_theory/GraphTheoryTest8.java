package graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Street implements Comparable<Street>{
    private int a;
    private int b;
    private int cost;

    public Street(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCost() {
        return cost;
    }

    public int compareTo(Street other){
        return Integer.compare(this.cost, other.cost);
    }
}

// 도시 분할 계획 문제
public class GraphTheoryTest8 {
    public static int n, m;
    public static int[] parent = new int[100001];
    public static ArrayList<Street> graph = new ArrayList<>();

    public static int findParent(int x){
        if(parent[x] == x) return parent[x];
        else return findParent(parent[x]);
    }

    public static boolean checkSame(int a, int b) {
        if(findParent(a) == findParent(b)) return true;
        else return false;
    }

    public static void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA < parentB) parent[parentB] = parentA;
        else parent[parentA] = parentB;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            graph.add(new Street(a, b, c));
        }

        Collections.sort(graph);

        int totalCost = 0;
        int maxCost = 0;
        for(int i = 0; i < graph.size(); i++){
            Street now = graph.get(i);
            int a = now.getA();
            int b = now.getB();

            if(!checkSame(a, b)){
                union(a, b);
                int cost = now.getCost();
                totalCost += cost;
                maxCost = cost;
            }
        }

        System.out.println(totalCost - maxCost);

    }
}