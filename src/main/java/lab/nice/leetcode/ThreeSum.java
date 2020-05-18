package lab.nice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 时间复杂度：O(n^2)
 * 数组排序 O(n log(n)), 遍历数组O(n), 双指针遍历 O(n), 总体复杂度为 O(n log(n)) + O(n) * O(n) ，O(n^2)
 * 空间复杂度：O(1)
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 3) {
            return result;
        } else {
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length - 2; ) {
                if (nums[i] > 0) {
                    break;
                }
                int low = i + 1, high = length - 1; // slide window [low...right]
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum < 0) {
                        while (low < high && nums[low] == nums[++low]) {
                            //de-duplicate on right side of low index
                        }
                    } else if (sum > 0) {
                        while (low < high && nums[high] == nums[--high]) {
                            //de-duplicate on left side of high index
                        }
                    } else {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[++low]) {
                            //de-duplicate on right side of low index
                        }
                        while (low < high && nums[high] == nums[--high]) {
                            //de-duplicate on left side of high index
                        }
                    }
                }
                while (nums[i] == nums[++i]) {
                    //de-duplicate on current element
                }
            }
        }
        return result;
    }
}
