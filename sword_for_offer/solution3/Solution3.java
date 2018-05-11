package solution3;

/**
 * 面试题3：二维数组中的查找
 * Created by 11981 on 2018/5/10.
 * 主要是要找出规律
 */
public class Solution3 {
    public boolean Find(int target, int [][] array){
        int row = 0;//行坐标
        int col = array[0].length - 1;//列坐标
        while (row <= array.length - 1 && col >= 0){
            if (target == array[row][col]){
                return true;
            }else if (target > array[row][col]){//如果目标值比右上角的值大，跳转到下一行
                row++;
            }else if (target < array[row][col]){//如果目标值比右上角的值小，跳转到前一列
                col--;
            }
        }
        return false;
    }
}
