package sort.impl;

import sort.AbstractSort;

public class QuickSort extends AbstractSort {
    public QuickSort(int[] input) {
        super(input);
    }

    public int[] sort() {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end) {
        int mid = getMid(arr, start, end);

        if (mid > start)
            quickSort(arr, start, mid - 1);
        if (mid < end)
            quickSort(arr, mid + 1, end);
    }

    private  static int getMid(int[] arr, int left, int right) {
        int flag = arr[left];

        while(left < right) {
            while(left < right && arr[right] >= flag)
                right--;
            arr[left] = arr[right];
            while(left < right && arr[left] <= flag)
                left++;
            arr[right] = arr[left];
        }

        arr[left] = flag;
        return left;
    }
}
