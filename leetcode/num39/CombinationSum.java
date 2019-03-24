package leetcode.num39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sunguangchao
 * @Date: 2019/3/17 5:56 PM
 * https://blog.csdn.net/liuchonge/article/details/79914330
 */
public class CombinationSum {
    public  List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if (nums[i] > remain){
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] sums = {2,3,5,7};
        System.out.println(combinationSum.combinationSum(sums,7));
    }
}
