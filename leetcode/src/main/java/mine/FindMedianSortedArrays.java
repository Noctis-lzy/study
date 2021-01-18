package main.java.mine;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    list.add(nums1[i]);
                    i = i + 1;
                }
                else {
                    list.add(nums2[j]);
                    j = j + 1;
                }
            }
            if (i == nums1.length) {
                for (; j < nums2.length; ++j) {
                    list.add(nums2[j]);
                }
                break;
            }
            if (j == nums2.length) {
                for (; i < nums1.length; ++i) {
                    list.add(nums1[i]);
                }
            }

        }
        double size = list.size();
        if (size == 0) {
            return 0;
        }
        if (size % 2 == 0) {
            double halfSize = size / 2;
            int value1 = list.get((int) halfSize - 1);
            int value2 = list.get((int) halfSize - 1 + 1);
            return (double) (value1 + value2) / 2;
        }
        else {
            return list.get((int) (size/2 + 0.5) - 1);
        }
    }

    public static void main (String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }
}
