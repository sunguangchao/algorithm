
import java.util.Arrays;

/**
 * Created by 11981 on 2017/3/16.
 * 面试题6：重建二叉树
 */

public class ConstructBinaryTree {
    public static void main(String[] args) throws Exception{
        int [] preOrder = {1,2,4,7,3,5,6,8};
        int [] midOrder = {4,7,2,1,5,3,8,6};

        BinaryTreeNode root = constructCore(preOrder, midOrder);
    }


    public static BinaryTreeNode constructCore(int[] preOrder, int[] midOrder) throws Exception{
        if (preOrder == null || midOrder == null)
            return null;
        if (preOrder.length != midOrder.length){
            throw new Exception("长度不一致，非法输入");
        }

        BinaryTreeNode root = new BinaryTreeNode();
        for (int i=0; i < midOrder.length; i++){
            if (midOrder[i] == preOrder[0]){
                root.value = midOrder[i];
                System.out.println(root.value);
                root.leftNode = constructCore(Arrays.copyOfRange(preOrder, 1, i+1),
                        Arrays.copyOfRange(midOrder, 0, i));
                root.rightNode = constructCore(Arrays.copyOfRange(preOrder, i+1, preOrder.length),
                        Arrays.copyOfRange(midOrder, i+1, midOrder.length));
            }
        }
        return root;
    }
}
