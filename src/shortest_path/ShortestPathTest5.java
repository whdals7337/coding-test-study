package shortest_path;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node4 implements Comparable<Node4>{
    private int x;
    private int y;
    private int distance;

    public Node4(int x, int y, int distance){
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

    public int compareTo(Node4 other){
        return Integer.compare(this.distance, other.distance);
    }


}

// 화성 탐사 문제
public class ShortestPathTest5 {
    public static int testCase, n;
    public static int[][] graph = new int[125][125];
    public static int[][] d = new int[125][125];
    public static final int INF = (int) 1e9;
    // 상, 하, 좌, 우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();
        for(int tc = 0; tc < testCase; tc++){
            n = sc.nextInt();

            for(int a = 0; a < n; a++){
                for(int b = 0; b < n; b ++){
                    graph[a][b] = sc.nextInt();
                }
            }

            for(int i = 0; i < n; i++){
                Arrays.fill(d[i], INF);
            }

            // 시작 지점(0, 0)
            int x = 0, y = 0;
            PriorityQueue<Node4> pq = new PriorityQueue<>();
            pq.offer(new Node4(x,y,graph[x][y]));
            // 시작 지점 에너지 소모량 셋팅
            d[x][y] = graph[x][y];

            while(!pq.isEmpty()){
                Node4 node = pq.poll();
                x = node.getX();
                y = node.getY();
                int distance = node.getDistance();
                if( d[x][y] < distance ) continue;

                // 현재 노드와 인접한 노드 (4가지 방향)
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // 맵의 범위를 벗어나는 경우
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    
                    // 현재 노드를 거쳐서 다른 노드로 이동하는 경우
                    int cost = distance + graph[nx][ny];
                    if(cost < d[nx][ny]){
                        d[nx][ny] = cost;
                        pq.offer(new Node4(nx,ny,cost));
                    }
                }
            }
            System.out.println(d[n-1][n-1]);
        }
    }
}
