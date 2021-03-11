package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS 문제 - 9251번
public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] char_list_1 = br.readLine().toCharArray();
        char[] char_list_2 = br.readLine().toCharArray();
        int[][] dp = new int[char_list_1.length + 1][char_list_2.length + 1];


        for(int i = 1; i <= char_list_1.length; i++) {
            for(int j = 1; j <= char_list_2.length; j++) {

                // 문자가 같으면
                if(char_list_1[i-1] == char_list_2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // 문자가 다르면
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[char_list_1.length][char_list_2.length]);
    }
}