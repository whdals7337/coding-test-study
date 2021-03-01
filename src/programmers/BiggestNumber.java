package programmers;

import java.util.Stack;

// 프로그래머스 큰수 만들기 문제
class BiggestNumber {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);

            // stack에 있는 값들과 입력받은값을 비교후 입력받은 값보다 작은 값은 스택에서 꺼냄
           while(!stack.isEmpty() && stack.peek() < c && k >= 1) {
                stack.pop();
                k -= 1;
            }
            stack.push(c);
        }

        for(int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}