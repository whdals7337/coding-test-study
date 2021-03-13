package programmers;

// 프로그래머스 카펫 문제
class Carpet {
    public int[] solution(int brown, int yellow) {
        int row = 0;
        int height = 0;
        for(int i = 1; i <= yellow; i++) {
            if(yellow % i != 0) continue;
            int side = yellow / i;
            int boundary = i * 2 + side * 2 + 4;
            if(boundary == brown) {
                row = Math.max(side, i) + 2;
                height = Math.min(side, i) + 2;
                break;
            }
        }
        return new int[]{row, height};
    }
}