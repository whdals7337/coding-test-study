package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortTest1 {
    public static void main(String[] args) {
        int arr[] = {3, 15, 27, 12};

        // int 배열을 Integer List로
        List<Integer> numList = new ArrayList<Integer>(Arrays.stream(arr).boxed().collect(Collectors.toList()));

        // sort (오름차순)
        Collections.sort(numList);

        System.out.println("오름차순");
        //오름차순 배열 출력
        for (int i = 0; i <numList.size(); i++){
            System.out.print(numList.get(i)+" ");
        }
        System.out.println();

        // sort (내림차순)
        Collections.sort(numList, Collections.reverseOrder());

        System.out.println("내림차순");
        //내림차순 배열 출력
        for (int i = 0; i <numList.size(); i++){
            System.out.print(numList.get(i)+" ");
        }
    }
}
