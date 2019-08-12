package solutions;

import pojo.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubTreeSolution {
    /**
     * 判断<code>root2</code>是否是<code>root1</code>的子结构
     * @param root1 假定的母结构
     * @param root2 假定的子结构
     * @return 判断结果
     */
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        if (isEqualTo(root1, root2)) {
            return true;
        }

        boolean flag = false;

        if (root1.left != null)
            flag = flag || hasSubtree(root1.left, root2);
        if (root1.right != null)
            flag = flag || hasSubtree(root1.right, root2);

        return flag;
    }

    /**
    判断r2是否是r1的一部分
    当r2到达叶子节点时，判断为真
    当r1到达叶子节点而r2没有到达时，判断为假
     */
    private boolean isEqualTo(TreeNode r1, TreeNode r2) {
        if (r2 == null)
            return true;
        if (r1 == null)
            return false;

        if (r1.val == r2.val) {
            return isEqualTo(r1.left, r2.left) && isEqualTo(r1.right, r2.right);
        }

        return false;
    }
}
