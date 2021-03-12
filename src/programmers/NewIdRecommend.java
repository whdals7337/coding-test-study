package programmers;

// 프로그래머스 신규 아이디 추천 문제
class NewIdRecommend {
    public String solution(String new_id) {
        String step1 = new_id.toLowerCase();

        StringBuilder step2 = new StringBuilder();
        for(char c : step1.toCharArray()) {
            if((c >= 'a' && c <= 'z') ||
                    (c >= '0' && c <= '9') ||
                    c == '-' || c == '_' || c == '.') {
                step2.append(c);
            }
        }

        String step3 = step2.toString();
        while (step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }

        String step4 = step3;
        if(step4.startsWith(".")) {
            step4 = step4.substring(1);
        }
        if(step4.endsWith(".")) {
            step4 = step4.substring(0, step4.length() - 1);
        }

        String step5 = step4.length() > 0 ? step4 : "a";

        String step6 = step5.length() >= 16 ? step5.substring(0, 15) : step5;
        if(step6.endsWith(".")) {
            step6 = step6.substring(0, step6.length() - 1);
        }

        StringBuilder step7 = new StringBuilder(step6);
        char last = step7.charAt(step7.length()-1);
        while (step7.length() < 3) {
            step7.append(last);
        }
        return step7.toString();
    }
}