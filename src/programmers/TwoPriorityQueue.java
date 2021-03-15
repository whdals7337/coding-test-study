package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

// 프로그래머스 이증우선순위 큐
class TwoPriorityQueue {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for(String op : operations) {
            String[] ops = op.split(" ");
            String type = ops[0];
            int value = Integer.parseInt(ops[1]);

            if(type.equals("I")) {
                maxQ.offer(value);
                minQ.offer(value);
            }else {
                if(!minQ.isEmpty() && !maxQ.isEmpty()) {
                    if (value == 1) {
                        int target = maxQ.poll();
                        minQ.remove(target);
                    }else {
                        int target = minQ.poll();
                        maxQ.remove(target);
                    }
                }
            }
        }
        int max = 0;
        if(!maxQ.isEmpty()) {
            max = maxQ.poll();
        }

        int min = 0;
        if(!minQ.isEmpty()) {
            min = minQ.poll();
        }
        return new int[]{max, min};
    }
}