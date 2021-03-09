package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 커피숍2 문제 - 1275번
public class CafeShop2 {

    static int n, q;
    static long[] arr;
    static long[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        tree = new long[n * 4];
        init(0, arr.length-1, 1);

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(x > y) {
                int temp = x;
                x = y;
                y = temp;
            }

            // x ~ y 합
            sb.append(segment(0, arr.length - 1, 1, x-1, y-1)).append("\n");

            // 업데이트
            update(0, arr.length - 1, 1, a-1,b - arr[a-1]);
        }
        System.out.println(sb);
    }

    static long init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
        return tree[node];
    }

    static long segment(int start, int end, int node, int left, int right) {
        if(right < start || left > end) {
            return 0;
        }

        if(left<= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return segment(start , mid, node * 2, left, right) + segment(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int index, long diff) {
        // 범위 밖
        if(index < start || index > end) {
            return;
        }

        // 범위 안
        tree[node] += diff;
        if (start == end) {
            arr[index] += diff;
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }
}