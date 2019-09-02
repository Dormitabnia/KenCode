package solutions;

import java.util.LinkedList;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符，并返回它的位置，如果没有则返回 -1（需要区分大小写）
 */
public class FirstCharThatAppearOnceSolution {
    public int FirstNotRepeatingChar(String str) {
        if (str.isEmpty()) {
            return -1;
        }

        char[] chars = str.toCharArray();
        int[] times = new int['z' - 'A' + 1];

        for (int i = 0; i < chars.length; i++) {
            times[chars[i] - 'A']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (times[chars[i] - 'A'] == 1) {
                return i;
            }
        }

        return -1;
//        LinkedList<Character> onces = new LinkedList<Character>();
//        int[] location = new int['z' - 'A' + 1];
//        for (int i = 0; i < location.length; i++) {
//            location[i] = -1;
//        }
//
//        for (int i = 0; i < chars.length; i++) {
//            if (location[chars[i] - 'A'] == -1) {
//                onces.addLast(chars[i]);
//            }
//            else {
//                onces.remove((Character)chars[i]);
//            }
//            location[chars[i] - 'A'] = i;
//        }
//        return location[onces.getFirst() - 'A'];
    }

    public static void main(String[] args) {
        FirstCharThatAppearOnceSolution s = new FirstCharThatAppearOnceSolution();

        System.out.println(s.FirstNotRepeatingChar(""));
    }
}
