package leetcode.array.num016;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by 11981 on 2019/12/15.
 * https://leetcode.com/problems/3sum-closest/
 * <p>
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target. Return the sum of the three integers.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest.threeSumClosest(nums, 1));

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

}
