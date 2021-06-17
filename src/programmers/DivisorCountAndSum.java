package programmers;

// 프로그래머스 약수의 개수와 덧셈 문제
class DivisorCountAndSum {
    public int solution(int left, int right) {
        int answer = 0;
        for (int num = left; num <= right; num++) {
            if (isOdd(num)) {
                answer -= num;
            }else {
                answer += num;
            }
        }
        return answer;
    }

    static boolean isOdd(int num) {
        int count = 0;
        int range = (int) Math.sqrt(num);
        for (int i = 1; i <= range; i++) {
            if(num % i == 0) {
                count += 2;

                if (i * i == num) {
                    count--;
                }
            }
        }
        return count % 2 != 0;
    }
}