import java.util.Arrays;

/**
 * Created by 11981 on 2017/4/9.
 * 面试题24：二叉搜素树的后序遍历序列
 * 思路：前面的两个循环中，第一个用来把i指向右子树的开始
 * 第二个循环用来检验右子树是不是大于根节点，符合二叉搜索树的特性
 */
public class SquenceOfBST {
    public static void main(String[] args){
        SquenceOfBST squenceOfBST = new SquenceOfBST();
        int[] array = {5,7,6,9,11,10,8};
        int[] array2 = {7,4,6,5};
        System.out.println(squenceOfBST.VerifySquenceOfBST(array2));
    }

    public boolean VerifySquenceOfBST(int sequence[]){
        if (sequence == null || sequence.length == 0)
            return false;
        int length = sequence.length;
        int root = sequence[length-1];
        //在二叉搜索树中左子树的结点小于根节点
        int i=0;
        for (; i < length-1; i++)
        {
            if (sequence[i] > root)
                break;
        }
        //在二叉搜索树中右子树的结点大于根节点
        int j=i;
        for (; j < length-1; j++){
            if (sequence[j] < root)
                return false;
        }
        //判断左子树是不是二叉搜索树
        boolean left = true;
        if (i > 0)
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        boolean right = true;
        //判断右子树是不是二叉搜索树
        if (j < length-1)
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, length-1));
        return (left&&right);
    }
}
