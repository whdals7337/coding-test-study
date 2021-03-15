package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 가장 먼 노드 문제
class FurthermostNode {
    public int solution(int n, int[][] edge) {
        // 방문 여부 초기화
        boolean[] visited = new boolean[n+1];

        // dp를 최대값으로 초기화
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // graph 간선 셋팅
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] node : edge) {
            graph.get(node[0]).add(node[1]);
            graph.get(node[1]).add(node[0]);
        }

        // 큐에 1노드 추가
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dp[1] = 1; // 1노드의 자기 자신의 거리는 1
        visited[1] = true; // 1노드 방문
        int max = 0; // dp의 최대값을 셋팅하면서 구할수 있도록 셋팅

        // 큐 선회
        while(!q.isEmpty()) {
            int now = q.poll();

            ArrayList<Integer> nodes = graph.get(now);
            for(int node : nodes) {
                if(!visited[node]) {
                    visited[node] =true;
                    dp[node] = Math.min(dp[node], dp[now] + 1);
                    q.offer(node);
                    max = Math.max(dp[node], max);
                }
            }
        }

        // dp 순회하면서 가장 먼 노드 카운트
        int answer = 0;
        for (int i = 1; i < dp.length; i++) {
            if(dp[i] == max) answer++;
        }
        return answer;
    }
}