package dynamic_programming;

import java.util.Scanner;

public class DynamicProgrammingTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 식량창고의 갯수
        int n = sc.nextInt();

        // 식량창고에 들어있는 식량 값
        int[] arr = new int[n];
        for(int i= 0; i< n; i++){
            arr[i] = sc.nextInt();
        }

        //dp 테이블 초기화
        int[] d = new int[n];

        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i<n; i++){
            d[i] = Math.max(d[i-1], d[i-2]+arr[i]);
        }

        System.out.print(d[n-1]);
    }
}
