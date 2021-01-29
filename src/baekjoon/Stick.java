package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 막대기 문제 - 1094번
public class Stick {
    static int x;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static void solution() {
        while(true) {
            // 가지고 있는 막대의 총합
            int total = sum();

            // 총합이 x와 같다면
            if (total == x) {
                return;
            } else if(total > x) {

                // 가장 작은 막대를 절반으로 절단
                int temp = pq.poll() / 2;

                // 절반을 큐에 다시 넣음
                pq.offer(temp);

                // 절단 된 막대 절반을 제외한 값이 x보다 작은 경우 버리지 않음
                if (sum() < x) {
                    pq.offer(temp);
                }
            }
        }
    }

    static int sum() {
        int value = 0;
        for (Integer i : pq) {
            value += i;
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        pq.offer(64);
        solution();
        System.out.println(pq.size());
    }
}