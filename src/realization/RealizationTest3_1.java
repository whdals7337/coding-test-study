package realization;

public class RealizationTest3_1 {
    public static void main(String[] args) {
        //왕실 나이트
        int result = 0;

        //입력 받은 위치
        String position = "c2";

        //시작하는 시점 계산 ------------------------------------------
        long start = System.currentTimeMillis();

        // x,y 좌표
        int x = position.charAt(1)-'0';
        int y = position.charAt(0)-'a'+1;

        // 이동 방식에 따른 배열
        int[] dx = {-2, -2, 2, 2, -1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1, -2, 2, 2, -2};

        // 이동가능한지 반복
        for(int i = 0 ; i < 8; i++) {
            int targetX = x + dx[i];
            int targetY = y + dy[i];
            if(targetX >= 1 && targetX <= 8 && targetY >= 1 && targetY <= 8){
                result +=1;
            }
        }
        // 답안 출력
        System.out.print(result);

        //프로그램이 끝나는 시점 계산--------------------------------------
        long end = System.currentTimeMillis();

        //실행 시간 계산 및 출력
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");
    }
}

