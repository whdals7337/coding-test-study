package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기 문제 - 2042번 - 세그먼트 트리 풀이
public class RangeSum01 {

    static int N, M, K;
    static long[] arr;
    static long[] tree;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        tree = new long[N * 4];

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(0, arr.length - 1, 1);

        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                long diff = c - arr[b - 1];
                update(0, arr.length - 1 , 1, b-1, diff);
            } else if(a == 2) {
                sb.append(sum(0, arr.length - 1, 1, b-1, c-1)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    // 세그먼트 트리 초기화
    static long init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            tree[node] = init(start, mid, node * 2) + init(mid+1, end, node * 2 + 1);
            return tree[node];
        }

    }

    // 값이 변경된 영역을 포함하는 노드에 그 차이만큼 더함
    // start와 end가 같아지는 경우가 변경된 노드만 계산된 자리 이므로 초기화한다.
    static void update(int start, int end, int node, int index, long diff) {
        if(index < start || index > end) {
            return;
        }

        tree[node] += diff;
        if(start == end) {
            arr[index] = tree[node];
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid+1, end, node * 2 + 1, index, diff);
    }

    // 노드 중 구하려고하는 영역에 포함되는 경우를 더해서 값을 구함.
    // 특정범위의 계산 값인 노드가 포함되는 경우는 더하고 아니면 0 처리
    // start와 end가 같아지는 지점까지 내려가면 결국 하나의 값에 대한 노드까지 탐색하므로
    // 구하고자 하는 영역을 포함하는 노드와 아닌 영역 까지 모두 더한값을 얻을 수 있다.
    static long sum(int start, int end, int node, int left, long right) {
        if (left > end || right < start) {
            return 0;
        }

        if(left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
}