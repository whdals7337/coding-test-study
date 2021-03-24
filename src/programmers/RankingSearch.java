package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 프로그래머스 순위 검색 문제
class RankingSearch {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String in : info) {
            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);

            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) key.append(split[j]);
                }
                map.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }

        // Map 안에 List sorting
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()){
            entry.getValue().sort(null);
        }

        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            String[] splits = query[i].replaceAll("-", "").replaceAll(" and ", "").split(" ");
            String key = splits[0];
            int score = Integer.parseInt(splits[1]);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            int start = 0;
            int end = list.size();
            // lower bound 를 구해야 함
            while (start < end) {
                int mid = (start + end) / 2;
                if(list.get(mid) < score) {
                    start = mid + 1;
                }else {
                    end = mid;
                }
            }
            // 전체에서 lower bound를 빼면 score와 같거나 큰 경우의 수
            answer[i] = list.size() - start;
        }
        return answer;
    }
}