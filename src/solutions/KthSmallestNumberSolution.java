package solutions;

import java.util.Arrays;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class KthSmallestNumberSolution {

    public int[] findKthSmallestNum(int k, int[] input) {
        if (input.length == 0 || k > input.length)
            return input;
        if (k == 0)
            return new int[]{};

        int[] numbers = Arrays.copyOf(input, input.length);
        quickSort(numbers, 0, numbers.length - 1, k);

        return Arrays.copyOfRange(numbers, 0, k);
    }

    private void quickSort(int[] arr, int left, int right, int k) {
        int mid = getMid(arr, left, right);

        if (mid > k) {
            quickSort(arr, left, mid - 1, k);
        }
        else if (mid + 1 < k) {
            quickSort(arr, mid + 1, right, k - mid - 1);
        }
    }

    private int getMid(int[] arr, int left, int right) {
        int flag = arr[left];

        while(left < right) {
            while(left < right && arr[right] >= flag) right--;
            arr[left] = arr[right];
            while(left < right && arr[left] <= flag) left++;
            arr[right] = arr[left];
        }

        arr[left] = flag;

        return left;
    }

    public static void main(String[] args) {
        int[] input = {1, 0, 4, 2, 2, 6};
        int k = 4;

        KthSmallestNumberSolution s = new KthSmallestNumberSolution();
        int[] output = s.findKthSmallestNum(k, input);

        Arrays.stream(output).forEach(i -> System.out.print(i + ","));
    }
}
