package greedy;

public class GreedyTest3_2 {
    public static void main(String[] args) {
        //1이 될때 까지
        // 나누어질 수, 나누는 수
        int N = 17, K = 4;
        int result = 0;

        //시작하는 시점 계산 ------------------------------------------
        long start = System.currentTimeMillis();

        while(true){
            // N 보다는 작고 가장 가까운 K의 배수
            int target = (N/K) * K;

            // N이 K의 배수되기까지 필요한 COUNT 구해서 result 에 더함
            result += (N-target);

            //N을 K의 배수로 변경
            N = target;

            // N이 K보다 작은경우 반복분 탈출
            if(N < K){
                break;
            }

            // result를 1 올리며 N을 나눈수로 변경
            result += 1;
            N = N/K;
        }

        // N이 K보다 작을때 도달하는 부분으로 1이 될때 까지의 COUNT 를 result 에 추가
        result += (N-1);

        // 답안 출력
        System.out.println(result);

        //프로그램이 끝나는 시점 계산--------------------------------------
        long end = System.currentTimeMillis();

        //실행 시간 계산 및 출력
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");
    }
}
