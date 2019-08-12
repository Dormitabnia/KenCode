import pojo.ListNode;
import pojo.TreeNode;
import solutions.HasSubTreeSolution;
import solutions.LastKNodeInLinkedListSolution;
import util.ListUtils;
import util.TreeUtils;

public class TestSolution {

    public static void main(String[] args) {
        HasSubTreeSolution s = new HasSubTreeSolution();

        // initialize
        String[] a = {"8","8","7","9","2","#","#","#","#","4","7"};
        String[] b = {"8", "9", "2"};

        TreeNode root1 = TreeUtils.createTree(a);
        TreeNode root2 = TreeUtils.createTree(b);
        System.out.println(s.hasSubtree(root1, root2));

//        Integer[] ai = {1,2,3,4,5};
//        Character[] ac = {'1', '2', '3'};
//        ListUtils.printListNode(ListUtils.toListNode(ac));

    }
}
