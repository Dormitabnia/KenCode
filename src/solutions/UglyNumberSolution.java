package solutions;

/**
 * 丑数：质因子只有2、3、5的数。求第index个丑数
 */
public class UglyNumberSolution {
    public int GetUglyNumber_Solution(int index) {
        int[] fac = {0, 0, 0};
        int[] res = new int[index];
        res[0] = 1;
        for (int i = 1; i < index; i++) {
            int next = this.min(res[fac[0]] * 2, res[fac[1]] * 3, res[fac[2]] * 5);
            res[i] = next;
            if (next == res[fac[0]] * 2) {
                fac[0]++;
            }
            if (next == res[fac[1]] * 3) {
                fac[1]++;
            }
            if (next == res[fac[2]] * 5) {
                fac[2]++;
            }
        }

        return res[index - 1];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        UglyNumberSolution s = new UglyNumberSolution();

        System.out.println(s.GetUglyNumber_Solution(10));
    }
}
