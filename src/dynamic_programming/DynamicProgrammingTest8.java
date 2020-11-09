package dynamic_programming;

import java.util.Scanner;

// 못생긴 수 문제
public class DynamicProgrammingTest8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 2, 3, 5 각각의 인덱스 값 초기화
        int i2 = 0, i3 = 0, i5 = 0;

        // 2, 3, 5 각각의 다음 값 초기화
        int next2 = 2, next3 = 3, next5 = 5;

        // 구해야하는 못생긴 수 배열
        int[] list = new int[n];

        // 첫번째 값 셋팅
        list[0] = 1;
        for(int i = 1; i < n; i++){
            // 다음 값중 제일 작은 값으로 셋팅
            list[i] = Math.min(next2, Math.min(next3, next5));

            // 세팅한 값과 같은 경우 해당 인덱스 값을 증가 시키고 다음 값 셋팅 (else if를 쓸 경우 6과 같이 겹치는 경우 문제가 발생)
            if(list[i] == next2){
                i2 += 1;
                next2 = list[i2] * 2;
            }
            if(list[i] == next3){
                i3 += 1;
                next3 = list[i3] * 3;
            }
            if(list[i] == next5){
                i5 += 1;
                next5 = list[i5] * 5;
            }
        }

        //답안 출력
        System.out.println(list[n-1]);
    }
}
