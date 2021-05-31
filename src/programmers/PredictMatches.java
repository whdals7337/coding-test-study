package programmers;

// 프로그래머스 - 예상 대진표 문제
class PredictMatches {
    public int solution(int n, int a, int b) {
        // 두 선수의 번호가 큰 선수와 작은 선수를 구함
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        int round = 1; // 진행된 라운드

        while (true) {
            // 두 선수가 만난 경우
            // 두 선수의 번호의 차이가 1 && 번호가 작은 선수의 번호가 짝수 아닌 경우
            if (min + 1 == max && min % 2 != 0) {
                break;
            }

            // 라운드에서 이기는 경우 각 선수의 다음 번호 배정
            // 짝수인 경우 2로 나눈 값, 홀수인 경우 2로 나눈 값 + 1
            min = min % 2 == 0 ? min / 2 : min / 2 + 1;
            max = max % 2 == 0 ? max / 2 : max / 2 + 1;

            // 라운드 진행
            round++;
        }

        return round;
    }
}