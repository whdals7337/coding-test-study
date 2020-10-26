package shorttest_path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node3 implements Comparable<Node3> {
   private int index;
   private int distance;

   public Node3(int index, int distance){
       this.index = index;
       this.distance= distance;
   }

   public int getIndex(){
       return this.index;
   }

   public int getDistance(){
       return this.distance;
   }

    @Override
    public int compareTo(Node3 other) {
       // 거리 비용이 짧은 것이 더 높은 우선 순위를 가질수 있도록 조건
       if(this.distance < other.distance){
           return -1;
       }
       return 1;
    }
}

public class ShortestPathTest1 {

    public static final int INF = (int) 1e9; // 10억 (무한을 의미)
    public  static int n, m, start; // 도시의 갯수, 통로의 갯수, 시작 노드

    public static ArrayList<ArrayList<Node3>> graph = new ArrayList<ArrayList<Node3>>();

    // 거리 목록
    public  static int[] d = new int[30001];

    public static void dijkstra(int start){
        //시작 노드 최단 경로를 0으로 셋팅하여 큐에 삽입
        PriorityQueue<Node3> pq = new PriorityQueue<>();
        pq.offer(new Node3(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()){
            // 큐에서 최단 거리가 짧은 노드에 대한 정보 추출
            Node3 node = pq.poll();
            int dist = node.getDistance();
            int now = node .getIndex();

            // 큐에서 추출한 값이 거리 목록의 값보다 클경우 이미 방문하여 처리한 값이므로 넘어감
            if(dist > d[now]) continue;

            for(int i =0; i < graph.get(now).size(); i++ ){
                int cost = d[now] + graph.get(now).get(i).getDistance();

                // 비용 거리가 기존보다 작을 경우 -> 아직 처리되지 않은 노드로 판단하여 갱신 후 해당 노드에 연결된 노드 계산
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node3(graph.get(now).get(i).getIndex(), cost));
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
            graph.add(new ArrayList<Node3>());
        }

        for(int j = 0; j < m; j++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            // x 도시에서 y도시 가는 거리가 z
            graph.get(x).add(new Node3(y, z));
        }

        // 최단 거리 리스트 무한으로 초기화
        Arrays.fill(d, INF);
        
        // 다익스트라 알고리즘
        dijkstra(start);
        
        // 도달할 수 있는 도시의 수 초기화
        int count = 0;
        // 도달할 수 있는 도시 중 가장 멀리 있는 도시와의 최단 거리
        int max_distance = 0;
        for (int i = 1; i <= n; i++) {
            // 도달할 수 있는 도시인 경우
            if (d[i] != INF) {
                count++;
                max_distance = Math.max(max_distance, d[i]);
            }
        }
        // 시작노드를 제외해야 하므로 -1
        System.out.print((count-1) +" " + max_distance);
    }
}
