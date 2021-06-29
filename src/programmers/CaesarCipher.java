package programmers;

// 프로그래머스 시저 암호 문제
class CaesarCipher {

    static final int ALPHABET_LENGTH_PLUS_ONE = 26;

    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder(s.length());

        for (char c : s.toCharArray()) {
            if(c == ' ') {
                answer.append(c);
            }
            if (Character.isUpperCase(c)) {
                answer.append((char)((c -'A' + n) % ALPHABET_LENGTH_PLUS_ONE + 'A'));
            }

            if(Character.isLowerCase(c)) {
                answer.append((char)((c -'a' + n) % ALPHABET_LENGTH_PLUS_ONE + 'a'));
            }
        }
        return answer.toString();
    }
}