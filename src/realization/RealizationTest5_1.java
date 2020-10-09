package realization;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RealizationTest5_1 {
    public static void main(String[] args) {
        //문자열 재정렬
        // 입력 받은 문자열(알파벳과 0~9사이 숫자로만 이루어짐)
        String S = "K1KA5CB7";

        //시작하는 시점 계산 ------------------------------------------
        long start = System.currentTimeMillis();

        // 숫자 합계 초기화
        int sum = 0;

        char[] list = new char[S.length()];

        int j = 0;
        for(int i = 0; i< S.length(); i++){
            // 문자인 경우 리스트에 추가
            if(S.charAt(i)-'0' > 9){
                list[j] = S.charAt(i);
                j++;
            }
            // 숫자인 경우
            else {
                sum += S.charAt(i)-'0';
            }
        }
        // 문자 배열 정렬
        Arrays.sort(list);

        // 답안 출력 - 방식 1
        System.out.print(list);
        System.out.println(sum);

        // 답안 출력 - 방식 2
        String result = new String(list);
        result = result + sum;
        System.out.println(result);

        //프로그램이 끝나는 시점 계산--------------------------------------
        long end = System.currentTimeMillis();

        //실행 시간 계산 및 출력
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");

    }
}
