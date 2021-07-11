package programmers;

// 프로그래머스 숫자 문자열과 영단어 문제
public class NumberStringAndEnglish {
    public int solution(String s) {
        String[] stringNumbers = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        String[] numbers = {
                "0", "1", "2", "3", "4",
                "5", "6", "7", "8", "9"
        };

        String temp = s;
        for(int i = 0; i < stringNumbers.length; i++) {
            temp = temp.replace(stringNumbers[i], numbers[i]);
        }

        return Integer.parseInt(temp);
    }
}