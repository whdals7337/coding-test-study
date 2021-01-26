package baekjoon;

import java.io.*;
import java.util.*;

// 음식 평론가 문제 - 1188번
public class FoodCritic {

    // 최대 공약수 (유킬리드 호제법)
    public static int GCB(int a, int b) {
        while(b > 0) {
            int temp = a;
            a = b;
            b = temp%b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 사림인원 - 최대 공약수
        System.out.println(m - GCB(n, m));
    }
}