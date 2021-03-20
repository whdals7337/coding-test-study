package programmers;

import java.util.Arrays;

// 프로그래머스 최고의 집합
class BestSet {
    public int[] solution(int n, int s) {
        if(s < n) return new int[]{-1};
        int[] answer = new int[n];
        Arrays.fill(answer, s / n);
        for(int i = 0; i < s % n; i++) {
            answer[answer.length - 1 - i]++;
        }
        return answer;
    }
}