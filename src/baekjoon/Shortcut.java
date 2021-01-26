package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Street implements Comparable<Street>{
    private int start;
    private int end;
    private int distance;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getDistance() {
        return distance;
    }

    public Street(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Street o) {
        return Integer.compare(this.start, o.start);
    }
}

// 지름길 문제 - 1446번
public class Shortcut {
    static int N, D;
    static ArrayList<Street> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int distance = Integer.parseInt(st2.nextToken());

            // 지름길이면서 역주행 할필요 없는 경우
            if(end - start >= distance && end <= D) {
                graph.add(new Street(start, end, distance));
            }
        }
        // 지름길 시작 지금 순으로 정렬
        Collections.sort(graph);

        // 다익스트라 알고리즘을 통해서 1씩 이동한 거리와 지름길을 통해서 간거리 중 적은 것을 dp에 세팅
        int move = 0; // 이동한 거리
                int[] dp = new int[D+1];
                Arrays.fill(dp, Integer.MAX_VALUE);
                dp[0] = 0; // 시작점의 거리값은 0
                int idx = 0; // 지름길 인덱스
                while (move < D) {
                    if(idx < graph.size() && graph.get(idx).getStart() == move) {
                        Street street = graph.get(idx);
                        dp[street.getEnd()] = Math.min(dp[move] + street.getDistance(), dp[street.getEnd()]);
                        idx++;
                    }else {
                        dp[move+1] = Math.min(dp[move] + 1, dp[move+1]);
                move++;
            }
        }
        System.out.println(dp[D]);
    }
}