package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 제곱 ㄴㄴ 수 문제 - 1016번
public class SquareNumberNoNo {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int sqrt = (int) Math.sqrt(max);
        boolean[] checks = new boolean[(int)(max - min + 1)];

        for(int i = 2; i <=sqrt; i++) {
            // 제곱 ㄴㄴ는 제곱수한태 나누어 떨어지면 안되는 수
            // i * i를 통해서 i의 제곱수를 만듬
            long squareNumber = (long) i * i;

            // 0부터 시작하는게 아닌 min값부터 시작하므로
            // min 부터 squareNumber의 배수의 인덱스 값을 얻기 위해서 start를 계산
            long start = min % squareNumber == 0 ? min/squareNumber : min/squareNumber + 1;
            for(long j = start; j * squareNumber <= max; j++) {
                // squareNumber의 배수인 경우 true
                checks[(int)(j * squareNumber - min)] = true;
            }
        }

        // 제곱 ㄴㄴ의 갯수
        int count = 0;
        for(boolean chk : checks){
            if(!chk) {
                count++;
            }
        }
        System.out.println(count);
    }
}