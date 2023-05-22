package com.offer.easy.doublePointer;

/**
 * @author Basil
 * @create 2022/3/7 9:19
 *
 * 双指针
 */
public class ReverseStrings {
    public static void main(String[] args) {
        ReverseStrings reverseString = new ReverseStrings();
        reverseString.reverseString(new char[]{'h','e','l','l','o'});
    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        char temp;
        while (left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(s);
    }
}
