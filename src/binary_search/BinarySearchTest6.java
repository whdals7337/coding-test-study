package binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 공유기 설치 문제
public class BinarySearchTest6 {

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }

        // 이진탐색을 위한 정렬
        Collections.sort(list);

        int start = list.get(1) - list.get(0); // 공유기간 최단 거리
        int end = list.get(n-1) - list.get(0); // 공유기간 최대 거리
        int result = 0; // 최적값

        while (start <= end) {
            int mid = (start + end) / 2; // 공유기 설치하는 집간의 차이
            int value = list.get(0); // 첫번째 집에 공유기 설치
            int cnt = 1; // 설치된 공유기 개수

            for(int i = 0; i < n; i++){
                // 앞서 설치된 집과의 걸리가 gap보다 큰경우 공유기 설치
                if( list.get(i) >= value + mid){
                    value = list.get(i);
                    cnt += 1;
                }
            }

            // 공유기가 딱맞거나 덜 설치된 경우 => 거리를 늘렸을때 공유기 개수를 확인해야함
            if(cnt >= c){
                start = mid + 1;
                result = mid;
            }

            // 설치된 경우가 더 많은경우 거리를 줄임
            else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
