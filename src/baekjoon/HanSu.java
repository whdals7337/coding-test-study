package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 한수 문제 - 1065번
public class HanSu {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 100보다 작을때
        if(n < 100) {
            System.out.println(n);
        }
        // 100보다 크거나 같으면
        else {
            int v100 = n / 100;
            int idx = 0;
            for(int i = 0; i <= n % 100; i++) {
                int v10 = i / 10;
                int v1 = i % 10;

                if(v100 - v10 == v10 - v1) {
                    idx+=1;
                }
            }
            System.out.println(v100 * 5 - (5 - idx) + 99);
        }
    }
}