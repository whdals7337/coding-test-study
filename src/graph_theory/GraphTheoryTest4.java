package graph_theory;

import java.util.Scanner;

// 탑승구 문제
public class GraphTheoryTest4 {
    public static int g, p;
    public static int[] parents = new int[1000001];

    public static int findParent(int x){
        if(parents[x] == x) return x;
        else return findParent(parents[x]);
    }

    public static void unionParent(int a, int b){
        int a_parent = findParent(a);
        int b_parent = findParent(b);
        if(a_parent > b_parent) parents[a_parent] = b_parent;
        else parents[b_parent] = a_parent;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        g = sc.nextInt();
        p = sc.nextInt();

        // 부모테이블상의 부모를 자기자신으로 초기화
        for(int i=1; i<=g; i++){
            parents[i] = i;
        }

        int result = 0;
        for(int i = 0; i< p; i++){
            int x = sc.nextInt();
            int root = parents[x];
            if(root == 0) break;
            unionParent(root, root-1);
            result += 1;
        }

        System.out.println(result);
    }
}
