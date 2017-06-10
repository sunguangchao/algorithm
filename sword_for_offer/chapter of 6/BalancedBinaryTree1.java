/**
 * Created by 11981 on 2017/5/7.
 * 面试题39：
 * 题目二：判断是否为平衡二叉树
 * 思路：后序遍历，递归调用，比较每一个结点是否为平衡的，并记录深度
 * 直到根节点，如果是平衡的，那么整个树就是平衡二叉树
 */
public class BalancedBinaryTree1 {
    public static void main(String[] args){
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
        BalancedBinaryTree1 t = new BalancedBinaryTree1();
        System.out.print(t.isBalanced(root));
    }
    public boolean isBalanced(BinaryTreeNode root){
        int depth = 0;
        return isBalanced(root, depth);
    }
    private boolean isBalanced(BinaryTreeNode root, int depth){
        if (root == null){
            depth = 0;
            return true;
        }
        int left = 0, right = 0;
        //后序遍历
        if (isBalanced(root.leftNode, left) && isBalanced(root.rightNode, right)){
            int diff = left - right;
            if (diff <= 1 && diff >= -1){
                depth = 1 + (left>right?left:right);
                return true;
            }
        }
        return false;
    }
}
