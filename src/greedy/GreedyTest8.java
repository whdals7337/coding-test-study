package greedy;

import java.util.Scanner;

// 볼링공 고르기 문제
public class GreedyTest8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] arr = new int[m+1];

        // 각 무게별 개수 목록 셋팅
        for(int i = 0; i<n; i++){
            int x = sc.nextInt();
            arr[x] += 1;
        }

        int result =0;
        // 1 부터 m 까지의 각 무게에 따라
        for(int i =1; i <= m; i++){
            // 전체 볼링공 개수에서 현재 무게와 동일한 볼링공의 개수만큼 빼기
            n -= arr[i];

            // 현재 무게와 동일한 볼링공의 개수와 같지 않은 볼링공의 갯수 곱 (경우의 수)
            result += arr[i] * n;
        }

        // 답안 출력
        System.out.println(result);
    }
}
