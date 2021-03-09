package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 단절점 문제 - 11266번
public class BreakPoint {

    static int count;
    static ArrayList<Integer> [] list;
    static int [] index;
    static boolean [] vertax;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer	st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList [N+1];
        for (int i = 1; i<=N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i<=E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        index = new int [N+1];
        vertax = new boolean [N+1];
        count = 0;
        for (int i = 1; i<=N; i++) {
            if (index[i] == 0) {
                dfs(i, true);
            }
        }

        StringBuilder sb = new StringBuilder();
        answer = 0;
        for (int i = 1; i<=N; i++) {
            if (vertax[i]) {
                answer++;
                sb.append(i+ " ");
            }
        }

        System.out.println(answer);
        System.out.println(sb.toString());
    }

    private static int dfs(int node, boolean isRoot) {
        index[node] = ++count; // 방문 순서
        int ret = index[node];
        int child = 0; // 자식의 갯수

        for (int i = 0; i<list[node].size(); i++) {
            // 자식 노드를 아직 방문하지 않은 경우
            if (index[list[node].get(i)] == 0) {
                child++; // 자식의 갯수 + 1
                int low = dfs(list[node].get(i),false); // 자식이 우회해서 갈수있는 가장빠른 노드의 방문 순서
                ret = Math.min(ret, low); // 현재 노드의 방문순서와 비교

                // root 노드가 아니고
                // 자식들의 우회해서 갈수 있는 가장 빠른 노드의 방문순서가 현재 노드의 방문 순서보다 크다면 단절점
                if (!isRoot && low >= index[node]) {
                    vertax[node] = true;
                }

            }
            // 자식 노드가 이미 방문한 경우
            else {
                ret = Math.min(ret, index[list[node].get(i)]);
            }

        }

        // root 노드이면서 자식이 2개 이상이면 단절점
        if (isRoot && child >=2) {
            vertax[node] = true;
        }

        return ret;
    }
}