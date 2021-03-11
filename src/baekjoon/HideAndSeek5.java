package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질5 문제 - 17071번
public class HideAndSeek5 {

    static int N, K;
    static boolean[][] visited = new boolean[500001][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            System.out.println(0);
        }else {
            System.out.println(bfs(N));
        }
    }

    static int bfs(int start) {
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start][time] = true;

        while (!q.isEmpty()) {
            // K가 범위를 벗어나는 경우
            if(K > 500000) {
                return -1;
            }

            // time 의 짝수 홀수
            int newTime = time % 2;

            // 만난 경우(짝수, 홀수)
            if(visited[K][newTime]) {
                return time;
            }

            // 현재 q의 사이즈 만큼만 돌리기 - 시간 계산을 위해서
            for(int j = 0, size = q.size(); j < size; j++) {
                int now = q.poll();
                // 다음 이동의 짝수 홀수 여부
                int nextTime = (time + 1) % 2;
                int next;

                // 다음에서 영역을 방문 처리
                next = now - 1;
                if(next >= 0 && !visited[next][nextTime]) {
                    visited[next][nextTime] = true;
                    q.offer(next);
                }

                next = now + 1;
                if(next < 500001 && !visited[next][nextTime]) {
                    visited[next][nextTime] = true;
                    q.offer(next);
                }

                next = now * 2;
                if(next < 500001 && !visited[next][nextTime]) {
                    visited[next][nextTime] = true;
                    q.offer(next);
                }
            }
            time++;
            K += time;
        }
        return -1;
    }
}