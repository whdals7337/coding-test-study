package programmers;

// 프로그래머스 다음 큰 숫자 문제
class NextBigNumber {
    public int solution(int n) {
        int oneCount = Integer.bitCount(n);
        while(true) {
            if(Integer.bitCount(++n) == oneCount) break;
        }
        return n;
    }
}