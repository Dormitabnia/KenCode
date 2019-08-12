package solutions;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArrayByEvenOrNotSolution {

    // 应用冒泡排序思想
    public void reOrderArray(int [] array) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (isEven(array[i]) && !isEven(array[i + 1])) {
                    swap(array, i, i + 1);
                    flag = true;
                }
            }
        }
    }

    private boolean isEven(int t) {
        return t % 2 == 0;
    }


    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
