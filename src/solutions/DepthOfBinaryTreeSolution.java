package solutions;

import pojo.TreeNode;

import java.util.LinkedList;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class DepthOfBinaryTreeSolution {
    //非递归方法，层次遍历
    public int TreeDepth(TreeNode root) {
        int depth = 0;
        if (root == null)
            return depth;

        LinkedList<TreeNode> queue = new LinkedList<>();

        int currentLayer = 1;
        queue.addLast(root);

        while(queue.size() > 0) {
            TreeNode p = queue.pollFirst();

            if (p.left != null) {
                queue.addLast(p.left);
            }
            if (p.right != null) {
                queue.addLast(p.right);
            }
            if (--currentLayer == 0) {
                depth++;
                currentLayer = queue.size();
            }
        }

        return depth;
    }

    // 递归方法
    public int RecursiveTreeDepth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(countLength(root.left), countLength(root.right));
    }

    private int countLength(TreeNode root) {
        if (root == null) {
            return 1;
        }
        return 1 + Math.max(countLength(root.left), countLength(root.right));
    }
}
