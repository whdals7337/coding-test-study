package programmers;

import java.util.Arrays;

// 프로그래머스 구명보트 문제
class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 정렬
        Arrays.sort(people);

        int min = 0; // 가장 작은 값의 idx 값
        for(int max = people.length - 1; min <= max; max--) {
            // 가장 큰값과 가장 작은 값의 합이 구명보트의 제한보다 작거나 같은경우 둘을 같이 처리
            if(people[min] + people[max] <= limit) {
                min++;
            }
            answer++;
        }

        return answer;
    }
}