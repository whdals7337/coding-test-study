package programmers;

import java.util.Stack;

// 프로그래머스 괄호 회전하기 문제
class Parentheses {
    public int solution(String s) {
        int answer = 0;
        StringBuilder temp = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++) {
            if(isCorrectStr(temp.toString())) {
                answer += 1;
            }
            temp.append(temp.charAt(0)).deleteCharAt(0);
        }
        return answer;
    }


    static boolean isCorrectStr(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if(now == '(' || now == '{' || now == '[') {
                stack.add(now);
            }else if(!stack.isEmpty()) {
                if(now == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else if(now == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else if(now == ']' && stack.peek() == '[') {
                    stack.pop();
                }
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}