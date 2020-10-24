package sort;

public class SelectSort {
    public static void main(String[] args) {
        // 배열
        int [] arr = {5,4,3,2,1,6,7,8,9,0};
        int len = arr.length;

        for(int i = 0 ; i < len; i++){
            int min_index = i;
            for(int j = i+1; j < len; j++){
                // 선택된 숫자 이후 배열을 순회하면서 제일 작은 숫자 check
                if(arr[min_index] > arr[j]){
                    min_index = j;
                }
            }

            // 작은 숫자와 선택된 숫자를 서로 변경
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        
        //배열 출력
        for (int i = 0; i <len; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
