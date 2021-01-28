package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 소트인사이드 문제 - 1427번
public class SortInside {
    public static void main(String[] args) throws Exception {
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i) - '0');
        }
        list.sort(Collections.reverseOrder());

        for (Integer integer : list) {
            System.out.print(integer);
        }
    }
}