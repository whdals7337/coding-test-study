package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최솟값 문제 - 10868번
public class MinValueIn {

    static int N, M;
    static int[] arr;
    static int[] tree;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[N];
        tree = new int[N * 4];
        Arrays.fill(tree, INF);
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(0, arr.length - 1, 1);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(segment(0, arr.length - 1, 1, a-1, b-1)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        tree[node] = Math.min(
                init(start, mid, node * 2),
                init(mid + 1, end, node * 2 + 1));
        return tree[node];
    }

    static int segment(int start, int end, int node, int left, int right) {
        // 구해야하는 범위에 겹치지 않는 경우
        if(right < start || left > end) {
            return INF;
        }

        // 구해야 하는 범위보다 적은 범위의 최소값을 구한 경우
        if(left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(
                segment(start, mid, node * 2, left, right),
                segment(mid + 1, end, node * 2 + 1, left, right));
    }
}