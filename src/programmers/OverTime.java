package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

// 프로그래머스 야근 지수 문제
class OverTime {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        while(n > 0) {
            int max = pq.poll();
            if(!pq.isEmpty()) {
                int second = pq.peek();
                int temp = max - second + 1;
                int min = Math.min(temp, n);
                pq.offer(max - min);
                n -= min;
            }else {
                pq.offer(max - n);
                n = 0;
            }

        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int max = pq.poll();
            if(max > 0) {
                answer += Math.pow(max, 2);
            }
        }
        return answer;
    }
}