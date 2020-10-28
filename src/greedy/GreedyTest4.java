package greedy;

import java.util.Arrays;
import java.util.Scanner;

// 모험가 길드 문제
public class GreedyTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 길드 인원
        int n = sc.nextInt();

        // 길드인원 공포도
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = sc.nextInt();
        }

        //공포도에 따라서 정렬
        Arrays.sort(list);

        // 특정 그룹에 속한 인원수
        int count = 0;
        // 그룹 수
        int group_count = 0;
        for(int i = 0; i < n; i++){
            // 특정 그룹에 인원 추가
            count +=1;

            // 특정 그룹의 인원이 해당 인원의 공포도와 같거나 크면 그룹결성
            if (count >= list[i]) {
                group_count +=1;
                count = 0;
            }
        }

        // 출력
        System.out.println("총 그룹 수: " + group_count);
    }
}
