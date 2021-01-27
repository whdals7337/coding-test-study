package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공유기 설치 문제 - 2110번
public class Sharer {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] houses = new int[n];
        for(int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        // 가능한 최소 거리
        int start = 1;
        // 가능한 최대 거리 (0번째 집에서 마지막 집까지의 거리)
        int end = houses[n-1] - houses[0];
        int result = 0;

        while (start <= end){
            int mid = (end + start) / 2; // 거리

            // 첫번째 집에 설치
            int value = houses[0];
            int cnt = 1;

            for(int i = 1; i < n; i++) {
                if(houses[i] >= value + mid) {
                    cnt+=1;
                    value = houses[i];
                }
            }

            // c개 이상 더 설치할수 있는 경우 -> 거리 증가
            if(cnt >= c) {
                start =  mid + 1;
                result = mid;
            }
            // c개 이상 설치 불가능한 경우 -> 거리 감소
            else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}