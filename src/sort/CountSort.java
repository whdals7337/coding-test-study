package sort;

public class CountSort {

    //배열에 들어갈 수 있는 값 중 최대 값
    public static final int MAX_VALUE = 9;

    public static void main(String[] args) {
        // 배열
        int[] arr = {5, 4, 3, 2, 1, 2, 6, 3, 7, 5, 8, 9, 0};
        int len = arr.length;

        // max 값까지 담을수 있는 배열 초기화
        int[] cnt = new int[MAX_VALUE+1];

        // 해당 배열값의 인덱스의 count 값 올림
        for(int i = 0; i< len; i++){
            cnt[arr[i]] +=1;
        }

        // 갯수 만큼 인덱스 출력
        for(int i = 0; i <= MAX_VALUE; i++){
            for(int j = 0; j < cnt[i]; j++){
                System.out.print(i + " ");
            }
        }
    }
}
