package lab.nice.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testTwoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expect = {0, 1};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, target);
        Assert.assertArrayEquals("Expected result is [0, 1]", expect, result);
    }
}
