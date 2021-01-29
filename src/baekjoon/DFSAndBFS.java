package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// DFS와 BFS 문제 - 1260번
public class DFSAndBFS {
    static int n, m, v;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static void dfs(int start) {
        // 방문 처리
        if(!visited[start]) {
            visited[start] = true;
            System.out.print(start + " ");
        }

        ArrayList<Integer> nodes = graph.get(start);
        for (Integer node : nodes) {
          if(!visited[node]) {
              dfs(node);
          }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        // 방문처리
        visited[start] = true;
        System.out.print(start + " ");

        while(!q.isEmpty()) {
            int target = q.poll();
            ArrayList<Integer> nodes = graph.get(target);
            for (Integer node : nodes) {
                if(!visited[node]) {
                    q.offer(node);
                    visited[node] = true;
                    System.out.print(node + " ");
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        for (int i = 0; i <=n; i++) {
            graph.add(new ArrayList<>());
        }
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        for(int i = 0; i< m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (ArrayList<Integer> integers : graph) {
            Collections.sort(integers);
        }

        dfs(v);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(v);
    }
}