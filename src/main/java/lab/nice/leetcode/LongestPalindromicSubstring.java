package lab.nice.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        String result = s.substring(0, 1);
        for (int i = 0; i < length - 2; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String longestStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (longestStr.length() > result.length()) {
                result = longestStr;
            }
        }
        return result;
    }

    private String centerSpread(String str, int left, int right) {
        int length = str.length();
        int leftIndex = left, rightIndex = right;
        while (leftIndex >= 0 && rightIndex < length) {
            if (str.charAt(leftIndex) == str.charAt(rightIndex)) {
                leftIndex--;
                rightIndex++;
            } else {
                break;
            }
        }
        return str.substring(leftIndex + 1, rightIndex);
    }
}
