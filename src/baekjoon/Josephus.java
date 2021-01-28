package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//요세푸스 문제 - 1158번
public class Josephus {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        sb.append('<');

        int idx = -1;
        int size = n;
        while(!list.isEmpty()) {
            idx = (idx + k) % size;
            sb.append(list.get(idx)).append(", ");
            list.remove(idx);
            idx--;
            size--;
        }

        sb.setLength(sb.length() - 2);
        sb.append('>');
        System.out.println(sb);
    }
}