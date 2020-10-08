package realization;

public class RealizationTest1_1 {
    public static void main(String[] args) {
        //시뮬레이션
        // 좌표
        int x = 1, y = 1;

        // 맵의 크기 (N x N)
        int N = 5;

        // 이동 명령 목록
        String[] list = {"R","R","R","U","D","D"};

        //시작하는 시점 계산 ------------------------------------------
        long start = System.currentTimeMillis();

        // 이동 명령 목록 만큼 반복
        for(String direction : list){

            if(direction.equals("R")){
               if(y < N){
                   y+=1;
               }

            } else if(direction.equals("L")){
                if(y > 1){
                    y-=1;
                }

            } else if(direction.equals("U")){
                if(x > 1){
                    x-=1;
                }

            } else {
                if(x < N){
                    x+=1;
                }
            }

        }

        //답안 출력
        System.out.print(x+" "+y);

        //프로그램이 끝나는 시점 계산--------------------------------------
        long end = System.currentTimeMillis();

        //실행 시간 계산 및 출력
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");
    }
}
