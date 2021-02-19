package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파일 합치기 문제 - 11066번
public class FileConcat {
    static int T;

    static int calcSum(int[] sum, int start, int end ) {
        if(start == 0) return sum[end];
        else return sum[end] - sum[start-1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T --> 0){
            int k = Integer.parseInt(br.readLine());
            int[][] dp = new int[k][k];

            int[] files = new int[k];
            int[] sum = new int[k];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < k; i++) {
                files[i] = Integer.parseInt(st.nextToken());
            }

            sum[0] = files[0];
            for(int i = 1; i < k; i++) {
                sum[i] = sum[i-1] + files[i];
            }

            // 갭이 1인 경우 dp 계산
            for(int i=0; i<k-1;i++) {
                dp[i][i+1] = files[i] + files[i+1];
            }

            // 갭이 2 이상 dp 계산
            for(int gap=2; gap<k; gap++) {
                for(int i=0; i+gap<k; i++) {
                    int j=i + gap;
                    dp[i][j]=Integer.MAX_VALUE;

                    for(int s=i;s<j;s++) {
                        dp[i][j]=Math.min(dp[i][s]+dp[s+1][j], dp[i][j]);
                    }
                    dp[i][j] += calcSum(sum, i, j);
                }
            }
            System.out.println(dp[0][k-1]);
        }
    }
}