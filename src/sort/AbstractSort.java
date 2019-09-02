package sort;

import java.util.Arrays;

public abstract class AbstractSort implements MySort {
    protected int[] arr;

    public AbstractSort(int[] input) {
        this.arr = Arrays.copyOf(input, input.length);
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] input) {
        this.arr = Arrays.copyOf(input, input.length);
    }
}