package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 4, 7, 10, 9, 2, 1, 6, 3};

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i - 1, 0);
        }

        Arrays.stream(arr).forEach(arg -> System.out.print(arg + " "));
    }

    public static void heapify(int[] arr, int size, int pNode) {
        int parent = pNode; // 부모 노드
        int lNode = pNode * 2 + 1; // 왼쪽 자식 노드
        int rNode = pNode * 2 + 2; // 오른쪽 자식 노드

        if(size > lNode && arr[parent] < arr[lNode]) {
            parent = lNode;
        }

        if(size > rNode && arr[parent] < arr[rNode]) {
            parent = rNode;
        }

        if (parent != pNode) {
            // 부모와 자식 swap
            swap(arr, pNode, parent);

            // 자식으로 내려온 부모를 기준으로 그 아래도 최대 힙으로 하기 위함
            heapify(arr, size, parent);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
