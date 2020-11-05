package binary_search;

import java.util.Scanner;

// 정렬된 배열에서 특중 수의 개수 구하기 문제
public class BinarySearchTest4 {

    public static int n, x;

    // 타겟 중 가장 index
    public static int lowIndex(int[] arr, int target, int start, int end){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 타겟보다 큰수 중 가장 작은 index
    public static int upperIndex(int[] arr, int target, int start, int end){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = upperIndex(arr, x, 0, arr.length) - lowIndex(arr, x, 0, arr.length);

        if(cnt == 0) System.out.println(-1);
        else System.out.println(cnt);
    }
}
