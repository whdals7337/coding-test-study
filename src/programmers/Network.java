package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 네트워크 문제
class Network {
    static int answer = 0;
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        for(int i =0; i < n; i++) {
            if(!visited[i]) {
                bfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }

    static void bfs(int[][] computers, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0; i < computers.length; i++) {
                if(computers[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}