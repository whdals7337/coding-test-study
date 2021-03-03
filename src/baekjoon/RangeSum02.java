package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기 문제 - 2042번 - 바이너리 인덱스 트리 풀이
public class RangeSum02 {

    static int N, M, K;
    static long[] arr;
    static long[] tree;

    static void update(int i, long diff) {
        while (i <= N) {
            tree[i] +=diff;
            i += (i & -i);
        }
    }

    static long interval_sum(int start, int end) {
        return prefix_sum(end) - prefix_sum(start - 1);
    }

    static long prefix_sum(int i) {
        long result = 0;
        while (i > 0) {
            result += tree[i];
            i -= (i & -i);
        }
        return result;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[N + 1];

        for(int i = 1; i <= N; i++) {
            long x = Long.parseLong(br.readLine());
            arr[i] = x;
            update(i, x);
        }

        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                update(b, c - arr[b]);
                arr[b] = c;
            } else if(a == 2) {
                sb.append(interval_sum(b, (int) c)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}