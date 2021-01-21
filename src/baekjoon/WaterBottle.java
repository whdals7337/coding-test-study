package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//물병 문제
public class WaterBottle {
    public static int calculateMin(int n) {
        int count = 0;
        while(n > 0) {
            // 2로 나누어서 남으면 1병이 합쳐지지 않고 남음
            if( n % 2 == 1) {
                count++;
            }
            // 합쳐진 물병의 갯수
            n = n / 2;
        }
        //최대한 합친 후 물병의 갯수
        return count;
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       int N = Integer.parseInt(st.nextToken()); // 처음 물병의 갯수
       int K = Integer.parseInt(st.nextToken()); // 가져갈 수 있는 물병의 갯수
       int total = N; // 처음 물병의 갯수 + 구매한 물병의 갯수

       while(true) {
           // 최대한 합친 물병의 수가 가져갈수 있는 수보다 작거나 같으면 탈출
           if(calculateMin(total) <= K){
               break;
           }
           // 크면 물병을 구매후 다시 계산
           else{
               total++;
           }
       }

       // 조건을 충족하는 물병의 갯수 - 처음 물별의 갯수
       System.out.println(total-N);
    }
}