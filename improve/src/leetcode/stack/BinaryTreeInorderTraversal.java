package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 11981 on 2019/12/17.
 *
 * 非递归使用栈的解法，也是符合本题要求使用的解法,
 * 思路是从根节点开始，先将根节点压入栈，然后再将其所有左子结点压入栈，
 * 然后取出栈顶节点，保存节点值，再将当前指针移到其右子节点上，
 * 若存在右子节点，则在下次循环时又可将其所有左子结点压入栈中。
 * 这样就保证了访问顺序为左-根-右，代码如下：
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的中序遍历，使用栈
     * 顺序：左子树，根节点，右子树
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            //一直走左子树
            while (cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public static class TreeNode{
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }
}
