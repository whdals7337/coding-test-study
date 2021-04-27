package programmers;

// 프로그래머스 로또 최고 순위와 최저 순위 문제
class BestAndWorstLottoRank {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int sameCount = 0;
        boolean[] num_counts = new boolean[46];

        // 45 중 당첨 번호에 포함되는 경우 true로 설정
        for(int i = 0; i < win_nums.length; i++) {
            num_counts[win_nums[i]] = true;
        }

        // 구매한 로또 번호를 순회
        for(int i = 0; i < lottos.length; i ++) {
            // 지어진 경우
            if(lottos[i] == 0) {
                zeroCount++;
                continue;
            }

            // 로또 번호와 당첨번호와 같은 경우
            if(num_counts[lottos[i]]) {
                num_counts[lottos[i]] = false;
                sameCount++;
            }
        }

        return new int[]{getRank(zeroCount+sameCount), getRank(sameCount)};
    }

    // 맞은 갯수에 따른 순위 리턴 메서드
    static int getRank(int count) {
        if(count == 0) return 6;
        return 7 - count;
    }
}