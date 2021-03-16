package programmers;

// 프로그래머스 멀쩡한 사각형 문제
public class OrdinalRec {
    public long solution(int w, int h) {
        int gcdValue = getGCD(w, h);
        return ((long) w * (long) h) - ((((long) w / gcdValue) + ((long) h / gcdValue) - 1) * gcdValue);
    }

    static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }
}