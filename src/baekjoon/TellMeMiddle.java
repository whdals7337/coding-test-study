package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 가운데를 말해요 문제 - 1766번
public class TellMeMiddle {

    static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            // 입력 순서가 짝수인 경우 - 우선적으로 maxheap에 채움
            if(i % 2 == 0) maxHeap.add(Integer.parseInt(br.readLine()));
            // 입력순서가 홀수인 경우 - maxheap과 길이를 같게 만들기 위함
            else minHeap.offer(Integer.parseInt(br.readLine()));

            // maxheap의 최대값이 minheap의 최소값보다 크면 swap
            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(maxHeap.peek() > minHeap.peek()) {
                    int temp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(temp);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}