package com.offer;

/**
 * @author Basil
 * @create 2022/5/19 8:49
 */
public class JiangYu {
    public static void main(String[] args) {
        JiangYu jiangYu = new JiangYu();
//        System.out.println(jiangYu.calDistance("aaabccccbbbb", 'b'));
        System.out.println(jiangYu.calDistance("aaabbbccc", 'b'));
        System.out.println(jiangYu.calDistance("aaabcbdd", 'b'));
        System.out.println(jiangYu.calDistance("aaacccc", 'b'));
    }

    public int calDistance(String str, char tag) {
        //双指针
        int ans = -1, left = 0, length = str.length();
        //找到第一个tag的所在位置
        while (left < length && str.charAt(left) != tag) {
            left++;
        }
        while (left < length) {
            int right = left + 1;
            //找第二个tab的位置
            while (right < length && str.charAt(right) != tag) {
                right++;
            }
            //if判断右指针是否超过临界值
            if (right < length) {
                ans = Math.max(ans, right - left - 1);
            }
            left = right;
        }

        return ans;
    }

}
