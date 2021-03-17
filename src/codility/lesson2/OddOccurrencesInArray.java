package codility.lesson2;

import java.util.Arrays;

// 코딜리티 - OddOccurrencesInArray 문제
class OddOccurrencesInArray {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if(i % 2 == 0) {
                result += A[i];
            }else {
                result -= A[i];
            }
        }
        return result;
    }
}