package breadth_first_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 특정 거리의 도시 찾기 문제
public class BreadthFirstSearchTest3 {

    // 도시의 개수, 도로의 개수, 목표하는 최단 거리, 출발 도시
    public static int n, m, k, x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // 모든 도시에 대한 최단 거리 목록
    public static int[] d = new int[300001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        // 그래프 및 최단거리 초기화
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        // 도로 정보 입력
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        // 출발 도시의 최단 거리는 0
        d[x] = 0;

        //BFS를 통한 최단거리 계산
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0; i < graph.get(now).size(); i++){
                int next = graph.get(now).get(i);
                if (next == -1) {
                    d[next] = d[now] + 1;
                    q.offer(next);
                }
            }
        }

        // 최단거리가 K인 도시들 출력
        boolean check  = false;
        for(int i = 1; i <= n; i++){
            if(d[i] == k){
                System.out.println(i);
                check = true;
            }
        }

        // 최던 거리가 K인 도시가 없을 경우
        if(!check) System.out.println(-1);
    }
}
