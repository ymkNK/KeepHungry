package PrintBinaryTreeFromRootToEnd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ymkNK on 2021-01-10.
 */
public class PrintBinaryTreeFromRootToEnd {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            ans.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {


    }
}
