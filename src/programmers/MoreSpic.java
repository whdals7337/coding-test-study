package programmers;

import java.util.*;

//프로그래머스 - 더맵게 문제
public class MoreSpic {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 우선순위 큐에 각 음식의 스코빌 지수를 넣음
        for(int scov : scoville) {
            pq.offer(scov);
        }

        while(!pq.isEmpty()) {
            // 우선순위 큐에 넣은 수중 가장 작은 값이 K 이상이면
            // 모든 음식이 K이상이 되었기 때문에 반복문을 빠져나옴
            if(pq.peek() >= K) break;

            // 우선순위 큐에 하나의 음식이 남았을 경우
            // 위조건으로 하나 남은 음식이 K 미만이므로
            // 조건을 만족하는 경우가 없음
            if(pq.size() < 2) {
                answer = -1;
                break;
            }

            int first = pq.poll(); // 가장 맵지 않은 음식의 스코빌 지수
            int second = pq.poll(); // 두 번째로 맵지 않은 음식의 스코빌 지수

            // 섞음
            int sum = first + (second * 2);  // 섞은 음식의 스코빌 지수
            // 섞은 횟수 +1
            answer += 1;
            // 섞은 음식을 우선순위 큐에 다시 넣음
            pq.offer(sum);
        }
        return answer;
    }
}
