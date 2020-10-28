package greedy;

import java.util.*;

// 2019 카카오 신입 공채 - 무지의 먹방 라이브 문제
class GreedyTest9 {

    class Food implements Comparable<Food>{
        public int time;
        public int index;

        public Food(int time, int index){
            this.time = time;
            this.index = index;
        }

        public int compareTo(Food other){
            if(this.time < other.time){
                return -1;
            }
            return 1;
        }
    }

    public int solution(int[] food_times, long k) {

        // 음식 먹는데 걸리는 시간의 합
        long summary = 0;

        // 목록의 음식을 다먹는데 걸리는 시간이 k보다 적은 경우
        for(int i = 0; i< food_times.length; i++){
            summary += food_times[i];
        }
        // k 일때 먹을 음식이 없음
        if(summary <= k) return -1;

        // 음식을 시간이 낮은 순서대로 q에 넣음
        PriorityQueue<Food> pq = new PriorityQueue<>();

        for(int i =0; i < food_times.length; i++){
            pq.offer(new Food(food_times[i], i+1));
        }

        // 시간의 합 초기화
        summary = 0;
        // 남아있는 음식 개수
        long length = food_times.length;
        // 이전 음식을 먹는데 걸리느 시간
        long previous = 0;

        // 음식을 하나씩 꺼내가면서 해당 음식을 다먹는데 걸리는 시간을 summary 추가했을때 k보다 작으면 해당 음식을 먹었다는 처리
        // while 문을 빠져 나갔다는 것은 해당 음식을 다 먹기 전에 k초가 된다는 말
        while( summary + (pq.peek().time - previous) * length <= k){
            int now = pq.poll().time;
            summary += (now - previous) * length;
            length -= 1;
            previous = now;
        }

        // 남은 음시글 담을 목록
        ArrayList<Food> list = new ArrayList<>();

        // q에 남아있던 음식을 담음
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }

        // 남아 있는 음식들을 index 기준으로 정렬
        Collections.sort(list, new Comparator<Food>(){

            public int compare(Food o1, Food o2){
                if(o1.index < o2.index){
                    return  -1;
                }
                return 1;
            }
        });

        // 이 때 summary는 k에 도달하기전에 먹을 수 있던 음식까지 걸리는 시간을 의미한다.
        // 먹은 음식까지의 시간을 뺀 시간을 남은 음식의 개수로 나눈 나머지는 k에 먹어야하는 순서의 음식을 의미한다.
        return list.get((int)((k - summary) % length)).index;
    }
}
