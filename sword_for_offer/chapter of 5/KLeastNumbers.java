
import java.util.Arrays;

/**
 * Created by 11981 on 2017/4/17.
 * 面试题30：最小的k个数
 * 涉及到了红黑树，还是不太理解。
 * !!!
 */
public class KLeastNumbers {
    public static void main(String[] args){
        KLeastNumbers k = new KLeastNumbers();
        int[] array = {4,5,1,6,2,7,3,8};
        k.getLeastNumber(array,4);
    }
    public void getLeastNumber(int[] array, int k){
        if (array == null || k<0 || k > array.length)
            return;
        int [] kArray = Arrays.copyOfRange(array,0,k);
        buildMaxHeap(kArray);
        for (int i=k; i < array.length; i++){
            if (array[i] < kArray[0]){
                kArray[0] = array[i];
                maxHeap(kArray,0);
            }
        }
        for (int i : kArray)
            System.out.print(i + " ");
    }

    private void maxHeap(int[] kArray, int i){
        int left = 2 * i;
        int right = left + 1;
        int largest = 0;
        if (right < kArray.length && kArray[left]>kArray[i])
            largest = left;
        else
            largest = i;
        if (right < kArray.length && kArray[right] > kArray[largest])
            largest = right;
        if (largest != i){
            int temp = kArray[i];
            kArray[i] = kArray[largest];
            kArray[largest] = temp;
            maxHeap(kArray, largest);
        }
    }

    private void buildMaxHeap(int[] kArray){
        for (int i=kArray.length/2; i>=0; i--)
            maxHeap(kArray,i);
    }
}
