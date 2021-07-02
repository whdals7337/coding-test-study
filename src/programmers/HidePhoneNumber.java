package programmers;

// 프로그래머스 핸드폰 번호 가리기 문제
class HidePhoneNumber {
    public String solution(String phone_number) {
        StringBuffer answer = new StringBuffer();
        for(int i= 0 ; i < phone_number.length() - 4; i++) {
            answer.append("*");
        }
        answer.append(phone_number.substring(phone_number.length()-4));
        return  answer.toString();
    }
}