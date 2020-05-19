package lab.nice.leetcode;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * <p>
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    /**
     * Find the median value of the two sorted arrays
     *
     * @param nums1 the first sorted array
     * @param nums2 the second sorted arrag
     * @return the median value of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        // (m+n odd) median=(m+n+1)/2 = [(m+n+1)/2 + (m+n+2)/2] * 0.5
        // (m+n even) median=[(m+n)/2 + (m+n+2)/2] * 0.5
        return (findKth(nums1, 0, n - 1, nums2, 0, m - 1, left)
                + findKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5D;
    }


    /**
     * Find the Kth value in the two sorted arrays
     *
     * @param alpha      the first sorted array
     * @param alphaStart the start index of the first sorted array
     * @param alphaEnd   the end index of the first sorted array
     * @param beta       the second sorted array
     * @param betaStart  the start index of the second sorted array
     * @param betaEnd    the end index of the second sorted array
     * @param kth        the kth value to find
     * @return the kth value in the two sorted arrays
     */
    private int findKth(int[] alpha, int alphaStart, int alphaEnd,
                        int[] beta, int betaStart, int betaEnd, int kth) {
        int alphaLength = alphaEnd - alphaStart + 1;
        int betaLength = betaEnd - betaStart + 1;
        if (alphaLength > betaLength) {
            // Make sure alpha array is less than beta array in length
            // And then it must be alpha if array is empty
            return findKth(beta, betaStart, betaEnd, alpha, alphaStart, alphaEnd, kth);
        }
        if (alphaLength == 0) {
            return beta[betaStart + kth - 1];
        }
        if (kth == 1) {
            return Math.min(alpha[alphaStart], beta[betaStart]);
        }
        int alphaK = alphaStart + Math.min(alphaLength, kth / 2) - 1;
        int betaK = betaStart + Math.min(betaLength, kth / 2) - 1;
        if (alpha[alphaK] > beta[betaK]) {
            return findKth(alpha, alphaStart, alphaEnd,
                    beta, betaK + 1, betaEnd, kth - (betaK - betaStart + 1));
        } else {
            return findKth(alpha, alphaK + 1, alphaEnd,
                    beta, betaStart, betaEnd, kth - (alphaK - alphaStart + 1));
        }
    }
}
