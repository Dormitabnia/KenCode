package solutions.tencent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author wangjn
 * @date 2019/9/1
 * @description 顾客不满意度最小
 */
public class SmallestUnpresentSolution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Guest.n = n;
        ArrayList<Guest> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            Guest newGuest = new Guest(a, b, i);

            res.add(newGuest);
        }
        input.close();

        res.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                int res1 = o1.getUnprs(o1.index) + o2.getUnprs(o2.index);
                int res2 = o1.getUnprs(o2.index) + o2.getUnprs(o1.index);
                if (res1 < res2) {
                    return -1;
                }
                else if (res1 == res2)
                    return 0;
                else {
                    int tmp = o1.index;
                    o1.index = o2.index;
                    o2.index = tmp;
                    return 1;
                }
            }
        });
    }
}

class Guest {
    public static int n;

    public Guest(int bef, int aft, int index) {
        this.bef = bef;
        this.aft = aft;
        this.index = index;
    }

    public int bef;
    public int aft;
    public int index;

    public int getUnprs(int index) {
        return (bef - aft) * index + aft * n - bef;
    }
}
