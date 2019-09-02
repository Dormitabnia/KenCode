package sort.impl;

import sort.AbstractSort;

import java.util.Arrays;

public class MergeSort extends AbstractSort {
    public MergeSort(int[] input) {
        super(input);
    }

    public int[] sort() {
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int[] mergeSort(int[] arr, int start, int end) {
        if (start == end)
            return Arrays.copyOfRange(arr, start, end + 1);
        int mid = (start + end) / 2;
        return merge(mergeSort(arr, start, mid), mergeSort(arr, mid + 1, end));
    }

    /**
     * 合并两个数组并排序
     * @param a1 第一个数组
     * @param a2 第二个数组
     * @return 合并后的新数组
     */
    private static int[] merge(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];

        int i = 0, j = 0, k = 0;
        while(i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j])
                res[k] = a1[i++];
            else
                res[k] = a2[j++];
            k++;
        }

        while (i < a1.length) {
            res[k++] = a1[i++];
        }

        while (j < a2.length) {
            res[k++] = a2[j++];
        }

        return res;
    }
}
