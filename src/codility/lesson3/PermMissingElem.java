package codility.lesson3;

import java.util.Arrays;

// 코딜리티 - PermMissingElem 문제
class PermMissingElem {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        return getMissingElem(A);
    }

    public int getMissingElem(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
