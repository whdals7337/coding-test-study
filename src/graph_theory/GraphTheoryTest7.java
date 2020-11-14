package graph_theory;

import java.util.*;

//최종 순위 문제
public class GraphTheoryTest7 {
    // 테스트 케이스, 팀 개수, 순위 역전 횟수
    public static int taseCase, n, m;
    // 진입 차수 개수 리스트
    public static int[] degree = new int[501];
    // 진입 여부 리스트
    public static Boolean [][] graph = new Boolean[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        taseCase = sc.nextInt();

        for(int tc = 0; tc < taseCase; tc++){
            // 진입 차수 리스트 초기화
            Arrays.fill(degree, 0);
            // 진입 여부 리스트 초기화
            for(int i = 0; i < 501; i++){
                Arrays.fill(graph[i], false);
            }

            // 작년 팀 순위 셋팅
            n = sc.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int x =sc.nextInt();
                arrayList.add(x);
            }

            for(int i = 0; i < n; i++ ){
                for(int j= i+1; j < n; j++){
                    // 높은 등수에서 상대적으로 낮은 등수로 진입 간선 설정
                    graph[arrayList.get(i)][arrayList.get(j)] = true;
                    // 낮은 등수 팀의 진입 차수 +1
                    degree[arrayList.get(j)] += 1;
                }
            }

            // 순위가 역전된 경우
            m = sc.nextInt();
            for(int i = 0; i < m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(graph[a][b]){
                    graph[a][b] = false;
                    graph[b][a] = true;
                    degree[a] += 1;
                    degree[b] -= 1;

                }else {
                    graph[a][b] = true;
                    graph[b][a] = false;
                    degree[a] -= 1;
                    degree[b] += 1;
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();

            // 진입 차수가 0인 팀을 큐에 넣음
            for(int i = 1; i <= arrayList.size(); i++){
                if(degree[i] == 0){
                    q.offer(i);
                }
            }

            // 싸이클 여부(데이터의 일관성이 없음), 유효 여부(확실한 순위를 찾을 수 없음)
            boolean isCycle = false;
            boolean isCertain = true;

            for(int i = 0; i < n; i++){
                if(q.size() == 0){
                    isCycle = true;
                    break;
                }

                if(q.size() >= 2){
                    isCertain = false;
                    break;
                }

                int now = q.poll();
                result.add(now);

                for(int j = 1; j <= n; j++){
                    if(graph[now][j]){
                        graph[now][j] = false;
                        degree[j] -= 1;

                        if(degree[j] == 0){
                            q.offer(j);
                        }
                    }
                }
            }

            if(!isCertain) System.out.println("?");
            else if (isCycle) System.out.println("IMPOSSIBLE");
            else {
                for (int i = 0; i < result.size(); i++) {
                    System.out.print(result.get(i) + " ");
                }
                System.out.println();
            }
        }
    }
}