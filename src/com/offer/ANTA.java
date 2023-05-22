package com.offer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ANTA {
    public static void main(String[] args) {
        ANTA at=new ANTA();
        File file = new File("D:/我的文档/专业资料/JAVA/校宝笔试/1号迷宫(0,18).txt");
        File file2=new File("D:/我的文档/专业资料/JAVA/校宝笔试/2号迷宫(0,1).txt");
        StringBuilder result = new StringBuilder();
        int[][] mg1 = new int[20][20];
        int[][] mg2=new int[18][19];
        int x1=0,y1=18;
        int x2=0,y2=1;
        int in1=0,in2=0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file)); //构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null) {
                //使用readLine方法，一次读一行
                String[] line=s.split("");
                for (int i = 0; i < line.length; i++) {
                    mg1[in1][i]= Integer.parseInt(line[i]);
                }
                in1++;
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(file2));
//            String s = null;
//            while((s = br.readLine())!=null) {
//                String[] line=s.split("");
//                for (int i = 0; i < line.length; i++) {
//                    mg2[in2][i]= Integer.parseInt(line[i]);
//                }
//                in2++;
//            }
//            br.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        at.miGong(mg1,x1,y1);
//        System.out.println("=================");
//        at.miGong(mg2,x2,y2);
    }

    public void miGong(int[][] mg,int x,int y){
        ArrayList<ArrayList<Integer>> aws = new ArrayList<>();//要输出的答案
        int[][] flag=new int[mg.length][mg[0].length];//记录走过的坐标
        int index=0;//aws的当前索引
        road(mg,flag,x,y,aws,index);
    }

    public void road(int[][] mg,int[][] flag,int x,int y,ArrayList<ArrayList<Integer>> aws,int index){
        //参数为：迷宫数组，是否已经走过的标记数组，当前横坐标，当前纵坐标，答案数组，答案的当前长度
        if (x== mg.length||y==mg[0].length){//判断是否找到了出口
            for (int i = 0; i < aws.size(); i++) {
                System.out.println("("+aws.get(i).get(0)+","+aws.get(i).get(1)+")");
            }
            return;
        }
        if (x<0||y<0||flag[x][y]==1){//判断是否越界
            return;
        }
        if (mg[x][y]==0){
            aws.add(new ArrayList<>());
            aws.get(index).add(x);
            aws.get(index).add(y);
            index++;
            flag[x][y]=1;//标记当前位置已经走过
            road(mg,flag,x-1,y,aws,index);
            road(mg,flag,x+1,y,aws,index);
            road(mg,flag,x,y-1,aws,index);
            road(mg,flag,x,y+1,aws,index);
        }else {
            return;
        }
    }
}
