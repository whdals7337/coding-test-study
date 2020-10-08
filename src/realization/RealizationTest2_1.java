package realization;

public class RealizationTest2_1 {
    public static void main(String[] args) {
        //완전 탐색
        int H = 5;
        int result = 0;

        //시작하는 시점 계산 ------------------------------------------
        long start = System.currentTimeMillis();

        // 시, 분, 초 반복
        for(int i = 0; i <H+1; i++){
            for(int j = 0; j < 60; j++){
                for(int k = 0; k < 60; k++) {
                    // 시간, 분, 초를 문자열 변환 후 더함
                    String time = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);

                    // 해당 문자열에 3을 포함하고 있을경우
                    if(time.contains("3")){
                        result += 1;
                    }
                }
            }
        }

        //답안 출력
        System.out.print(result);

        //프로그램이 끝나는 시점 계산--------------------------------------
        long end = System.currentTimeMillis();

        //실행 시간 계산 및 출력
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");
    }
}
