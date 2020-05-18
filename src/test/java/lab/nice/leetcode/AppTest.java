package lab.nice.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Assert.assertArrayEquals("Given nums = [2, 7, 11, 15], target = 9 \n" +
                "Expected result is [0, 1]", expect, result);
    }

    @Test
    public void testAddTwoNumbers() {
        //2 -> 4 -> 3
        final ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(3);
        //5 -> 6 -> 4
        final ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);
        //7 -> 0 -> 8
        final ListNode expected = new ListNode(7);
        expected.next = new ListNode(0);
        expected.next.next = new ListNode(8);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        final ListNode result = addTwoNumbers.addTwoNumbers(first, second);
        System.out.println(result);
        Assert.assertEquals("Given (2 -> 4 -> 3) + (5 -> 6 -> 4) \n" +
                "Expected result is (7 -> 0 -> 8)", expected, result);
    }

    @Test
    public void testLengthOfLongestSubstring() {
        final LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        Assert.assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void testThreeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        final List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, -1, 2));
        expected.add(Arrays.asList(-1, 0, 1));

        final ThreeSum solution = new ThreeSum();
        Assert.assertEquals(expected, solution.threeSum(nums));
    }
}
