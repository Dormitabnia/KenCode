package solutions.meituan;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 已知一种新的火星文的单词由英文字母组成，但是此火星文中的字母先后顺序未知。
 * 给出一组非空的火星文单词，且此组单词已经按火星文字典序进行好了排序，请推断出此火星文中的字母先后顺序。
 * 例
 * 输入：wrt wrf er ett rftt
 * 输出：wertf
 */
public class MarsCharacterSolution {
    private static TreeSet<Character> findOrder(String words) {
        MarsCharacterComparator mcc = new MarsCharacterComparator(words);
        TreeSet<Character> res = new TreeSet<>(mcc);

        char[] chars = words.replaceAll(" ", "").toCharArray();
        for (int i = 0; i < chars.length; i++) {
            res.add(chars[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String inStr = input.nextLine();

        TreeSet<Character> characters = findOrder(inStr);

        characters.forEach(System.out::print);
    }

    private static String charToString(char[] in) {
        if (in.length == 0)
            return "";
        return in.toString();
    }
}

class MarsCharacterComparator implements Comparator<Character> {
    private String words;
    private String[] wordsArr;
    private char[] firstChars;

    public MarsCharacterComparator(String words) {
        this.words = words;
        this.wordsArr = words.split(" ");
        this.firstChars = new char[wordsArr.length];
        for (int i = 0; i < wordsArr.length; i++) {
            firstChars[i] = wordsArr[i].toCharArray()[0];
        }
    }

    @Override
    public int compare(Character o1, Character o2) {
        int res = 0;

        for (String s : wordsArr) {
            int i1 = s.indexOf(o1);
            int i2 = s.indexOf(o2);
            if (i1 != -1 && i2 != -1) {
                res = Integer.compare(i1, i2);
            }
        }

        return res;
    }
}
