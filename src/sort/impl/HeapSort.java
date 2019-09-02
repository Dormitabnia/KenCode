package sort.impl;

import sort.AbstractSort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort extends AbstractSort {
    public HeapSort(int[] input) {
        super(input);
    }

    public int[] sort() {
        return heapSort(arr, false);
    }

    public static int[] heapSort(int[] a, boolean reverse) {
        int[] cop = Arrays.copyOf(a, a.length);
        int[] res = new int[a.length];

        for (int k = 0; k < cop.length; k++) {
            heapify(cop, cop.length - k, reverse);
            res[k] = cop[0];
            swap(cop, 0, cop.length - k - 1);
        }

        return res;
    }

    /**
     * 对数组的指定长度建堆，即对<code>a[0:size - 1]</code>建堆
     * @param a 指定的数组
     * @param size 指定的长度
     * @param rev 是否从大到小排序
     */
    private static void heapify(int[] a, int size, boolean rev) {
        if (rev) {
            for (int j = size - 1; j >= 0; j--) {
                heapifyMax(a, j, size);
            }
        }
        else {
            for (int j = size - 1; j >= 0; j--) {
                heapifyMin(a, j, size);
            }
        }
    }

    /**
     * 对堆的某一个节点进行整理，使得该节点为根节点的子树成为最大堆
     * @param a 传入的数组
     * @param i 指定的节点下标
     * @param size 指定的数组长度
     */
    private static void heapifyMax(int[] a, int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        int max = i;
        if (left < size && a[left] > a[max]) {
            max = left;
        }

        if (right < size && a[right] > a[max]) {
            max = right;
        }

        if (max != i) {
            swap(a, max, i);
            heapifyMax(a, max, size);
        }
    }

    /**
     * 建最小堆
     * @param a 传入的数组
     * @param i 指定的节点下标
     * @param size 指定的数组长度
     */
    private static void heapifyMin(int[] a, int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        int min = i;
        if (left < size && a[left] < a[min]) {
            min = left;
        }

        if (right < size && a[right] < a[min]) {
            min = right;
        }

        if (min != i) {
            swap(a, min, i);
            heapifyMax(a, min, size);
        }
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
