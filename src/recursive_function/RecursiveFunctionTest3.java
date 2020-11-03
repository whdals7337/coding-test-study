package recursive_function;

// 2020 카카오 신입 공채 1차 - 괄호 변환
public class RecursiveFunctionTest3 {

    // 균형잡횐 괄호 문자열
    public int balancedStrIndex(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(') count += 1;
            else count  -=1 ;
            if(count == 0){
                return i;
            }
        }
        return -1;
    }

    // 올바른 괄호 문자열
    public boolean isRightStr(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(') count += 1;
            else {
                if (count == 0) {
                    return false;
                }
                count -= 1;
            }
        }
        return true;
    }

    public String solution(String p){
        String answer = "";
        if(p.equals("")) return answer;

        int index = balancedStrIndex(p);

        String u = p.substring(0, index+1);
        String v = p.substring(index+1);

        if(isRightStr(u)){
            answer = u + solution(v);

        } else {
            answer = "(";
            answer += solution(v);
            answer += ")";

            u = u.substring(1, u.length()-1);
            String temp = "";

            for(int i = 0; i < u.length(); i++){
                if (u.charAt(i) == '(') temp += ")";
                else temp += "(";
            }

            answer += temp;
        }

        return answer;
    }

    public static void main(String[] args) {

        String str = ")(";

        RecursiveFunctionTest3 obj = new RecursiveFunctionTest3();

        System.out.println(obj.solution(str));
    }
}