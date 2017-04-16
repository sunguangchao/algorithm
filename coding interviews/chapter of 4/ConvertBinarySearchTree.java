/**
 * Created by 11981 on 2017/4/14.
 * 面试题27：二叉搜索树与双向链表
 * 没有测试用例
 */
public class ConvertBinarySearchTree{
    public static void main(String[] args){

    }
    public BinaryTreeNode convert(BinaryTreeNode root){
        BinaryTreeNode lastNodeInList = null;
        convertNode(root, lastNodeInList);
        BinaryTreeNode headOfList = lastNodeInList;
        //返回头结点
        while (headOfList != null && headOfList.leftNode != null)
            headOfList = headOfList.leftNode;

        return headOfList;
    }

    public void convertNode(BinaryTreeNode root, BinaryTreeNode lastNodeInList){
        if (root == null)
            return;
        BinaryTreeNode current = root;
        if (current.leftNode != null) {
            convertNode(current.leftNode,lastNodeInList);
        }
        //双向链表，所以要链接回去
        current.leftNode = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.rightNode = current;
        }
        lastNodeInList = current;//现在lastNodeInList指向了current这个节点
        if (current.rightNode != null) {
            convertNode(current.rightNode, lastNodeInList);
        }
    }

}