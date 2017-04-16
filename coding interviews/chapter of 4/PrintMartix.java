/**
 * Created by 11981 on 2017/4/2.
 * 面试题20：顺时针打印矩阵
 */
public class PrintMartix {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
        };
        PrintMartix testCircle = new PrintMartix();
        testCircle.printMatrixClockwisely(array);
    }
    public void printMatrixClockwisely(int[][] array){
        if (array == null)
            return;
        int start = 0;
        while (array[0].length > start*2 && array.length > start*2){
            printMatrixInCircle(array,start);
            start++;
        }
    }

    private void printMatrixInCircle(int[][] array, int start){
        int endX = array[0].length - start - 1;//终止列号
        int endY = array.length - start - 1;//终止行号
        //第一步，从左到右打印一行
        for (int i=start; i <= endX; i++){
            System.out.print(array[start][i] + " ");
        }
        //第二步，从上到下打印一行
        //前提条件：终止行号大于起始行号
        if (endY > start){
            for (int i = start+1; i <= endY; i++){
                System.out.print(array[i][endX] + " ");
            }
        }
        //从右到左打印一行
        //前提条件：终止行号大于起始行号，终止列号大于起始列号
        if (start < endX && start < endY){
            for (int i = endX - 1; i >= start; i--){
                System.out.print(array[endY][i] + " ");
            }
        }

        //从下到上打印一行，终止行号大于起始行号，终止列号-1大于起始列号
        if (start < endX && start < endY - 1){
            for (int i = endY - 1; i > start + 1; i--){
                System.out.print(array[i][start] + " ");
            }
        }


    }
}
