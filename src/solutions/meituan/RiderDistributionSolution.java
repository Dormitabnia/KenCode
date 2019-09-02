package solutions.meituan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 2110年美团外卖火星第3000号配送站点有26名骑手，分别以大写字母A-Z命名，因此可以称呼这些骑手为黄家骑士特工A，黄家骑士特工B…黄家骑士特工Z，
 * 某美团黑珍珠餐厅的外卖流水线上会顺序产出一组包裹，美团配送调度引擎已经将包裹分配到骑手，并在包裹上粘贴好骑手名称，
 * 如RETTEBTAE代表一组流水线包裹共9个，同时分配给了名字为A B E R T的5名骑手。请在不打乱流水线产出顺序的情况下，
 * 把这组包裹划分为尽可能多的片段，同一个骑手只会出现在其中的一个片段，返回一个表示每个包裹片段的长度的列表。
 * 例，
 * 输入：MPMPCPMCMDEFEGDEHINHKLIN
 * 输出：9 7 8
 */
public class RiderDistributionSolution {
    private static ArrayList<Integer> distribution(char[] str) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] starts = new int[26];
        int[] ends = new int[26];

        for (int i = 0; i < 26; i++) {
            starts[i] = -1;
            ends[i] = -1;
        }

        // 找出所有字母的首先出现位置和最后出现位置。O(n)
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (starts[index(c)] == -1) {
                starts[index(c)] = i;
            }
            if (ends[index(c)] < i) {
                ends[index(c)] = i;
            }
        }

        int max = ends[index(str[0])];
        int min = starts[index(str[0])];
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (i > max) {
                res.add(max - min + 1);
                min = starts[index(c)];
                max = ends[index(c)];
            }
            max = Math.max(max, ends[index(c)]);
        }
        res.add(max - min + 1);

        return res;
    }

    private static int index(char c) {
        return c - 'A';
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inStr = input.nextLine();

        ArrayList<Integer> res = distribution(inStr.toCharArray());

        res.forEach(i -> System.out.print(i + " "));
    }
}
