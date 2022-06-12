package com.offer.mid.binarySearch;

/**
 * @author Basil
 * @create 2022/3/20 10:51
 *
 * 二分查找
 */
public class SearchPeak {
    public static void main(String[] args) {
        SearchPeak searchPeak = new SearchPeak();
        System.out.println(searchPeak.findPeakElement(new int[]{1,2,3,1}));
    }

    /**
     * @param nums
     * @return
     * 俗话说「人往高处走，水往低处流」。如果我们从一个位置开始，不断地向高处走，那么最终一定可以到达一个峰值位置。
     * 我们可以发现，如果nums[i] < nums[i+1]，并且我们从位置 i 向右走到了位置 i+1，那么位置 ii 左侧的所有位置是不可能在后续的迭代中走到的。
     * 这是因为我们每次向左或向右移动一个位置，要想「折返」到位置 i 以及其左侧的位置，我们首先需要在位置 i+1 向左走到位置 i，但这是不可能的。
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }
            //如果 nums[i]<nums[i+1]，那么我们抛弃 [l, i] 的范围，在剩余 [i+1,r] 的范围内继续随机选取下标；
            //如果 nums[i]>nums[i+1]，那么我们抛弃 [i, r] 的范围，在剩余 [l,i−1] 的范围内继续随机选取下标。
            if (compare(nums, mid, mid + 1) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     *
     * @param nums
     * @param idx
     * @return
     * 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i]), 方便处理 nums[-1] 以及 nums[n] 的边界情况
     */
    public int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }

    public int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = get(nums, idx1);
        int[] num2 = get(nums, idx2);
        if (num1[0] != num2[0]) {
            return num1[0] > num2[0] ? 1 : -1;
        }
        if (num1[1] == num2[1]) {
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }
}
