package solutions;

import java.util.Scanner;
import java.util.Stack;

/**
 * 解压缩字符串
 * 例：ABC[2|D] -> ABCDD；ABC[3|D[2|E]]F -> ABCDEEDEEDEEF
 */
public class UncompressSolution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inStr = input.nextLine();

        System.out.println(parseStr(inStr));
//        System.out.println(inStr.substring(0, inStr.indexOf('[')));
    }

    private static String parseStr(String target) {
        StringBuilder res = new StringBuilder();

        if (target.indexOf('[') != -1) {
            res.append(target.substring(0, target.indexOf('[')));
            String rem = target.substring(target.indexOf('[') + 1);
            if (rem.indexOf('|') != -1) {
                int time = Integer.parseInt(rem.split("\\|")[0]);

                String repStr = rem.substring(rem.indexOf('|') + 1, rem.lastIndexOf(']'));
                for (int i = 0; i < time; i++) {
                    res.append(parseStr(repStr));
                }

                res.append(parseStr(rem.substring(rem.lastIndexOf(']') + 1)));
            }
            else {
                res.append(parseStr(rem.substring(0, rem.lastIndexOf(']'))));
            }

        }
        else {
            res.append(target);
        }

        return res.toString();
    }
}
//A[2|B[6|CD[2|DS]F]AA]FFFF