package sort;

import java.util.ArrayList;
import java.util.Collections;

class Thing implements Comparable<Thing> {
    private int stage;
    private double percent;

    public Thing(int stage, double percent){
        this.stage = stage;
        this.percent = percent;
    }

    public int getStage() {
        return stage;
    }

    public int compareTo(Thing other){
        if(this.percent == other.percent){
            return Integer.compare(this.stage, other.stage);
        }
        return Double.compare(other.percent, this.percent);
    }
}

// 2019 카카오 신입 공채 1차 - 실패율 문제
class SortTest4 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Thing> list = new ArrayList<>();
        // 해당 스테이지에 도달한 인원 수
        int length = stages.length;

        // 스테이지를 하나 씩 올려가면서
        for(int i = 1; i <= N; i++){
            int cnt = 0;
            // 해당 스테이지에 머물러있는 수 계산
            for(int j = 0; j < stages.length; j++){
                if(stages[j] == i){
                    cnt += 1;
                }
            }

            // 실패율 계산
            double fail = 0;
            if (length > 0) fail = (double) cnt / length;

            // 스테이지와 스테이지 실패율을 목록에 추가
            list.add(new Thing(i, fail));

            // stages 목록에서 계산된 수 만큼 제거
            length -= cnt;
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).getStage();
        }

        return answer;
    }
}