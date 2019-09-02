package solutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串（可能存在重复字母）,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * aab -> [aab, aba, baa]
 */
public class StringPermutationSolution {
    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) {
            return new ArrayList<String>();
        }

        return doPermutation(sort(str));
    }

    ArrayList<String> doPermutation(String target) {
        ArrayList<String> res = new ArrayList<>();
        char[] tArr = target.toCharArray();
        for (int i = 0; i < target.length();) {
            int lastIndexOfI = findLast(tArr[i], tArr, i);
            StringBuilder sb = new StringBuilder(target.substring(i, lastIndexOfI + 1));
            StringBuilder remains = new StringBuilder(target.substring(0, i));
            if (i < target.length() - 1) {
                remains.append(target.substring(lastIndexOfI + 1));
            }

            sb.append(remains.toString());
            res.add(sb.toString());
            i = lastIndexOfI + 1;
        }

        return res;
    }

    String sort(String target) {
        char[] cArr = target.toCharArray();
        boolean f = true;
        int count = 0;
        while (f) {
            f = false;
            for (int i = 0; i < cArr.length - 1; i++) {
                if (cArr[i] > cArr[i + 1]) {
                    char tmp = cArr[i + 1];
                    cArr[i + 1] = cArr[i];
                    cArr[i] = tmp;
                    f = true;
                }
            }
        }

        String res = new String(cArr);

        return res;
    }

    int findLast(char target, char[] str, int start) {
        int index = start;
        for (int i = start; i < str.length; i++) {
            if (str[i] == target) {
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        StringPermutationSolution s = new StringPermutationSolution();

        String input = "ab";
        ArrayList<String> res = s.Permutation("ab");

        res.stream().forEach(System.out::println);
//        String a = "abcd";
//        System.out.println(a.g);
    }
}
