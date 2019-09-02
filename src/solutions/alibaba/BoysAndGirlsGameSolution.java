package solutions.alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 小明和朋友们在学校里玩最幸福男生和最大团体的游戏，首先男生女生随机站成一圈，请你帮忙选出身边女生最多的男生为最幸福男生，
 * 以及按序号连续选择一批同学，最多可以选择k个女生，选出男生最多的团体并输出最多有多少个男生。
 *
 * 输入：
 * bgbbbggbg(站成一圈的同学，首尾相接，b代表男生g代表女生)
 * k(最大团队最多可选女生数量)
 * 输出：
 * 最幸福男生所在位置(序号从0开始，如果存在多个，取按序号排第一个)，最大男生团队男生人数
 *
 * 通过率 20%
 */
public class BoysAndGirlsGameSolution {
    static String getIndexAndLongest(String users, int k) {
        return findHappiestBoy(users) + " " + getLongestTeam(users, k);
    }

    private static int getLongestTeam(String users, int k) {
        String[] tmp = users.split("g");
        String[] boys;
        if (users.charAt(0) == 'g' && users.charAt(users.length() - 1) == 'g') {
            boys = new String[tmp.length + 2];
            int j = 1;
            for (int i = 0; i < tmp.length; i++) {
                boys[j] = tmp[i];
                j++;
            }
            boys[0] = ""; boys[boys.length - 1] = "";
        }
        else if (users.charAt(0) == 'g') {
            boys = new String[tmp.length + 1];
            for (int i = 0; i < tmp.length; i++) {
                boys[i + 1] = tmp[i];
            }
            boys[0] = "";
        }
        else if (users.charAt(users.length() - 1) == 'g') {
            boys = new String[tmp.length + 1];
            for (int i = 0; i < tmp.length; i++) {
                boys[i] = tmp[i];
            }
            boys[boys.length - 1] = "";
        }
        else {
            boys = Arrays.copyOf(tmp, tmp.length);
        }

        int[] numOfBoys = new int[boys.length - 1];

        for (int i = 1; i < boys.length - 1; i++) {
            numOfBoys[i - 1] = boys[i].length();
        }
        numOfBoys[numOfBoys.length - 1] = boys[0].length() + boys[boys.length - 1].length();

        Arrays.stream(numOfBoys).forEach(System.out::println);

        int longest = 0;
        for (int i = 0; i < numOfBoys.length - k; i++) {
            int sum = 0;
            for (int j = 0; j <= k; j++) {
                sum += numOfBoys[i + j];
            }
            if (sum > longest)
                longest = sum;
        }

        return longest;
    }

    private static int findHappiestBoy(String users) {
        int happiestBoy = -1;

        int[] girlsNextDoor = new int[users.length()];
        for (int i = 0; i < users.length(); i++) {
            if (i != 0 && users.charAt(i - 1) == 'g') girlsNextDoor[i]++;
            if (i != users.length() - 1 && users.charAt(i + 1) == 'g') girlsNextDoor[i]++;
        }
        if (users.charAt(0) == 'g') girlsNextDoor[users.length() - 1]++;
        if (users.charAt(users.length() - 1) == 'g') girlsNextDoor[0]++;

        for (int i = 0; i < girlsNextDoor.length; i++) {
            if (girlsNextDoor[i] == 2) {
                happiestBoy = i;
                break;
            }
        }
        if (happiestBoy == -1) {
            for (int i = 0; i < girlsNextDoor.length; i++) {
                if (girlsNextDoor[i] == 1) {
                    happiestBoy = i;
                    break;
                }
            }
        }

        return happiestBoy;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        int k;
        try {
            _users = in.nextLine();
            k = in.nextInt();
        } catch (Exception e) {
            _users = null;
            k = 0;
        }

        res = getIndexAndLongest(_users, k);
        System.out.println(res);
    }
}
