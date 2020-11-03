package sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 2019 SW 마에스트로 입학 테스트 - 안테나 문제
public class SortTest3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        System.out.println(list.get((n-1)/2));
    }
}
