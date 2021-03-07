package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 곱 구하기 문제 - 11505번
public class PartMum {

    static int N, M, K;
    static int[] arr;
    static long[] tree;
    static int d = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tree = new long[N * 4];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(0, arr.length -1, 1);

        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 변경
            if(a == 1) {
                update(0, arr.length - 1, 1, b-1, c);
            }
            // 곱하여 출력
            else {
                System.out.println((segment(0, arr.length - 1, 1, b-1, c-1)));
            }


        }
    }

    static long init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) *
                init(mid + 1, end, node * 2 + 1) % d;
    }

    static long update(int start, int end, int node, int index, int c ) {
        // index가 범위 밖인 경우 tree의 값을 수정하지 않고 바로 리턴
        if(index < start || index > end) {
            return tree[node];
        }

        // 같으면 leaf 노드 이므로 변경 입력값으 1000000이하 이고 나누는 수는 10억이기 때문에 입력받은 수 그대로 나머지가 됨
        if(start == end) {
            return tree[node] = c;
        }

        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node * 2, index, c) *
                update(mid+1, end, node * 2 + 1, index, c) % d;
    }

    static long segment(int start, int end, int node, int left, int right) {
        // 범위 밖인 경우 - 곱하기이기때문에 0 이 아닌 1을 리턴
        if(left > end || right < start) {
            return 1;
        }

        if(left <= start && right >= end ) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return  segment(start, mid, node * 2, left, right) *
                segment(mid + 1, end, node * 2 + 1, left, right) % d;
    }
}