package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//회전하는 큐 문제 - 1021번
public class RotateQueue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            dq.add(i);
        }

        int m = Integer.parseInt(st.nextToken());
        int[] targets = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st2.nextToken());
        }

        int result = 0;
        for (int target : targets) {
            while (true) {
                // 뽑아내려는 수의 위치
                int index = 0;
                for (Integer i : dq) {
                    if (i == target) {
                        break;
                    }
                    index++;
                }

                // 뽑아내려는 수가 맨왼쪽에 있는경우 뽑아냄
                if (index == 0) {
                    dq.pollFirst();
                    break;
                }
                // 뽑아낼려는 수의 위치가 큐의 중간보다 뒤 인 경우 -> 맨 뒤의 수를 맨 앞으로
                else if (index > dq.size() / 2) {
                    dq.addFirst(dq.pollLast());
                    result++;
                }
                // 뽑아낼려는 수의 위치가 큐의 중간이거나 앞인 경우 -> 맨 앞의 수를 맨 뒤로
                else {
                    dq.addLast(dq.pollFirst());
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}