package leetcode.num78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sunguangchao
 * @Date: 2019/3/24 11:14 AM
 * 回溯算法解决
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res, tmp, nums, 0);
        return res;

    }

    private void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start){
        res.add(new ArrayList<Integer>(tmp));
        for (int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            backTrack(res, tmp, nums, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(nums));
    }
    /** output:
     * [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
     */


}
