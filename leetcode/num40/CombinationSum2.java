package leetcode.num40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sunguangchao
 * @Date: 2019/3/19 10:07 PM
 * https://leetcode.com/problems/combination-sum-ii/submissions/
 *
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> tmpList, int[] candidates, int start, int target){
        if (target == 0){
            res.add(new ArrayList<>(tmpList));
            return;
        }else if (target > 0){
            for (int i =start; i < candidates.length; i++){
                if (candidates[i] > target){
                    break;
                }
                //关键点，从已经重复的continue
                if (i > start && candidates[i] == candidates[i-1]){
                    continue;
                }
                tmpList.add(candidates[i]);
                backTrack(res, tmpList, candidates, i+1, target-candidates[i]);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] array = {2,5,2,1,2};
        System.out.println(combinationSum2.combinationSum2(array, 5));
    }
}
