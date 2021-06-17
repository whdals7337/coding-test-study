package programmers;

import java.util.Arrays;

// 프로그래머스 예산 문제
class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int j : d) {
            budget -= j;

            if (budget < 0) {
                break;
            }
            answer++;
        }
        return answer;
    }
}