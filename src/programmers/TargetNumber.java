package programmers;

// 프로그래머스 타겟넘버 문제
class TargetNumber {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    static void dfs(int[] numbers, int temp, int index, int target) {
        if(index == numbers.length) {
            if(temp == target)  answer++;
            return;
        }

        dfs(numbers, temp + numbers[index], index + 1, target);
        dfs(numbers, temp - numbers[index], index + 1, target);
    }
}