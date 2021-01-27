package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소용돌이 예쁘게 출력하기 문제 - 1022번
public class WhirlpoolPrint {
    static int r1, r2, c1, c2, max;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static boolean isFinished() {
        return map[0][0] != 0 && map[r2-r1][0] != 0 && map[r2-r1][c2-c1] !=0 && map[0][c2-c1] != 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        map = new int[r2-r1+1][c2-c1+1];
        int x = 0, y = 0, dir = 0;
        int num = 1, dnum = 1, cnt = 0;

        while (!isFinished()){
            // 출력해야 되는 대상만 map 추가
            if(x >= r1 && x <= r2 && y >= c1 && y <= c2){
                map[x - r1][y - c1] = num;
            }
            num+=1;
            cnt+=1;

            // 다음지점
            x = x + dx[dir];
            y = y + dy[dir];

            // 방향 전환
            if(cnt == dnum){
                cnt = 0;
                // -> 또는 <-차례일때
                if(dir == 1 || dir == 3) dnum++;
                dir = (dir + 1) % 4;
            }
        }
        // map 에 들어간 가장 큰수( 자리수 공백 처리를 위해서)
        max = num - 1;

        // 가장 큰수의 자리수
        int maxLen = (int) Math.log10(max), len;

        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                // 부족한 자리수를 공백으로 처리
                len = maxLen - (int) Math.log10(map[i][j]);
                for (int k = 0; k < len; k++) {
                    System.out.print(" ");
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}