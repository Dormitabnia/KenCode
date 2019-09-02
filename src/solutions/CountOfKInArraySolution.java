package solutions;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class CountOfKInArraySolution {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0)
            return 0;
        int index = binarySearch(array, k, 0, array.length - 1);
        if (index == -1)
            return 0;
        int count = 1;
        int i = index - 1;
        while (i >= 0 && array[i] == k) {
            count++; i--;
        }
        int j = index + 1;
        while (j <= array.length - 1 && array[j] == k) {
            count++; j++;
        }

        return count;
    }

    private int binarySearch(int[] arr, int k, int start, int end) {
        int mid = (start + end) / 2;
        if (arr[mid] == k)
            return mid;
        else if (start < mid && arr[mid] > k)
            return binarySearch(arr, k, start, mid - 1);
        else if (mid < end && arr[mid] < k)
            return binarySearch(arr, k, mid + 1, end);
        else
            return -1;
    }

    public static void main(String[] args) {
        CountOfKInArraySolution s = new CountOfKInArraySolution();

        System.out.println(s.GetNumberOfK(new int[]{0,1,2,3,4,5}, 6));
    }
}
