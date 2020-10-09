package realization;

import java.util.Arrays;

public class RealizationTest4_1 {
    int diirection;

    public static void main(String[] args) {
        // 지도의 x, y 크기
        int mapX = 4, mapY = 4;

        // 현재 위치 좌표
        int currentX = 1, currentY = 1;

        // 지형 지도 (바다 : 1 지상: 0)
        int[][] map = {
                        {1,1,1,1},
                        {1,0,0,1},
                        {1,1,0,1},
                        {1,1,1,1}
                        };

        //시작하는 시점 계산 ------------------------------------------
        long start = System.currentTimeMillis();

        //방문 지도 (미방문지역 : 0, 방문지역 : 1)
        int[][] visit_map = new int[mapX][mapY];
        for (int [] row : visit_map){
            Arrays.fill(row, 0);
        }

        //현 좌표 방문 처리
        visit_map[currentX][currentY] = 1;

        // 북,동,남,서
        int[] directX = {-1,0,1,0};
        int[] directY = {0,1,0,-1};

        RealizationTest4_1 obj = new RealizationTest4_1();
        obj.diirection = 0;

        // 방문한 영역
        int count = 1;

        // 회전 횟수
        int turn_time = 0;

        while(true){
            // 왼쪽으로 돌기
            obj.turn_left();

            int targetX = currentX + directX[obj.diirection];
            int targetY = currentY + directY[obj.diirection];

            // 회전한 방향에 안가본 칸이 존재하면 이동
            if(visit_map[targetX][targetY] == 0 && map[targetX][targetY] == 0){
                visit_map[targetX][targetY] = 1;
                currentX = targetX;
                currentY = targetY;

                count += 1;
                turn_time = 0;
                continue;
            }
            else {
                // 회전한 정면에 안가본 칸이 존재하지 않거나 바다인경우 회전
                turn_time += 1;

                // 4방향 모두 회전 한 경우
                if(turn_time == 4){

                    targetX = currentX - directX[obj.diirection];
                    targetY = currentY - directY[obj.diirection];

                    //뒤로 한칸 이동 가능한 경우 이동
                    if(map[targetX][targetY] == 0){
                        currentX = targetX;
                        currentY = targetY;

                    }
                    // 뒤로 이동 불가능한경우 종료
                    else {
                        break;
                    }
                    turn_time = 0;
                }
            }
        }

        // 답안 출력
        System.out.println(count);

        //프로그램이 끝나는 시점 계산--------------------------------------
        long end = System.currentTimeMillis();

        //실행 시간 계산 및 출력
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초");
    }

    // 왼쪽으로 회전
    public void turn_left(){
        this.diirection -= 1;
        if(diirection == -1) this.diirection = 3;
    }
}
