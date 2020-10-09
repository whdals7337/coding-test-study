package recursive_function;

public class RecursiveFunctionTest1 {
    public static void main(String[] args) {
        // 팩토리얼
        System.out.println(factorial(5));
    }

    public static int factorial(int i){
        if(i <= 1){
            return 1;
        }
        return i * factorial(i-1);
    }
}
