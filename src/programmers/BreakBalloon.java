package programmers;

// 프로그래머스 풍선 터트리기 문제
class BreakBalloon {
    public int solution(int[] a) {
        int answer = 0;
        int[] l_dp = new int[a.length];
        int[] r_dp = new int[a.length];

        l_dp[0] = Integer.MAX_VALUE;
        l_dp[1] = a[0];
        for(int i = 2; i < a.length; i++) {
            l_dp[i] = Math.min(l_dp[i-1], a[i-1]);
        }

        r_dp[a.length - 1] = Integer.MAX_VALUE;
        r_dp[a.length - 2] = a[a.length - 1];
        for(int i = a.length - 3; i >= 0; i--) {
            r_dp[i] = Math.min(r_dp[i+1], a[i+1]);
        }

        for(int i = 0; i < a.length; i++) {
            if(a[i] < l_dp[i] || a[i] < r_dp[i]) {
                answer++;
            }
        }
        return answer;
    }
}