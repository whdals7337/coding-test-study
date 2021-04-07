package programmers;

import java.util.Stack;

// 프로그래머스 짝지어 제거하기 문제
class CoupleRemove {
    public int solution(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if(stack.isEmpty() || stack.peek() != c) {
                stack.add(c);
            }else {
                stack.pop();
            }
        }

        int answer = 0;
        if (stack.isEmpty()) answer = 1;
        return answer;
    }
}