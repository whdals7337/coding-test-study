package programmers;

import java.util.ArrayList;
import java.util.Arrays;

// 프로그래머스 GPS 문제
public class Gps {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        final int INF = 10001;
        int[][] dp = new int[k][n+1]; // gps_log 의 노드값이 1부터 시작하기때문에 n + 1
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] value : edge_list) {
            int startNode = value[0];
            int endNode = value[1];

            // 양방향
            graph.get(startNode).add(endNode);
            graph.get(endNode).add(startNode);
        }

        for (int[] ints : dp) {
            Arrays.fill(ints, INF);
        }

        // 시작점의 dp 값을 쵸기화
        // 0초일 때 이동한 위치는 변경 횟수가 0회라는 의미
        dp[0][gps_log[0]] = 0;

        // 시작점과 오류가 나지 않기 때문에 1부터 체크
        for(int i = 1; i < k ; i++) {

            //gps_log 의 노드는 1부터 나오기 때문에 1부터 노드의 수만큼 최소 오류수정 횟수를 찾음
            for(int j = 1; j < n + 1; j++) {

                // 자기 자신으로의 이동 즉 제자리에 있는 경우의 최소 오류수정 횟수
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);

                // graph을 통해서 자신과 연결된 정점 중 어디서 온것이 가장 적은 오류수정 횟수인지 판단
                for(int node : graph.get(j)) {
                    dp[i][j] = Math.min(dp[i-1][node], dp[i][j]);
                }

                // 현재 체크한 i일때 j 위치가 로그을 보내온 요청의 위치와 같다면 최소 변경횟수를 사용
                // 만약 다르다면 i일때 j 위치에 위치하기위해서는 오류를 수정하는 것이기 때문에 +1
                dp[i][j] += gps_log[i] == j ? 0 : 1;
            }
        }

        // dp 테이블의 마지막 위치에 대한 최소값이 INF 값보다 크면 이동이 불가능
        if(dp[k - 1][gps_log[k - 1]] >= INF) {
            answer = -1;
        }else {
            answer = dp[k-1][gps_log[k -1]];
        }
        return answer;
    }
}
