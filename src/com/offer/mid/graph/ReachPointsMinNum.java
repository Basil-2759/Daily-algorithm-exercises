package com.offer.mid.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Basil
 * @create 2022/8/22 14:40
 * @title 1557. 可以到达所有点的最少点数目
 * @notes 解题关键在于寻找入度为0的点，而所有有向边的终点里都不包含的节点，及时入度为0的节点
 */
public class ReachPointsMinNum {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(5);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(3);
        list4.add(4);
        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(4);
        list5.add(2);
        ArrayList<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);
        System.out.println(findSmallestSetOfVertices(6, list));
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> endSet = new HashSet<>();
        for (List<Integer> edge : edges) {
            endSet.add(edge.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!endSet.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
