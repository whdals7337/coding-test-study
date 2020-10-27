package graph_theory;

import java.util.*;

public class Topology {
    // 노드의 개수, 간선의 개수
    public static int v, e;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int[] indegree = new int[100001]; // 진입 차수

    public static void topologySort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // 초기 진입 차수가 0인 노드를 q 에 추가
        for(int i = 1; i <= v; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for(int i =0; i < graph.get(now).size(); i++){
                // 현재 노드와 연결된 간선 제거
                indegree[graph.get(now).get(i)] -=1;

                // 진입차수가 0이 되는 경우 q 에 추가
                if(indegree[graph.get(now).get(i)] == 0){
                    q.offer(graph.get(now).get(i));
                }
            }

        }
        
        //위상 정렬 수행 결과
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 그래프 초기화
        for(int i = 0; i <= v; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        // 방향 그래프의 간선 정보 입력 받기
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            // a에서 b로 가는 간선 
            graph.get(a).add(b);
            
            //진입차수 + 1
            indegree[b] += 1;
        }
        // 위상정렬 실행
        topologySort();
    }
}
