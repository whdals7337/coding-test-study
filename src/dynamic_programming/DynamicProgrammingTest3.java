package dynamic_programming;

import java.util.Scanner;

public class DynamicProgrammingTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 가로 길이
        int n = sc.nextInt();

        // dp 테이블 초기화
        int[] d = new int[n+1];

        d[1] = 1;
        d[2] = 3;

        for(int i = 3; i <= n; i++){
            d[i] = d[i-1] + d[i-2]*2;
        }

        System.out.print(d[n]);
    }
}
