package lab.nice.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * reference https://www.jacob2359.com/2019/05/10/LeetCode-3-无重复字符的最长子串/
 * 子串：字符串中任意个连续的字符组成的子序列称为该串的子串。注意子串强调字符的连续性。
 * 子序列：字符串中去掉任意个元素后得到的结果即为该字符串的子序列。注意子序列中字符出现的次序与原字符串中字符出现的次序要保持一致。
 * 时间复杂度为O(n)，空间复杂度为O(1)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] frequence = new int[256]; //ASCII
        int left = 0, right = -1; //slide window s[left...right]
        int res = 0, length = s.length();
        while (left < length) {
            if (right + 1 < length && frequence[s.charAt(right + 1)] == 0) {
                right++;
                frequence[s.charAt(right)]++;
            } else {
                frequence[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
