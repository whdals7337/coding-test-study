package sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 5, 4, 2, 3, 7, 6};
        mergeSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;
        int[] temp = new int[arr.length];

        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        if (i > middle) {
            for (int t = j; t <= right; t++) {
                temp[k] = arr[t];
                k++;
            }
        }else {
            for (int t = i; t <= middle; t++) {
                temp[k] = arr[t];
                k++;
            }
        }

        for (int t = left; t <= right; t++) {
            arr[t] = temp[t];
        }
    }
}
