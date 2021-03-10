package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 덱 문제 - 10866번
public class DequePractice {

    static int N;
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i= 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int x;
            switch (order) {
                case "push_front":
                    x = Integer.parseInt(st.nextToken());
                    deque.addFirst(x);
                    break;
                case "push_back":
                    x = Integer.parseInt(st.nextToken());
                    deque.addLast(x);
                    break;
                case "pop_front":
                    if(!deque.isEmpty()) {
                        sb.append(deque.pollFirst()).append("\n");
                        break;
                    }
                    sb.append(-1).append("\n");
                    break;
                case "pop_back":
                    if(!deque.isEmpty()) {
                        sb.append(deque.pollLast()).append("\n");
                        break;
                    }
                    sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(!deque.isEmpty()) {
                        sb.append(0).append("\n");
                        break;
                    }
                    sb.append(1).append("\n");
                    break;
                case "front":
                    if(!deque.isEmpty()) {
                        sb.append(deque.peekFirst()).append("\n");
                        break;
                    }
                    sb.append(-1).append("\n");
                    break;
                case "back":
                    if(!deque.isEmpty()) {
                        sb.append(deque.peekLast()).append("\n");
                        break;
                    }
                    sb.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}