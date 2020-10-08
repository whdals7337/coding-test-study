package greedy;

public class GreedyTest3_1 {
    public static void main(String[] args) {
        //1이 될때 까지
        // 나누어질 수, 나누는 수
        int N = 17, K = 4;
        int result = 0;

        //시작하는 시점 계산 ------------------------------------------
        long start = System.currentTimeMillis();

        // 나누어질 수가 나누는 수보다 작아질때 까지 반복
        while (N >= K){
            // 나누어 떨어지는 수가 될때 까지 -1
            while (N%K != 0) {
                N -= 1;
                result += 1;
            }

            // 나누어 떨어지는 수가 되었을때 나눔
            N=N/K;
            result+=1;
        }

        //나누어질 수가 나누는 수보다 작아졌을때 1이 될때 까지 -1
        while (N > 1){
            N-=1;
            result += 1;
        }

        //답안 출력
        System.out.println(result);

        //프로그램이 끝나는 시점 계산--------------------------------------
        long end = System.currentTimeMillis();

        //실행 시간 계산 및 출력
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");
    }
}
