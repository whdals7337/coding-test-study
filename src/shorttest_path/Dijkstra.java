package shorttest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

 class Node {
    private int index;
    private int distance;

    public Node(int index, int distance){
        this.index = index;
        this.distance= distance;
    }

    public int getIndex(){
        return this.index;
    }

    public int getDistance(){
        return this.distance;
    }
}

public class Dijkstra {

    public static final int INF = (int) 1e9; // 10억 (무한을 의미)
    public  static int n, m, start; // 노드의 갯수, 간선의 갯수, 시작 노드

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 방문여부 목록
    public  static boolean[] visited = new boolean[100001];
    // 거리 목록
    public  static int[] d = new int[100001];

    // 현시점 최단 거리의 노드의 인덱스를 리턴
    public static int getSmallestNode(){
        int min_value = INF;
        int index = 0;
        for(int i = 0; i<=n; i++){
            if(d[i] < min_value && !visited[i]){
                min_value = d[i];
                index = i;
            }
        }

        return  index;
    }

    public static void dijkstra(int start){
        // 시작노드의 거리 및 방문 초기화
        d[start] = 0;
        visited[start] = true;

        // 시작 노드와 바로 연결된 노드들의 거리를 설정
        for(int j =0; j<graph.get(start).size(); j++){
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        // 시작 노드를 제외한 전체 노드에 대해서 거리 계산
        for(int i =0; i< n-1; i++){
            // 시작 노드에서 방문하지않은 노드중 최단 거리 인덱스
            int now = getSmallestNode();
            visited[now] = true; // 방문처리

            // now 노드와 연결된 다른 노드를 확인
            for(int j = 0; j < graph.get(now).size(); j++){
                // now 노드와 연결된 다른 노드의 거리
                int cost =d[now] + graph.get(now).get(j).getDistance();
                
                // 연결된 다른 노드을 통한 거리가 기존 거리보다 짧으면 해당 거리로 거리목록 수정
                if(cost < d[graph.get(now).get(j).getIndex()]){
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int j = 0; j < m; j++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // a 노드에서 b 노드 가는 거리가 c
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 리스트 무한으로 초기화
        Arrays.fill(d, INF);

        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
    }
}
