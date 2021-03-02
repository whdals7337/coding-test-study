package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 친구 네트워크 문제 - 4195번
public class FriendsNetwork {

    static int T, F;
    static int[] parent, level;
    static Map<String, Integer> map; // 이름, 인덱스 값

    // 부모 찾기
    static int find(int x) {
        if(parent[x] == x ) return x;
        return parent[x] = find(parent[x]);
    }

    // 합치기
    static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if(aParent != bParent) {
            level[aParent] += level[bParent];
        }
        parent[bParent] = aParent;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            F = Integer.parseInt(br.readLine());

            map = new HashMap<>();
            parent = new int[200000];
            level = new int[200000];

            int idx = 0;
            for(int i = 0; i < F; i++) {
               st = new StringTokenizer(br.readLine());
               String name1 = st.nextToken();
               String name2 = st.nextToken();

                if(!map.containsKey(name1)) {
                    map.put(name1, idx);
                    parent[idx] = idx;
                    level[idx] = 1;
                    idx++;

                }

                if(!map.containsKey(name2)) {
                    map.put(name2, idx);
                    parent[idx] = idx;
                    level[idx] = 1;
                    idx++;
                }

                int n1 = map.get(name1);
                int n2 = map.get(name2);
                union(n1, n2);
                sb.append(level[find(n1)]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}