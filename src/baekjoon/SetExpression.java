package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집합의 표현 문제 - 1717번
public class SetExpression {

    static int n,m;
    static int[] parent;

    // 부모 찾기
    static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 집합을 합침
    static void unionParent(int x1, int x2) {
        int x1Parent = findParent(x1);
        int x2Parent = findParent(x2);
        if(x1Parent != x2Parent) {
            parent[x2Parent] = x1Parent;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 부모를 자기자신으로 셋팅
        parent = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // 연산
        for(int i =0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st2.nextToken());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            if(t == 0) unionParent(a,b);
            else {
                if (findParent(a) == findParent(b)) {
                    sb.append("YES\n");
                }else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}