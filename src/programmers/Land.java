package programmers;

// 프로그래머스 땅따먹기 문제
class Land {
    int solution(int[][] land) {
        int answer = 0;
        for(int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int max = 0;
                for (int k = 0; k < land[i - 1].length; k++) {
                    if (k != j) {
                        max = Math.max(max, land[i-1][k]);
                    }
                }
                land[i][j] = land[i][j] + max;
            }
        }

        for (int i = 0; i < land[land.length - 1].length; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}