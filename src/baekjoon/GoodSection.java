package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//좋은 구간 문제 - 1059번
public class GoodSection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int L = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < L; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int N = Integer.parseInt(br.readLine());

        if(!list.contains(N)) {
            list.add(N);
            Collections.sort(list);
            int NIndex = list.indexOf(N);
            //N의 위치가 맨앞일 경우 1 ~ N 까지 가능
            int front = NIndex == 0 ? N : N - list.get(NIndex - 1);
            int back = list.get(NIndex+1) - N;
            System.out.println(front * back - 1);

        } else {
            System.out.println(0);
        }
    }
}