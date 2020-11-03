package depth_first_search;

import java.util.Scanner;

// 삼성전자 SW 역량테스트 - 연산자 끼워넣기 문제
public class DepthFirstSearchTest4 {
    // 수의 개수
    public static int n;
    // 최대값과 최소값
    public static int maxValue = (int)-1e9, minValue = (int)1e9;
    // 각 연산자의 개수
    public static int add, minus, multi, division;
    // 수 목록
    public static int[] arr = new int[11];

    // 모든 경우의 수에 따른 최대, 최소값 갱신
    public static void dfs(int depth, int now){
        if (depth == n) {
            maxValue = Math.max(maxValue, now);
            minValue = Math.min(minValue, now);

        } else if (add > 0) {
            add -= 1;
            dfs(depth + 1, now + arr[depth]);
            add += 1;
        } else if (minus > 0) {
            minus -= 1;
            dfs(depth + 1, now - arr[depth]);
            minus += 1;
        } else if (multi > 0) {
            multi -= 1;
            dfs(depth + 1, now * arr[depth]);
            multi += 1;
        } else if (division > 0) {
            division -= 1;
            dfs(depth + 1, now / arr[depth]);
            division += 1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        add = sc.nextInt();
        minus = sc.nextInt();
        multi = sc.nextInt();
        division = sc.nextInt();

        dfs(1,arr[0]);

        System.out.println(maxValue);
        System.out.println(minValue);
    }
}
