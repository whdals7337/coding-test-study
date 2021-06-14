package programmers;

import java.util.Arrays;

// 프로그래머스 숫자 게임 문제
class NumberGame {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int aIndex = 0;
        int bIndex = 0;
        int answer = 0;
        while (aIndex != A.length && bIndex != B.length) {
            if (A[aIndex] < B[bIndex]) {
                answer++;
                aIndex++;
            }
            bIndex++;
        }
        return answer;
    }
}