package programmers;

import java.util.Arrays;

// 프로그래머스 입국 심사 문제
class EntryCountry {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 0;
        long end = (long) times[times.length - 1] * n;
        long answer = end;
        long sum;

        while(start < end) {
            sum = 0;
            long mid = (start + end) / 2;

            // 각 심사관이 처리하는 입국자 수
            for(int time : times) {
                sum += mid / time;
            }

            // 처리 가능한 입국자 수가 더 많으므로 시간을 줄임
            if(sum >= n) {
                answer = Math.min(answer, mid);
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return answer;
    }
}