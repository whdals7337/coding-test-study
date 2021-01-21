package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 체스판 다시 색칠하기 문제
public class ChessDraw {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Boolean[][] map = new Boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) == 'B';
            }
        }

        int m = 65;
        for(int i = 0; i < N-7; i++) {
            for(int j = 0; j <M-7; j++) {
                boolean boo = true;
                int c = 0;
                for(int a = 0; a < 8; a++) {
                    for(int b = 0; b < 8; b++){
                        if(map[a+i][b+j] != boo) c++;
                        if(b != 7) boo = !boo;
                    }
                }
                if(c > 32) c = 64 - c;
                m = Math.min(m, c);
            }
        }
        System.out.println(m);
    }
}