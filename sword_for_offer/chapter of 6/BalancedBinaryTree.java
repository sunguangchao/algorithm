/**
 * Created by 11981 on 2017/5/7.
 * 判断是否为平衡树
 * 有重复遍历结点的情况
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
