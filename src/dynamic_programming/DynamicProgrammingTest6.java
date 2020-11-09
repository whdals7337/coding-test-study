package dynamic_programming;

import java.util.Scanner;

// 삼성전자 SW 역량테스트 - 퇴사 문제
public class DynamicProgrammingTest6 {
    public static int n;
    public static int[] T = new int[16];
    public static int[] P = new int[16];
    public static int[] dp = new int[17];
    static int maxValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        // i - 일 time - 해당일에 해당일 업무를 더한 값
        for(int i = n; i >= 1; i--){
            // 해당일에 해당일 업무를 더한 값
            int time = T[i] + i;

            // 해당일 + 해당일 업무 <= 마지막 날(n+1) 경우
            if(time <= n+1){
                // 이전 최대값 비교
                dp[i] = Math.max(P[i] + dp[time], maxValue);
                // 최대값 갱신
                maxValue = dp[i];
            }
            // 마지막 날보다 먼 경우
            else {
                // 이전 최대값으로 dp 테이블 값 셋팅
                dp[i] = maxValue;
            }
        }
        System.out.println(maxValue);
    }
}
