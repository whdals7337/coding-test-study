package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 문제 - 1697번
public class HideAndSeek1 {

    static int N, K;
    static int time;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            System.out.println(0);
        }else {
            bfs(N);
            System.out.println(time);
        }
    }

    static void bfs(int start) {
        time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            // 만난 경우
            if(visited[K]) {
                return;
            }

            // 현재 q의 사이즈 만큼만 돌리기 - 시간 계산을 위해서
            for(int j = 0, size = q.size(); j < size; j++) {
                int now = q.poll();
                int next;

                // 다음에서 영역을 방문 처리
                next = now - 1;
                if(next >= 0 && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }

                next = now + 1;
                if(next < 100001 && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }

                next = now * 2;
                if(next < 100001 && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
            time++;
        }
    }
}