package programmers;

// 프로그래머스 점프와 순간이동 문제
public class JumpAndTel {
    public int solution(int n) {
        int ans = 0;
        while(n != 0) {
            if(n % 2 != 0) {
                n = n - 1;
                ans++;
            }
            n = n / 2;
        }
        return ans;
    }
}