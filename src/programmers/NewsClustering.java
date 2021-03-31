package programmers;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 뉴스 클러스터링 문제
class NewsClustering {
    static final int MUL = 65536;
    public int solution(String str1, String str2) {
        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();

        // 문자 소문자로
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            // 문자의 두글자로 키값을 셋팅
            String key = "";
            key += str1.charAt(i);
            key += str1.charAt(i + 1);

            // 해당 키값이 소문자로만 이루어진 경우 map에 셋팅
            if(key.matches("^[a-z]*$")) {
                str1Map.put(key, str1Map.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            // 문자의 두글자로 키값을 셋팅
            String key = "";
            key += str2.charAt(i);
            key += str2.charAt(i + 1);

            // 해당 키값이 소문자로만 이루어진 경우 map에 셋팅
            if(key.matches("^[a-z]*$")) {
                str2Map.put(key, str2Map.getOrDefault(key, 0) + 1);
            }
        }

        int sub = 0; // 교집합 원소 개수
        Map<String, Integer> sumMap = new HashMap<>(str2Map);
        for (String s : str1Map.keySet()) {
            if(str2Map.containsKey(s)) {
                // 교집합에 해당 값 추가
                sub += Math.min(str1Map.get(s), str2Map.get(s));

                // 합칩합 map에 큰값을 추가
                sumMap.put(s, Math.max(str1Map.get(s), str2Map.get(s)));
            }else {
                // 합칩합 map에 없는 값 추가
                sumMap.put(s, str1Map.get(s));
            }
        }

        //합집합 map을 순회하면서 합집합 원소 개수
        int sum = 0;
        for (String s : sumMap.keySet()) {
            sum += sumMap.get(s);
        }

        // 합집합의 개수가 없는 경우
        if(sum == 0) {
            return MUL;
        }
        return sub * MUL / sum;
    }
}