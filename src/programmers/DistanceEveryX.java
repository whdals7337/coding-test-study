package programmers;

// 프로그래머스 x만큼 간격이 있는 n개의 숫자 문제
public class DistanceEveryX {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i = 1; i <= n; i++) {
            answer[i - 1] = x * (long)i;
        }
        return answer;
    }
}