/**
 * Created by 11981 on 2017/4/1.
 * 面试题18：树的子结构
 */
public class SubstructureInTree {
    public static void main(String args[]) {
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
        BinaryTreeNode root2=new BinaryTreeNode();
        BinaryTreeNode a=new BinaryTreeNode();
        BinaryTreeNode b=new BinaryTreeNode();
        root2.leftNode=a;
        root2.rightNode=b;
        root2.value=8;
        a.value=9;
        b.value=2;
        SubstructureInTree test=new SubstructureInTree();
        System.out.println(test.hasSubTree(root1, root2));
    }
    public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2){
        boolean result = false;
        if (root1 != null && root2 != null){
            if (root1.value == root2.value){
                result = doesTree1hasTree2(root1, root2);
            }
            if (!result)
                result = hasSubTree(root1.leftNode, root2);
            if (!result)
                result = hasSubTree(root1.rightNode, root2);
        }
        return result;
    }

    public boolean doesTree1hasTree2(BinaryTreeNode root1, BinaryTreeNode root2){
        if (root2 == null)
            return true;
        else if (root1 == null)
            return false;
        if (root1.value != root2.value){
            return false;
        }
        return doesTree1hasTree2(root1.leftNode, root2.rightNode) &&
                doesTree1hasTree2(root1.rightNode, root2.rightNode);
    }
}


