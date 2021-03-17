package codility.lesson3;

// 코딜리티 - TapeEquilibrium 문제
class TapeEquilibrium {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int length = A.length;
        int[] frontStock = new int[length];
        int[] backStock = new int[length];

        for(int i = 1; i < length; i++) {
            frontStock[i] = frontStock[i - 1] + A[i - 1];
        }

        backStock[length - 1] = A[length - 1];
        for (int i = length - 2; i > 0; i--) {
            backStock[i] = backStock[i + 1] + A[i];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            min = Math.min(min, Math.abs(frontStock[i] - backStock[i]));
        }
        return min;
    }
}
