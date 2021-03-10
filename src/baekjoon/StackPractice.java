package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 스택 문제 - 10828번
public class StackPractice {

    static int N;
    static Stack<Integer> stack = new Stack<>();

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
                case "push":
                    x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case "pop":
                    if(!stack.isEmpty()){
                        sb.append(stack.pop()).append("\n");
                        break;
                    }
                    sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        sb.append(1).append("\n");
                        break;
                    }
                    sb.append(0).append("\n");
                    break;
                case "top":
                    if(!stack.isEmpty()) {
                        sb.append(stack.peek()).append("\n");
                        break;
                    }
                    sb.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}