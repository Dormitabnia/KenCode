package solutions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 逆序对
 * 求解每隔2^q个进行翻转后的数组的逆序对个数
 * 如：[2 1 4 3]每隔2^1个进行翻转后为[1 2 3 4]，逆序对个数为0（即没有逆序的）
 *     [1 2 3 4]每隔2^2个进行翻转后为[4 3 2 1]，逆序对个数为6 -> (4, 3)(4, 2)(4, 1)(3, 2)(3, 1)(2, 1)
 */
public class NiXuDuiSolution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[] ints = new int[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            ints[i] = input.nextInt();
        }

        int m = input.nextInt();

        for (int i = 0; i < m; i++) {
            int q = input.nextInt();

            ints = reversePer(ints, 1 << q);
            System.out.println(findNumOfNiXu(ints));
        }

    }

    private static int[] reversePer(int[] array, int per) {
        int[] res = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length; i += per) {
            reverse(res, i, per);
        }

        return res;
    }

    private static void reverse(int[] arr, int start, int len) {
        for (int i = start; i < start + len / 2; i++) {
            swap(arr, i, start * 2 + len - i - 1);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    private static int findNumOfNiXu(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
        }

        return count;
    }
}
/**
 * 输入：数组长度2^n，初始数组，询问次数m，每2^q个进行翻转
 * 第一行为n，第二行为初始数组，第三行为m，第四行为m个询问的q
 * 示例输入：
2
2 1 4 3
4
1 2 0 2

 */