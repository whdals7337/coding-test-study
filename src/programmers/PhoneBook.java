package programmers;

import java.util.Arrays;

// 프로그래머스 전화번호 목록 문제
class Solution {
    static public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        for(int i=0; i<phoneBook.length-1;i++){
            if(phoneBook[i+1].startsWith(phoneBook[i])) {
                return false;
            }
        }
        return true;
    }
}