package programmers;

// 프로그래머스 징검다리 건너기 문제
class CrossBridge {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int stone : stones) {
            max = Math.max(max, stone);
            min = Math.min(min, stone);
        }

        // 돌 중 지나갈 수 있는 최소값이 최소로 지나갈 수 있는 친구의 수
        int start = min;
        // 돌 중 지나갈 수 있는 최대값이 최대로 지나갈 수 있는 친구의 수
        int end = max;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isCanCross(stones, k, mid)) {
                // 가능한 경우의 친구의 수를 저장 후
                answer = mid;
                // 친구를 늘림
                start = mid + 1;
            }else {
                end = mid -1;
            }
        }
        return answer;
    }

    private boolean isCanCross(int[] stones, int k, int friends) {
        int count = 0;
        for (int stone : stones) {
            // 해당 돌을 friends 수만큼 지나갈 수 없는 경우
            if (stone - friends < 0) {
                // 해당 돌을 뛰어 넘어야하므로 돌의 개수 + 1
                count++;
            }
            // 해당 돌을 friends 수만큼 지나 갈수 있는 경우
            else {
                // 해당 돌을 뛰어 넘지 않아도 되므로 뛰어 넘어야하는 돌의 개수를 다시 0으로 초기화
                count = 0;
            }
            // 뛰어넘어야하는 돌의 개수가 뛰어남을수 있는 돌의 개수보다 큰경우
            if (count == k) return false;
        }
        return true;
    }
}