package sort;

public class InjectionSort {
    public static void main(String[] args) {
        // 배열
        int[] arr = {5, 4, 3, 2, 1, 6, 7, 8, 9, 0};
        int len = arr.length;

        for(int i = 1; i < len; i++){
            for(int j = i; j > 0; j--){
                // 왼쪽으로 이동하면서 값이 이전 값보다 작으면 서로 변경
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                  break;
                }
            }
        }

        //배열 출력
        for (int i = 0; i <len; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
