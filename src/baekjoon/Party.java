package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Route implements Comparable<Route> {
    int index;
    int cost;

    public Route(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    public int compareTo(Route other) {
        return Integer.compare(this.cost, other.cost);
    }
}

// 파티 문제 - 1238번
public class Party{

    static int N, M, X;
    static int result;
    static int INF = (int)1e9;
    static ArrayList<ArrayList<Route>> graph = new ArrayList<>();
    static int[] d;

    static int solution(int start, int end) {
        // 최단거리 테이블 INF로 초기화
        Arrays.fill(d, INF);

        // 우선순위 큐에 시작점 추가
        PriorityQueue<Route> pq = new PriorityQueue<>();
        pq.offer(new Route(start, 0));

        // 시작점의 최단거리 0으로 셋팅
        d[start] = 0;

        while(!pq.isEmpty()) {
            Route route = pq.poll();
            int cost = route.cost;
            int nIndex = route.index;

            // 도착지점에 도달한 경우 break
            if(nIndex == end) break;

            // 큐에서 나온 거리 값이 최단거리 테이블의 값보다 크면 이미 최단거리를 구한 값이므로 continue
            if(cost > d[nIndex]) continue;

            // 이동 가능한 지점으로 이동
            for(int i = 0; i < graph.get(nIndex).size(); i++) {
                Route target = graph.get(nIndex).get(i);
                int tCost = d[nIndex] + target.cost;

                // cost가 최던거리 테이블의 값보다 작은 경우
                if(tCost < d[target.index]) {
                    // 최단 거리 테이블을 수정
                    d[target.index] = tCost;

                    // 큐에 추가
                    pq.offer(new Route(target.index, tCost));
                }
            }
        }
        return d[end];
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        d = new int[N+1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Route(b, dis));
        }

        // 학생이 집 -> X, X->집의 소요시간의 합 중 최대값
        for(int i = 1; i <= N; i++) {
            result = Math.max(result, (solution(i, X) + solution(X, i)));
        }
        System.out.println(result);
    }
}