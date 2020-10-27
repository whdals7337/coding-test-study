package graph_theory;

import java.util.Scanner;

public class GraphTheoryTest1 {
    public static int[] parent = new int[100001]; // 부모테이블

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

        // 노드의 개수, 간선의 개수
        int v, e;

        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모테이블상의 부모를 자기자신으로 초기화
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        // 간선을 입력받음
        for(int i = 0; i < e; i++){
            int type = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 팀 합치기
            if(type == 0){
                unionParent(a, b);
            }

            // 같은 팀 여부 확인
            else if(type == 1) {
                if(findParent(a) == findParent(b)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
