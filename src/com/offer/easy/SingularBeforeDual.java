package com.offer.easy;

import java.util.ArrayList;
import java.util.Scanner;

public class SingularBeforeDual {
    public static void main(String[] args) {
        SingularBeforeDual singularBeforeDual=new SingularBeforeDual();
        Scanner scanner=new Scanner(System.in);
        int[] cin=new int[6];
        for (int i = 0; i < 6; i++) {
            cin[i]=scanner.nextInt();
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(singularBeforeDual.exchange(cin)[i]);
        }
    }

    public int[] exchange(int[] nums) {
        ArrayList<Integer> singular=new ArrayList<Integer>();
        ArrayList<Integer> dual=new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2==1){
                singular.add(nums[i]);
            }else {
                dual.add(nums[i]);
            }
        }

        for (int i = 0; i < singular.size(); i++) {
            nums[i]= singular.get(i);
        }
        for (int i = singular.size(); i < singular.size() + dual.size(); i++) {
            nums[i]=dual.get(i-singular.size());
        }
        return nums;
    }
}

//评论大佬做法，属实给我干没电了
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}