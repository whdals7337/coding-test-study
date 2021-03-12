package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 프린터 문제
class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;
        Queue<Integer> q = new LinkedList<>();

        // 큐에 문서 요청 순서 셋팅
        for(int i : priorities) {
            q.offer(i);
        }

        // 문서 순서를 정렬
        Arrays.sort(priorities);

        // 가장 큰 값의 idx
        int size = priorities.length - 1;

        // 큐 순회
        while (!q.isEmpty()) {
            int now = q.poll();

            // 현재 뽑을려고하는 문서의 우선순위가 가장 큰값과 같은 경우
            if(now == priorities[size - answer]) {
                answer++;
                l--;

                // 원하는 문서가 출력된 경우
                if(l < 0) {
                    break;
                }

            }else {
                q.offer(now);
                l--;

                //운하는 문서가 가장 뒤로 보내지는 경우
                if(l < 0) {
                    l = q.size() - 1;
                }
            }
        }
        return answer;
    }
}