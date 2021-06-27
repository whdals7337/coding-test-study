package programmers;

// 프로그래머스 하샤드 수 문제
class Hashard {
    public boolean solution(int x) {
        int num = 0;
        int temp = x;
        while(true) {
            if(temp < 10) {
                num += temp;
                break;
            }
            num += temp % 10;
            temp = temp / 10;
        }
        return x % num == 0;
    }
}