package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최솟값과 최대값 - 2357번
public class MaxAndMin {

    static int N, M;
    static int[] arr;
    static int[][] tree;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tree = new int[N * 4][2];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(0, arr.length - 1, 1);

        for(int i = 0; i < M; i++) {
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());

          int[] segment = segment(0, arr.length - 1, 1, a - 1, b - 1);
          sb.append(segment[0]).append(" ").append(segment[1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int[] init(int start, int end, int node) {
        // leaf 노드의 경우
        // 하나의 값만 범위로하는 노드에 도달 트리의 최소값과 최대값을 초기화
        if(start == end) {
            tree[node][0] = arr[start];
            tree[node][1] = arr[start];
            return tree[node];

        }
        // leaf 노드가 아닌 경우
        else {
            int mid = (start + end) / 2;
            // 재귀적으로 노드의 좌측과 우측 노드의 최소값과 최대값을 구함
            int[] lo = init(start, mid, node * 2);
            int[] ro = init(mid+1, end,node * 2 + 1);

            // 좌측과 우측의 노드의 최소값고 최대값으로 현 노드의 최소값과 최대값으로 초기화
            tree[node][0] = Math.min(lo[0], ro[0]);
            tree[node][1] = Math.max(lo[1], ro[1]);
            return tree[node];
        }
    }

    static int[] segment(int start, int end, int node, int left, int right) {
        // 구하고자 하는 영역에 속하지않는 경우
        if(left > end || right < start) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        // 구하고자 하는 영역에 속하는 경우
        if(left <= start && end <= right) {
            return tree[node];
        }

        // 구하고자하는 영역에 걸치나 속하지 않는 경우
        int mid = (start + end) / 2;

        // 자측과 우측의 노드의 최소값과 최대값을 구함
        int[] lo = segment(start, mid, node * 2, left, right);
        int[] ro = segment(mid+1, end,node * 2 + 1, left, right);

        // 좌측과 우측의 노드의 최소값고 최대값으로 현 노드의 최소값과 최대값으로 초기화
        return new int[]{Math.min(lo[0], ro[0]), Math.max(lo[1], ro[1])};
    }
}