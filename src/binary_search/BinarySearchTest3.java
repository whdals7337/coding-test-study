package binary_search;

import java.util.Arrays;

public class BinarySearchTest3 {

    public static void main(String[] args) {
        int want = 6; // 원하는 떡의 길이
        int[] arr = {19,15,10,17}; // 개별 떡의 길이

        int start = 0;
        int end = (int) 1e9; // 최대값인 10억으로 설정
        int result = 0;

        while(start <= end) {
            long total = 0;
            int mid = (start+end)/2;
            for(int x : arr){
                if(x > mid){
                    total += x-mid;
                }
            }

            if(total < want){
                end = mid-1;
            } else {
                result = mid;
                start = mid+1;
            }
        }

        System.out.println(result);
    }
}
