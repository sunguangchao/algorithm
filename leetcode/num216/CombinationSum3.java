package leetcode.num216;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sunguangchao
 * @Date: 2019/3/21 9:44 AM
 * k=3,n=7
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int [] candidates = new int[n];
        for (int i=0; i < n; i++){
            candidates[i] = i+1;
        }
        List<List<Integer>> res = new ArrayList<>();
        backTrack(k, n, res, new ArrayList<Integer>(), candidates, 0);
        return res;
    }

    private void backTrack(int k, int target, List<List<Integer>> res, List<Integer> tmp, int[] num, int start){
        if (target > 17){
            return;
        }
        if (target == 0 && k == 0){
            res.add(new ArrayList<>(tmp));
        }else if (target > 0 && k > 0){
            for (int i = start;i < num.length; i++){
                if (num[i] > target){
                    break;
                }
                if (num[i] > 9){
                    break;
                }
                tmp.add(num[i]);
                backTrack(k-1,target - num[i], res, tmp, num, i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        CombinationSum3 combinationSum = new CombinationSum3();
        System.out.println(combinationSum.combinationSum3(2, 17));
    }
}
