/**
 * Created by 11981 on 2017/5/7.
 * 说明：如果某二叉树中任意结点的左右子树的深度相差不超过1，那么他就是一颗平衡二叉树
 * 面试题39：
 * 题目二：判断是否为平衡二叉树
 * 解法一：调用题目一中求二叉树深度的方法，比较左子树与右子树的差值
 * 缺点：有重复遍历结点的情况出现
 */
public class BalancedBinaryTree {
    public static void main(String[] args)
    {
        BinaryTreeNode root=new BinaryTreeNode();
        BinaryTreeNode node1=new BinaryTreeNode();
        BinaryTreeNode node2=new BinaryTreeNode();
        BinaryTreeNode node3=new BinaryTreeNode();
        BinaryTreeNode node4=new BinaryTreeNode();
        BinaryTreeNode node5=new BinaryTreeNode();
        BinaryTreeNode node6=new BinaryTreeNode();
        root.leftNode=node1;
        root.rightNode=node2;
        node1.leftNode=node3;
        node1.rightNode=node4;
        node2.rightNode=node5;
        node4.leftNode=node6;
        root.value=1;
        node1.value=2;
        node2.value=3;
        node3.value=4;
        node4.value=5;
        node5.value=6;
        node6.value=7;
        BalancedBinaryTree t = new BalancedBinaryTree();
        System.out.print(t.isBalance(root));
    }

    private boolean isBalance(BinaryTreeNode root){
        if (root == null)
            return true;
        int left = treeDepth(root.leftNode);
        int right = treeDepth(root.rightNode);
        int diff = left - right;
        if (diff > 1 || diff < -1)
            return false;
        return isBalance(root.leftNode) && isBalance(root.rightNode);
    }
    public int treeDepth(BinaryTreeNode root){
        if (root == null)
            return 0;
        int left = treeDepth(root.leftNode);
        int right = treeDepth(root.rightNode);
        return (left > right) ? left+1:right+1;
    }
}
