package programmers;

import java.util.*;

// 프로그래머스 보석 쇼핑 문제
class GemShopping {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(gems));
        Queue<String> interval = new LinkedList<>();
        int length = Integer.MAX_VALUE;
        int intervalStart = 0; // 구간 시작 지점
        int tempIntervalStart = 0; // 계산용 구간 시작 지점

        for(int i = 0; i < gems.length; i++) {
            String gemName = gems[i];

            // 구간에 늘리며 보석 추가
            hashMap.put(gemName, hashMap.getOrDefault(gemName, 0) + 1);
            interval.offer(gemName);

            while(true) {
                String temp = interval.peek(); // 구간 첫번째 보석

                // 구간 첫번째 보석이 2개 이상인 경우
                if (hashMap.get(temp) > 1) {
                    // 구간 첫번째 보석을 제거
                    hashMap.put(temp, hashMap.get(temp) - 1);
                    interval.poll();

                    // 구간시작지점을 다음 지점으로 변경
                    tempIntervalStart++;
                }else {
                    break;
                }
            }

            // 구간에 등록된 보석 종류의 수와 전체 보석 종류 수가 같으며
            // 이전에 해당 조건을 충족한 구간의 길이보다 짧은 경우
            if(hashMap.size() == hashSet.size() && length > interval.size()) {
                length = interval.size();
                intervalStart = tempIntervalStart;
            }
        }

        return new int[]{intervalStart + 1, intervalStart + length};
    }
}