package programmers;

import java.util.Arrays;

// 프로그래머스 전화번호 목록 문제
class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
            String target = phone_book[i];

            for(int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[j].startsWith(target)) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}