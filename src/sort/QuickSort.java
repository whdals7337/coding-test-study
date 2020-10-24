package sort;

public class QuickSort {

    public static void quickSort(int[] arr, int start_index, int end_index){
        // 시작 값이 종료 값보다 크거나 같을 경우
        if ( start_index >= end_index ) return;
        
        int pivot_index = start_index; // 피벗 값 index (분할된 배열의 맨 앞 값)
        int left_index = start_index+1;
        int right_index = end_index;
        
        while ( left_index <= right_index ){
            while ( left_index <= end_index && arr[left_index] <= arr[pivot_index]) left_index += 1;

            // 분할된 리스트에서 start_index가 pivot_index가 되므로 > 조건
            while ( right_index > start_index && arr[right_index] >= arr[pivot_index]) right_index -=1;

            // 엇갈린 경우
            if(left_index > right_index){
                int temp = arr[pivot_index];
                arr[pivot_index] = arr[right_index];
                arr[right_index] = temp;
                
            //엇갈리지 않은 경우
            } else {
                int temp = arr[left_index];
                arr[left_index] = arr[right_index];
                arr[right_index] = temp;
            }
        }

        // 분할 후 왼쪽과 오른쪽 퀵정렬 수행 (right_index위치에 pivot값이 들어 갔으므로 해당 index 기준으로 분할 )
        quickSort(arr, start_index, right_index-1);
        quickSort(arr, right_index+1, end_index);
    }

    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1,6,7,8,9,0};
        int len = arr.length;

        // 퀵정렬
        quickSort(arr,0, len-1);

        //배열 출력
        for (int i = 0; i <len; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
