package codility.lesson3;

// 코딜리티 - FlogJump 문제
class FlogJump {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int distance = Y - X;
        int count = distance / D;
        if (distance % D != 0) {
            count += 1;
        }
        return count;
    }
}
