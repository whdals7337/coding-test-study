package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질2 문제 - 12851번
public class HideAndSeek2 {

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int time = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 두 사람이 같은 장소에 있는 경우
        if(N == K){
            System.out.println(0);
            System.out.println(1);
        }else {
            bfs(N);
            System.out.println(time);
            System.out.println(count);
        }
    }

    static void bfs(int start) {
        time = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            // 만나 경우가 1번이라도 있으면 다음 계산부터는 최소가 아님
            if(count != 0) {
                return;
            }

            // 현재 q의 사이즈 만큼만 돌리기 - 시간 계산을 위해서
            for(int j = 0, size = q.size(); j < size; j++) {
                int now = q.poll();
                // 현재 방문 처리 - 현재를 방문한 시점 이후로 나오는 모든 방문은 중복처리
                visited[now] = true;
                int next;

                // 다음에서 만나는 경우 count + 1
                // 다음에서 못 만나는 경우 큐에 추가
                next = now - 1;
                if(next == K) {
                    count++;
                } else if(next >= 0 && !visited[next]) {
                    q.offer(next);
                }

                next = now + 1;
                if(next == K) {
                    count++;
                } else if(next < 100001 && !visited[next]) {
                    q.offer(next);
                }

                next = now * 2;
                if(next == K) {
                    count++;
                } else if(next < 100001 && !visited[next]) {
                    q.offer(next);
                }
            }
            time++;
        }
    }
}