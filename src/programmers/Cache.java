package programmers;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 캐쉬 문제 
class Cache {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        int cityIdx = 0;
        int answer = 0;

        // 캐쉬 사이즈가 0 이면 모두 miss 처리
        if (cacheSize == 0) return cities.length * 5;

        while (true) {
            if(cityIdx == cities.length) break;

            // 대소문자 구분 x 이므로 소문자로 통일
            String now = cities[cityIdx++].toLowerCase();

            // 포함된 경우
            if(q.contains(now)) {
                // q의 맨 뒤로 보내기 위해서 제거 후 추가
                q.remove(now);
                q.offer(now);
                answer++;
            }
            else {
                // 캐쉬 사이즈가 꽉차는 경우는 하나 제거
                if(q.size() == cacheSize) q.poll();

                // 포함되지않은 경우는 무조건 miss 이므로
                q.offer(now);
                answer += 5;
            }
        }
        return answer;
    }
}