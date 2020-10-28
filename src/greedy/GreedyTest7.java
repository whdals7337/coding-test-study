package greedy;

import java.util.*;

// 만들 수 없는 금액 문제
public class GreedyTest7 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }
        
        // 정렬
        Collections.sort(list);

        int target = 1;
        for(int i = 0; i < n; i++){
            // 타겟값이 정렬되 배열에서 나온 값보다 큰 경우 타겟 값을 만들지 못함 ex > target = 1, arr[0] = 2
            if(target < list.get(i)) break;

            // 작은경우 타겟값에 해당 값을 더해서 다음 타겟 값을 만듬
            target += list.get(i);
        }

        System.out.println(target);
    }
}
