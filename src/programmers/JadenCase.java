package programmers;

// 프로그래머스 JadenCase 문자열 만들기 문제
class JadenCase {
    public String solution(String s) {
        char[] chars = s.toCharArray();

        boolean isPreBlank  = true;
        StringBuilder answer = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                answer.append(' ');
                isPreBlank =true;
            }else {
                if (isPreBlank) {
                    isPreBlank = false;
                    answer.append(String.valueOf(aChar).toUpperCase());
                }else {
                    answer.append(String.valueOf(aChar).toLowerCase());
                }
            }
        }
        return answer.toString();
    }
}