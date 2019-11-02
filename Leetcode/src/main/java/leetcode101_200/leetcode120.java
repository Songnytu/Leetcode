package leetcode101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 一百二十.三角形的最小路径和
*
* 题目:给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
* 例子:[
      [2],
     [3,4],
    [6,5,7],
   [4,1,8,3]
   ]
   自上而下的最小路径是2 + 3 + 5 + 1 =11
说明：
如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

解题思路:采用动态规划的思想
每个点的最下路径均有上一层的两个点的最小路径比较取最小而得
* */
public class leetcode120 {
    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(2));
        List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(3,4));
        List<Integer> list3 = new ArrayList<Integer>(Arrays.asList(6,5,7));
        List<Integer> list4 = new ArrayList<Integer>(Arrays.asList(4,1,8,3));
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int minRoute = 0;
        //定义一个最短路径的List集合(存储每行每个点计算后最短路径的结果)
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //初始化将三角形的最顶 2 放进去
        result.add(new ArrayList<Integer>(Arrays.asList(triangle.get(0).get(0))));
        for (int i = 1;i<triangle.size();i++){
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0;j<triangle.get(i).size();j++){
                int itselt = triangle.get(i).get(j);   //将当前位置的值保存一下
                if (j == 0){   //当前行的第一个数
                    temp.add(itselt+result.get(i-1).get(j));
                }else if (j == triangle.get(i).size()-1){  //当前行的最后一个
                    temp.add(itselt+result.get(i-1).get(j-1));
                }else {
                    //上一层的值与上一层的前一个值做比较取最小
                    temp.add(itselt+Math.min(result.get(i-1).get(j-1),result.get(i-1).get(j)));
                }
            }
            result.add(temp);
        }
        //遍历最后一行取最小路径值
        minRoute = result.get(result.size()-1).get(0);  //将最后一行的第一个值赋入minRoute
        for (int i = 1;i<result.get(result.size()-1).size();i++){
            if (result.get(result.size()-1).get(i) < minRoute){
                minRoute = result.get(result.size()-1).get(i);
            }
        }
        return minRoute;
    }
}
