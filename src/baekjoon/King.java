package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//킹 문제 - 1063번
public class King {

    static int N, kx, ky, rx, ry;
    static String[] row = {"A","B","C","D","E","F","G","H"};
    static int[] col = {8, 7, 6, 5, 4 ,3 ,2 ,1};

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        //이동 방향 설정
        Map<String, int[]> move = new HashMap();
        move.put("R", new int[]{0, 1});
        move.put("L", new int[]{0, -1});
        move.put("B", new int[]{1, 0});
        move.put("T", new int[]{-1, 0});
        move.put("RT", new int[]{-1, 1});
        move.put("LT", new int[]{-1, -1});
        move.put("RB", new int[]{1, 1});
        move.put("LB", new int[]{1, -1});

        // 킹의 처음 위치 ex) A1 - > kx = 7, ky = 0
        String kingPosition = st.nextToken();
        kx = 8 - (kingPosition.charAt(1) - '0');
        ky = kingPosition.charAt(0) - 'A';
        // 돌의 처음 위치
        String rockPosition = st.nextToken();
        rx = 8 - (rockPosition.charAt(1) - '0');
        ry = rockPosition.charAt(0) - 'A';

        N  = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            String key = br.readLine();
            int[] direction = move.get(key);

            // 킹이 이동할 위치
            int kdx = kx + direction[0];
            int kdy = ky + direction[1];

            // 킹이 이도할 위치가 체스 범위인 경우
            if(isRange(kdx, kdy)) {
                // 킹이 이동할 위치에 돌이 있는 경우
                if(kdx == rx && kdy == ry) {
                    // 돌이 이동할 위치
                    int rdx = rx + direction[0];
                    int rdy = ry + direction[1];

                    // 돌이 이동할 위치가 체스 범위 안인 경우
                    if(isRange(rdx, rdy)) {
                        // 킹 이동
                        kx = kdx; ky = kdy;

                        // 돌 이동
                        rx = rdx; ry = rdy;
                    }
                }
                // 킹이 이동할 위치에 돌이 없는 경우
                else {
                    // 킹만 이동
                    kx = kdx; ky = kdy;
                }
            }
        }
        System.out.println(row[ky] + col[kx]);
        System.out.println(row[ry] + col[rx]);
    }
}