package greedy;

import java.util.Scanner;

//문자열 뒤집기 문제
public class GreedyTest6 {
    public static void main(String[] args) {
        // 전부 0으로 만들기 위해서 필요한 횟수
        int count0 = 0;
        // 전부 1로 만들기 위해서 필요한 횟수
        int count1 = 0;

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        // 입력 받은 문자열의 첫번째 처리
        if (str.charAt(0) == '1') {
            count0 +=1;
        }else {
            count1 +=1;
        }
        
        for(int i = 0; i < str.length()-1; i++){
            // 문자와 다음 문자가 다른 경우
            if(str.charAt(i) != str.charAt(i+1)){
                // 해당 문자에 따라서 횟수 갱신
                if(str.charAt(i+1) == '1') count0 += 1;
                else count1 += 1;
            }
        }
        
        // 답안 출력
        System.out.println(Math.min(count0, count1));
    }
}
