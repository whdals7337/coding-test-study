package binary_search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearchTest2 {

    public static int binarySearch(int arr[], int target, int start, int end){
        while (start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // 재고 물품
        int n = 5;
        int[] hasItems = {8,3,7,9,2};
        
        // 주문
        int m = 3;
        int[] orderItems = {5,7,9};

        // 재고 정렬
        Arrays.sort(hasItems);
        
        // 주문 물품이 재고에 있는지 확인
        for(int i = 0; i<m; i++){
            if (binarySearch(hasItems, orderItems[i], 0, n-1) != -1) {
                System.out.println(orderItems[i]+": yes");
            } else {
                System.out.println(orderItems[i]+": no");
            }
        }
    }
}
