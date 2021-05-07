package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 동굴 탐험 문제
class CaveExplore {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] before;
    static int[] save;
    static boolean[] visited;
    public boolean solution(int n, int[][] path, int[][] order) {
        graph = new ArrayList<>();
        before = new int[n];
        save = new int[n];
        visited = new boolean[n];

        // graph 초기화
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // graph 노드 설정
        for (int i = 0; i < path.length; i++) {
            graph.get(path[i][0]).add(path[i][1]);
            graph.get(path[i][1]).add(path[i][0]);
        }

        // before 설정
        for (int i = 0; i < order.length; i++) {
            before[order[i][1]] =  order[i][0];
        }

        // 0보다 먼저 방문해야하는 경우가 있으면 false
        if (before[0] != 0) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        for(int node : graph.get(0)) {
            q.offer(node);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            if (visited[now]) {
                continue;
            }

            // 먼저 방문해야하는 곳을 방문 하지 않은 경우
            // 해당 저장한 뒤 먼저 방문해야하는 곳을 방문했을 때 다시 처리할 수 이도록 함
            if (!visited[before[now]]) {
                save[before[now]] = now;
                continue;
            }

            visited[now] = true;
            for (int node : graph.get(now)) {
                q.offer(node);
            }

            // now 노드가 먼저 방문 해야하는 곳으로 저장해 두었던 노드를 다시 처리 하도록 큐에 추가
            q.offer(save[now]);
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
}