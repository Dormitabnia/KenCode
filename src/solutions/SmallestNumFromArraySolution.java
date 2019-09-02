package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SmallestNumFromArraySolution {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> cop = new ArrayList<>(numbers.length);
        for (int i : numbers) {
            cop.add(i);
        }

        cop.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        for (Integer i : cop) {
            res.append(i);
        }
        return res.toString();
    }
}
