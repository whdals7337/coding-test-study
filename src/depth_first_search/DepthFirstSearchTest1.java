package depth_first_search;

import java.util.ArrayList;

public class DepthFirstSearchTest1 {
    public static boolean[] visited = new boolean[9];
    public  static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public  static  void  dfs(int start){
        // 현재 방문한 노드를 방문처리 (true : 방문, false: 미방문)
        visited[start] = true;
        System.out.print(start + " ");

        // 현재 방문한 노드와 간선으로 연결된 노드 만큼 반복
        for (int i =0; i < graph.get(start).size(); i++){

            // 간선으로 연결된 노드가 아직 방문하지 않은경우 방문
            int y = graph.get(start).get(i);
            if(!visited[y]){
                dfs(y);
            }
        }
    }
    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
    }
}
