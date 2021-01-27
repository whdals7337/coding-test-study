package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 행운의 문자열 문제 - 1342번
public class LuckyString {
    static int strLength, result;
    static int[] alphabet = new int[26];

    static boolean valid(String str) {
        for(int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    static void dfs(String str) {
        if(str.length() == strLength) {
            if(valid(str)){
                result++;
            }
            return;
        }

        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] > 0){
                str += (char)(i + 'a');
                alphabet[i]--;
                dfs(str);
                alphabet[i]++;
                str = str.substring(0, str.length()-1);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        strLength = str.length();
        for(int i = 0;  i < strLength; i++) {
            alphabet[str.charAt(i) - 'a'] += 1;
        }
        dfs("");
        System.out.println(result);
    }
}