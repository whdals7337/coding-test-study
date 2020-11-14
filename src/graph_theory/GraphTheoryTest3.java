package graph_theory;

import java.util.Scanner;

// 여행 계획 문제
public class GraphTheoryTest3 {
    // 노드의 개수, 간선의 개수
    public static int n, m;
    public static int[] parent = new int[501]; // 부모테이블

    public static int findParent(int x){
        // 루트 노드를 재귀적으로 호출하여 찾음
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        // 루트 노드 중 큰 값을 작은 값으로 초기화
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 부모테이블상의 부모를 자기자신으로 초기화
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int type = sc.nextInt();
                if(type == 1){
                    unionParent(i+1, j+1);
                }
            }
        }

        // 여행 계획
        int[] list = new int[m];
        for (int i = 0; i < m; i++) {
            list[i] = sc.nextInt();
        }

        // 여행 계획 도시 중 같은 부모가 아닌 경우 => 여행 불가
        boolean result = true;
        for (int i = 0; i < m - 1; i++) {
            if (findParent(list[i]) != findParent(list[i + 1])) {
                result = false;
            }
        }

        if(result) System.out.println("YES");
        else System.out.println("NO");
    }
}
