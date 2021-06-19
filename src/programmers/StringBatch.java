package programmers;

import java.util.Arrays;

// 프로그래머스 문자열 내림차순으로 배치하기 문제
class StringBatch {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}