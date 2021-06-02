package programmers;

// 프로그래머스 이진 변환 반복하기 문제
class RepeatConvert {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            int oLen = s.length();
            s = s.replace("0", "");
            int nLen = s.length();
            answer[0] += oLen - nLen;

            s = Integer.toBinaryString(nLen);
            answer[1] += 1;
        }
        return answer;
    }
}