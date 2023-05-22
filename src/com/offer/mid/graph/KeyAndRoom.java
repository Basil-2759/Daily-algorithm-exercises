package com.offer.mid.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Basil
 * @create 2022/8/21 16:45
 * @title 841. 钥匙和房间
 * @notes 深/广度优先遍历 递归
 */
public class KeyAndRoom {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        rooms.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        rooms.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(3);
        rooms.add(list3);
        rooms.add(new ArrayList<>());

        System.out.println(canVisitAllRooms(rooms));
    }

    static boolean[] vis;
    static int num;

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    public static void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }
}
