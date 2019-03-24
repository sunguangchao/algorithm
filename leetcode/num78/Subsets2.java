package leetcode.num78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: sunguangchao
 * @Date: 2019/3/24 2:47 PM
 * 循环解决：
 * 一开始有个空集[]
 * 循环1的时候:[1]
 * 循环2的时候:[2],[1,2]
 * 循环3的时候:[3],[1,3],[2,3],[1,2,3]
 *
 */
public class Subsets2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        for (int num : nums){
            int size = res.size();
            for (int i = 0; i < size; i++){
                List<Integer> tmp = new ArrayList<>(res.get(i));
                tmp.add(num);
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets2 subsets = new Subsets2();
        System.out.println(subsets.subsets(nums));
    }
}
