import java.util.Stack;

/**
 * Created by 11981 on 2017/4/2.
 * 面试题19：二叉树的镜像
 * 先序遍历，递归
 */
public class MirrorOfBinaryTree {
    public static void main(String[] args){
        BinaryTreeNode root1=new BinaryTreeNode();
        BinaryTreeNode node1=new BinaryTreeNode();
        BinaryTreeNode node2=new BinaryTreeNode();
        BinaryTreeNode node3=new BinaryTreeNode();
        BinaryTreeNode node4=new BinaryTreeNode();
        BinaryTreeNode node5=new BinaryTreeNode();
        BinaryTreeNode node6=new BinaryTreeNode();
        root1.leftNode=node1;
        root1.rightNode=node2;
        node1.leftNode=node3;
        node1.rightNode=node4;
        node4.leftNode=node5;
        node4.rightNode=node6;
        root1.value=8;
        node1.value=8;
        node2.value=7;
        node3.value=9;
        node4.value=2;
        node5.value=4;
        node6.value=7;
        MirrorOfBinaryTree test=new MirrorOfBinaryTree();
        BinaryTreeNode rootBinaryTreeNode=test.mirrorOfBinaryTree(root1);
        System.out.println(root1.rightNode.value);
    }
//    public BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode binaryTreeNode){
//        if (binaryTreeNode == null)
//            return null;
//        if (binaryTreeNode.leftNode == null && binaryTreeNode.rightNode == null)
//            return null;
//
//        BinaryTreeNode temp = binaryTreeNode.leftNode;
//        binaryTreeNode.leftNode = binaryTreeNode.rightNode;
//        binaryTreeNode.rightNode = temp;
//
//        if (binaryTreeNode.leftNode != null){
//            mirrorOfBinaryTree(binaryTreeNode.leftNode);
//        }
//        if (binaryTreeNode.rightNode != null){
//            mirrorOfBinaryTree(binaryTreeNode.rightNode);
//        }
//        return binaryTreeNode;
//
//    }
    public BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root){
        if (root == null)
            return null;
        if (root.leftNode == null && root.rightNode == null)
            return null;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        while (root!=null || !stack.isEmpty()){
            while (root != null){
                BinaryTreeNode temp = root.leftNode;
                root.leftNode = root.rightNode;
                root.rightNode = temp;
                stack.push(root);
                root = root.leftNode;
            }
            root = stack.pop();
            root = root.rightNode;
        }
        return root;
    }
}
