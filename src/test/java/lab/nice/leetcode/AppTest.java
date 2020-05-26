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
        final TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(nums, target);
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

        final AddTwoNumbers solution = new AddTwoNumbers();
        final ListNode result = solution.addTwoNumbers(first, second);
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
    public void testMedianOfTwoSortedArrays() {
        final MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        Assert.assertEquals(2.0D, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.0D);
        Assert.assertEquals(2.5D, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.0D);
    }

    @Test
    public void testLongestPalindromicSubstring() {
        final LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        Assert.assertEquals("abbdddddddbba", solution.longestPalindrome("cabbdddddddbbaaaaasfsfs"));
    }

    @Test
    public void testZigzagConversion() {
        final ZigzagConversion solution = new ZigzagConversion();
        Assert.assertEquals("LDREOEIIECIHNTSG", solution.convert("LEETCODEISHIRING", 4));
    }

    @Test
    public void testReverseInteger() {
        final ReverseInteger solution = new ReverseInteger();
        Assert.assertEquals(0, solution.reverse(1534236469));
        Assert.assertEquals(0, solution.reverse(Integer.MAX_VALUE));
        Assert.assertEquals(1, solution.reverse(1));
        Assert.assertEquals(1, solution.reverse(10));
        Assert.assertEquals(12, solution.reverse(21));
        Assert.assertEquals(0, solution.reverse(0));
        Assert.assertEquals(-1, solution.reverse(-1));
        Assert.assertEquals(-1, solution.reverse(-10));
        Assert.assertEquals(-12, solution.reverse(-21));
        Assert.assertEquals(0, solution.reverse(Integer.MIN_VALUE));
    }

    @Test
    public void testStringToIntegerAtoi() {
        final StringToIntegerAtoi solution = new StringToIntegerAtoi();
        Assert.assertEquals(-42, solution.myAtoi("   -42"));
        Assert.assertEquals(4193, solution.myAtoi("4193 with words"));
        Assert.assertEquals(0, solution.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, solution.myAtoi("-91283472332"));
    }

    @Test
    public void testPalindromicNumber() {
        final PalindromicNumber solution = new PalindromicNumber();
        Assert.assertTrue(solution.isPalindrome(121));
        Assert.assertFalse(solution.isPalindrome(-121));
        Assert.assertFalse(solution.isPalindrome(10));
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
