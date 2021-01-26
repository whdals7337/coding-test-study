package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 도서관 문제 - 1461번
public class Library {
    static int N, M, result;
    static PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());

    // 우선순위 큐에서 들수 있는 권수 만큼 들어서 자리에 둠
    static void solution(PriorityQueue<Integer> target) {
        while(target.size() > 0) {
            // 제일 멀리있는 책 값 * 2(오고 가는 값)
            result += target.peek() * 2;

            // 한번에 들수 있는 책권수 만금 우선순위 큐에서 뺌
            for(int i = 0; i < M; i++) {
                // 우선순위 큐가 비어 있지 않은 경우
                if(target.size() > 0) {
                    target.poll();
                }
                // 우선순위 큐가 비어 있는 경우
                else {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        int maxValue = 0;
        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st2.nextToken());
            maxValue = Math.max(maxValue, Math.abs(temp));
            if(temp > 0) {
                plus.add(temp);
            }else {
                minus.add(Math.abs(temp));
            }
        }
        solution(plus);
        solution(minus);

        System.out.println(result - maxValue);
    }
}