package baekjoon;

import java.io.*;
import java.util.*;

class FindMinNode {
    int index;
    int value;

    public FindMinNode(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

// 최솟값 찾기 문제 - 11003번
public class FindMin {

    static int N, L;
    static Deque<FindMinNode> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            // dq에 들어있는 값이 새로 넣을려는 값보다 큰경우 꺼냄
            while(!dq.isEmpty() && dq.getLast().value > value) {
                dq.removeLast();
            }

            // dq에 추가
            dq.addLast(new FindMinNode(i, value));

            // i - L보다 작거나 같다는 의미는 계산 범위를 벗어난 값이라는 의미
            if(dq.getFirst().index <= i - L) {
                dq.removeFirst();
            }
            sb.append(dq.getFirst().value).append(" ");
        }
        System.out.println(sb);
    }
}