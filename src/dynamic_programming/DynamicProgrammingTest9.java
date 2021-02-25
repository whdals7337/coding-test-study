package dynamic_programming;

import java.util.Scanner;

// 금광 문제
public class DynamicProgrammingTest9 {
    public static int testCase, n ,m;
    public static int[][] map = new int[20][20];
    public static int[] dx = { -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        for(int tc = 0; tc < testCase; tc++){

            n = sc.nextInt();
            m = sc.nextInt();

            // 금광 맵 초기화
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < n; i++ ){
                for(int j = 1; j < m; j++){
                    int maxValue = 0;
                    // 특정 위치 금괴량
                    int cost = map[i][j];
                    // 이전 위, 중간, 아래의 최대값 중 제일 큰 값과 타겟으로 하는 위치의 금괴량으로 맵 값 수정
                    for(int a = 0; a < 3; a++){
                        int nx = i + dx[a];
                        int ny = j - 1;

                        if(nx >= 0 && nx < n && ny >= 0 && ny < m ){
                            maxValue = Math.max(maxValue, map[nx][ny] + cost);
                        }
                    }
                    map[i][j] = maxValue;
                }
            }

            int result = 0;
            for(int i = 0; i < n; i++){
                result = Math.max(result, map[i][m-1]);
            }
            System.out.println(result);
        }
    }
}