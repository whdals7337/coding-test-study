package greedy;

import java.util.Scanner;

// 곱하기 혹은 더하기 문제
public class GreedyTest5 {
    public static void main(String[] args) {
        long result = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // 입력 받은 문자열을 char 배열로
        char[] chars = str.toCharArray();
        // 첫 번째 값 셋팅
        result = chars[0] -'0';

        // 두번째 값부터
        for(int i = 1; i< chars.length; i++){
            int number = chars[i] - '0';
            // 현재 값이 1이하 또는 다음 수 값이 1이하 인경우 더하기
            if(number <= 1 || result <= 1 ){
                result += number;
            }
            // 현재의 값과 다음 수 값이 2 이상이면 곱하기
            else {
                result *= number;
            }
        }
        // 답안 출력
        System.out.println(result);
    }
}
