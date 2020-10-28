package realization;

import java.util.Scanner;

// 럭키 스트레이트 문제
public class RealizationTest6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str  = sc.next();

        int sum = 0;

        // 왼쪽 문자열 숫자 합 더하기
        for(int i =0; i < str.length()/2; i++){
            sum += str.charAt(i) - '0';
        }

        // 오른쪽 문자열 숫자 합 빼기
        for(int i =str.length()/2; i < str.length(); i++){
            sum -= str.charAt(i) - '0';
        }

        // 0이면 왼쪽과 오른쪽이 같음을 의미
        if(sum == 0){
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
