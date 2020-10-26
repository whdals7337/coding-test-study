package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicProgrammingTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 화폐 종류 갯수
        int n = sc.nextInt();

        // 목표 금액
        int m = sc.nextInt();

        // 화폐 종류
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // dp 테이블을 나올수가 없는수로 초기화(m의 최대가 10000)
        int[] d = new int[m+1];
        Arrays.fill(d, 10001);

        // 화폐 종류 별로 dp 테이블을 순회하면 만들수 있는 수 인지와 해당 수를 만들기 위한 최소 갯수 계산
        d[0] = 0;
        for(int i = 0; i<n; i++){
            for(int j = arr[i]; j<m+1; j++){
                if(d[j-arr[i]] != 10001){
                    d[j] = Math.min(d[j], d[j-arr[i]]+1);
                }
            }
        }

        if (d[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(d[m]);
        }
    }
}
