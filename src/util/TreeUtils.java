package util;
import pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树工具类
 */
public class TreeUtils {
    /**
     * 根据层次遍历重建二叉树
     * @param a 层次遍历数组（null节点以"#"表示）
     * @return 二叉树根节点
     */
    public static TreeNode createTree(String[] a) {
        TreeNode root = new TreeNode(Integer.parseInt(a[0]));
        List<TreeNode> cList = new ArrayList<>();
        cList.add(root);
        int i = 1;
        while (i < a.length) {
            List<TreeNode> tmp = new ArrayList<>();
            for (int j = 0; j < cList.size(); j++) {
                TreeNode p = cList.get(j);

                p.left = addNode(a[i++]);
                if (p.left != null)
                    tmp.add(p.left);
                p.right = addNode(a[i++]);
                if (p.right != null)
                    tmp.add(p.right);
            }
            cList = tmp;
        }

        return root;
    }

    private static TreeNode addNode(String vStr) {
        TreeNode n = null;

        if (!vStr.equals("#")) {
            int v = Integer.parseInt(vStr);
            n = new TreeNode(v);
        }

        return n;
    }

    /**
     * 递归后序遍历二叉树
     * @param root 二叉树根节点
     */
    public static void afterVisitTree(TreeNode root) {
        if (root.left != null) {
            afterVisitTree(root.left);
        }

        if (root.right != null) {
            afterVisitTree(root.right);
        }

        visit(root);
    }

    /**
     * 递归先序遍历二叉树
     * @param root 二叉树根节点
     */
    public static void firstVisitTree(TreeNode root) {
        visit(root);

        if (root.left != null) {
            firstVisitTree(root.left);
        }

        if (root.right != null) {
            firstVisitTree(root.right);
        }
    }

    /**
     * 层次遍历二叉树
     * @param root 二叉树根节点
     */
    public static void layerVisitTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(queue.size() > 0) {
            layerVisit(queue.getFirst(), queue);
            queue.removeFirst();
        }
    }

    private static void layerVisit(TreeNode n, LinkedList<TreeNode> q) {
        visit(n);
        if (n.left != null)
            q.addLast(n.left);
        if (n.right != null)
            q.addLast(n.right);
    }

    private static void visit(TreeNode n) {
        System.out.println(n.val);
    }
}
