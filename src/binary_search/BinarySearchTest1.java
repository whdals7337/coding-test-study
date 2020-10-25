package binary_search;

import java.util.Scanner;

public class BinarySearchTest1 {

    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == target){
                return mid;

            } else if(arr[mid] > target){
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        // 시작 인덱스가 끝 인덱스보다 큰 경우(target이 배열에 없음)
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        // 전체 원소 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색 수행 결과 출력
        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println("원소의 위치: "+result + 1+"번째");
        }
    }
}
