package binary_search;

import java.util.Scanner;

// 고정점 찾기 문제
public class BinarySearchTest5 {

    public static int n;

    // 중간 값이 중간 index 값과 같은지 이진 탐색 수행
    public static int search(int[] arr, int start, int end){
        if(start > end) return -1;
        int mid = (start + end) / 2;
        // 중간 값과 중간 index 가 같은 경우
        if(arr[mid] == mid) return mid;
        // 중간 값이 중간 index 보다 큰 경우 (왼쪽 확인)
        else if(arr[mid] > mid) return search(arr, start, mid - 1);
        // 중간 값이 중간 index 보다 작은 경우 (오른쪽 확인)
        else return search(arr, mid + 1, end);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // 이진 탐색 수행
        int result = search(arr, 0, arr.length);

        System.out.println(result);
    }
}
