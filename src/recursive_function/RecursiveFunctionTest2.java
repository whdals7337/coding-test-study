package recursive_function;

public class RecursiveFunctionTest2 {
    public static void main(String[] args) {
        // 최대 공약수 (유클리드 호제법)
        System.out.println(gcb(162, 192));
    }

    public static int gcb(int num1, int num2){
        // 두수가 같을 경우 최대 공약수는 해당 숫자 그자체
        if(num1 == num2) return num1;
        
        // 두수 중 큰수와 작은수를 구함
        int big = num1 > num2 ? num1 : num2;
        int small = num1 > num2 ? num2 : num1;

        // 큰수를 작은수로 나눴을때 나머지가 0인경우 작은수가 최대 공약수
        if(big % small == 0){
            return  small;
        } else {
           return gcb(small, big%small);
        }
    }
}
