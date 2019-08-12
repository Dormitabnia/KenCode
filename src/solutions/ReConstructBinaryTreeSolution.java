package solutions;

import pojo.TreeNode;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTreeSolution {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0 && in.length == 0)
            return null;

        TreeNode root = rebuildTree(pre, in);

        return root;
    }

    private int indexOf(int[] a, int target) {
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    private TreeNode rebuildTree(int[] pre, int[] in) {
        TreeNode res = new TreeNode(pre[0]);

        int leftSize = indexOf(in, res.val);
        int rightSize = in.length - leftSize - 1;

        // leftSize不为0说明还存在左子树
        if (leftSize > 0) {
            int[] leftPre = Arrays.copyOfRange(pre, 1, 1 + leftSize);
            int[] leftIn = Arrays.copyOfRange(in, 0, leftSize);
            // 重建左子树
            res.left = rebuildTree(leftPre, leftIn);
        }

        // rightSize不为0说明还存在右子树
        if (rightSize > 0) {
            int[] rightPre = Arrays.copyOfRange(pre, 1 + leftSize, pre.length);
            int[] rightIn = Arrays.copyOfRange(in, leftSize + 1, in.length);
            // 重建右子树
            res.right = rebuildTree(rightPre, rightIn);
        }

        return res;
    }
}
