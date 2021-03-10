package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경찰차 문제 - 2618번
public class PoliceCar {

    static int N, W;
    static int[][] dp = new int[1002][1002];
    static int[][] eventPosition = new int[1002][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer	st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        for(int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());
            eventPosition[i][0] = Integer.parseInt(st.nextToken());
            eventPosition[i][1] = Integer.parseInt(st.nextToken());
        }
        sb.append(solution(1,0,0)).append("\n");

        int oneIdx = 0;
        int twoIdx = 0;
        for(int i = 1; i <= W; i++) {
            // 1번 경찰차가 i번째 사건 위치까지 가는 경우의 거리
            int oneDistance = distance(1, oneIdx, i);

            if(dp[oneIdx][twoIdx] - oneDistance == dp[i][twoIdx]) {
                oneIdx = i;
                sb.append(1).append("\n");
            }else {
                twoIdx = i;
                sb.append(2).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int solution(int eventIdx, int oneIdx, int twoIdx) {
        // 계산 하고자하는 사건의 인덱스가 사건의 수보다 커지는 경우
        if(eventIdx > W) {
            return 0;
        }

        // 이미 계산 한 경우
        if(dp[oneIdx][twoIdx] != 0) {
            return dp[oneIdx][twoIdx];
        }

        int oneMoveCount = solution(eventIdx+1, eventIdx, twoIdx) + distance(1, oneIdx, eventIdx);
        int twoMoveCount = solution(eventIdx+1, oneIdx, eventIdx) + distance(2, twoIdx, eventIdx);

        // 1번차가 움지이는 경우와 2번차가 움직이는 경우 중 작은 값을 셋팅
        return dp[oneIdx][twoIdx] = Math.min(oneMoveCount, twoMoveCount);
    }

    static int distance(int type, int startIdx, int endIdx) {
        int[] startPosition = getStartPosition(type, startIdx);

        // 시작 지점과 도착 지점의 거리
        return Math.abs(startPosition[0] - eventPosition[endIdx][0]) +
                Math.abs(startPosition[1] - eventPosition[endIdx][1]);
    }

    static int[] getStartPosition(int type, int idx) {
        // 시작이 0 인 경우
        if(idx == 0) {
            // 1번 경찰차 인 경우
            if(type == 1) {
                return new int[]{1,1};
            }
            // 2번 경찰차 인 경우
            return new int[]{N, N};
        }
        // 시작이 0이 아닌 경우
        return eventPosition[idx];
    }
}