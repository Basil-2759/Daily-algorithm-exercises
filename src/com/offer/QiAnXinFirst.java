package com.offer;

import java.util.ArrayList;

/**
 * @author Basil
 * @create 2022/4/11 19:26
 */
public class QiAnXinFirst {
    public static void main(String[] args) {
        QiAnXinFirst qiAnXinFirst = new QiAnXinFirst();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(181);
        list.add(180);
        list.add(165);
        list.add(175);
        list.add(168);
        list.add(168);
        list.add(178);
        System.out.println(qiAnXinFirst.lengthOfMaxQueue(list));
        System.out.println(qiAnXinFirst.lengthOfMaxQueue(null));
    }

    public int lengthOfMaxQueue(ArrayList<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return 0;
        }
        int ans = 1;
        for (int i = 0; i < nums.size(); i++) {
            int listMax = nums.get(i);
            int listLength = 1;
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) > listMax) {
                    listMax = nums.get(j);
                    listLength++;
                }
            }
            ans = Math.max(ans, listLength);
        }

        return ans;
    }
}
