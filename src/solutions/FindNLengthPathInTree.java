package solutions;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindNLengthPathInTree {
    private ArrayList<ArrayList<Integer>> res;
    private LinkedList<Integer> path;
    private int distance;
    private int target;

    public FindNLengthPathInTree() {
        res = new ArrayList<>();
        path = new LinkedList<>();
        this.distance = 0;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        this.target = target;
        if (root != null) {
            walk(root);
        }
        return res;
    }

    private void walk(TreeNode root) {
        path.addLast(root.val);
        distance += root.val;

        if (root.left == null && root.right == null) {
            if (distance == target) {
                res.add(new ArrayList<>(path));
                return;
            }
        }

        if (root.left != null) {
            walk(root.left);
            distance -= path.pollLast();
        }

        if (root.right != null) {
            walk(root.right);
            distance -= path.pollLast();
        }
    }

    public static void main(String[] args) {
        FindNLengthPathInTree s = new FindNLengthPathInTree();


    }
}
