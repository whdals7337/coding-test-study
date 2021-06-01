package programmers;

// 프로그래머스 숫자의 표현 문제
class NumberExpression {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }else if (sum > n){
                    break;
                }
            }
        }
        return answer;
    }
}