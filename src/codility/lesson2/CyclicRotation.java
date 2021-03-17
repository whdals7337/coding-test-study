package codility.lesson2;

// 코딜리티 - CyclicRotation 문제
class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            result[(i + K) % A.length] = A[i];
        }
        return result;
    }
}
