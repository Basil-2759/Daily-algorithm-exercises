package com.offer.mid.slidingWindow;

/**
 * @author Basil
 * @create 2022/3/24 20:07
 * <p>
 * 滑动窗口
 */
public class SonArrayOfMinimumK {
    public static void main(String[] args) {
        SonArrayOfMinimumK sonArrayOfMinimumK = new SonArrayOfMinimumK();
        System.out.println(sonArrayOfMinimumK.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //思路：定义两个指针
        //左、右指针起始在位置0；右指针开始移动
        //移动过程中纪录从左指针到右指针路上的连续数的乘积
        //如果乘积大于k了，则左指针右移

        //同样排除k为1的情况比如  [1,1,1] k=1
        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int right = 0;

        //创建一个变量记录路上的乘积
        int mul = 1;

        //记录连续数组的组合个数
        int ans = 0;


        for (int i = 0; i < nums.length; i++) {

            //记录乘积
            mul *= nums[right];

            //当大于k，左指针右移并把之前左指针的数除掉
            while (mul >= k) {

                mul /= nums[left];

                left++;
            }

            //每次右指针位移到一个新位置，应该加上x种数组组合：
            //  nums[right]
            //  nums[right-1], nums[right]
            //  nums[right-2], nums[right-1], nums[right]
            //  nums[left], ......, nums[right-2], nums[right-1], nums[right]
            //共有 right - left + 1 种

            ans += right - left + 1;

            //右指针右移
            right++;

        }

        return ans;
    }
}
