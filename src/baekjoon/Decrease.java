package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//감소하는 수 문제 1038번
public class Decrease {
    public static long solution(int n) {
        int cnt = 0;
        long result = 0;

        if(n > 1022) return -1;

        if(n < 10) return n;

        Queue<Long> q = new LinkedList<>();
        for(int i = 1; i < 10; i++) {
            q.offer((long) i);
            cnt++;
        }

        while (cnt < n) {
            long k = q.poll();
            long temp = k % 10;
            for(int i = 0; i < temp; i++) {
                q.offer(k * 10 + i);
                cnt++;
                if(cnt == n) {
                    result = k * 10 + i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(solution(N));
    }
}