package programmers;

// 프로그래머스 124 나라의 숫자 문제
class Country124 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] num = {"4","1","2"};
        while(n > 0) {
            int sub = n % 3;
            sb.append(num[sub]);
            n = n / 3;
            if(sub == 0) n -= 1;
        }
        return sb.reverse().toString();
    }
}