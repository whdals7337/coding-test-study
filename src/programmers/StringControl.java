package programmers;

// 프로그래머스 문자열 다루기 기본 문제
class StringControl {
    public boolean solution(String s) {
        int sLen = s.length();
        if (sLen == 4 || sLen == 6) {
            return s.matches("^[0-9]*");
        }
        return false;
    }
}