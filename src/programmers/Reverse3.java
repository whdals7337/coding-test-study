package programmers;

// 프로그래머스 3진법 뒤집기 문제
class Reverse3 {
    public int solution(int n) {
        return Integer.parseInt(new StringBuilder(Integer.toString(n, 3))
                .reverse()
                .toString(),3);
    }
}