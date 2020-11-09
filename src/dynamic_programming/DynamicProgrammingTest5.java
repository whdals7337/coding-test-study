package dynamic_programming;

import java.util.Scanner;

// 정수 삼격형 문제
public class DynamicProgrammingTest5 {

    public static int n;
    public static int[][] map = new int[500][500];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        // 삼각형 값 셋팅
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i+1; j++){
                int leftup, up;

                //위 대각선 왼쪽에서 온 경우
                if(j == 0) leftup = 0;
                else leftup = map[i-1][j-1];

                // 위 대각선 오른쪽에서 온 경우
                if(j == i) up = 0;
                else up = map[i-1][j];

                // 위 대각선 왼쪽과 대각선 오른쪽 중 큰값에 따라서 설정
               map[i][j] = map[i][j] + Math.max(leftup, up);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, map[n - 1][i]);
        }
        System.out.println(result);
    }
}
