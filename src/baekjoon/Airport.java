package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 공항 문제 - 10775번
public class Airport {

    static int G, P;
    static int result = 0;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        parents = new int[G+1];

        for(int i = 1; i <= G; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int emptyGate = find(g);
            if(emptyGate == 0) {
                break;
            }

            result+=1;
            union(emptyGate, emptyGate - 1);
        }

        System.out.println(result);
    }

    static int find(int x) {
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parents[a] = b;
        }
    }
}