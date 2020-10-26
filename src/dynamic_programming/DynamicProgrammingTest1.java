package dynamic_programming;

import java.util.Scanner;

public class DynamicProgrammingTest1 {

    public static int[] list = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        // 현재의 수에서 1만큼 뺀 수의 최적 값과 현재의 수가 2, 3, 5 중 나누어 떨어지는 수의 최적값+1을 비교
        for(int i = 2; i <= x; i++){
            // 현재의 수에서 1만큼 뺀 경우 (현재수의 -1한 값의 최적값에 +1 하는 횟수를 더함)
            list[i] = list[i-1]+1;

            // 2로 나누어 떨어지는 경우
            if(i % 2 == 0){
                list[i] = Math.min(list[i], list[i/2]+1);
            }
            // 3로 나누어 떨어지는 경우
            else if (i % 3 == 0) {
                list[i] = Math.min(list[i], list[i/3]+1);
            }
            // 5로 나누어 떨어지는 경우
            else if (i % 5 == 0){
                list[i] = Math.min(list[i], list[i/5]+1);
            }
        }

        //답안출력
        System.out.print(list[x]);
    }
}
