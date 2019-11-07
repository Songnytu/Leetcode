package leetcode1001_1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
* 一千零二十九.两地调度
*
* 题目描述:公司面试2N个人，一共两个面试点A,B，2N个人分别到达这两个地方的费用不同，
* 其中必须有N个人去A地面试，N个人去B地面试。
*
* 解题思路:采用贪心算法,假设全部人都去B地,分别求出所有人去A地跟B地的差值price_A - price_B
* */
public class leetcode1029 {
    public static void main(String[] args){
        int[][] nums = {
                {10,20},
                {30,200},
                {400,50},
                {30,20}
        };
        System.out.println(test(nums));
    }
    public static int test(int[][] nums){
        int sum = 0;
        List<Integer[]> list = new ArrayList<Integer[]>();
        for (int i = 0;i<nums.length;i++){
            Integer[] li = new Integer[2];
            li[0] = i;li[1] = nums[i][0]-nums[i][1];   //li[0]记录下标  li[1]记录price_A - price_B
            list.add(li);
        }
        //采用选择排序的方式得出差值最小的前N位数
        List<Integer[]> result = new ArrayList<Integer[]>();  //排序后的结果(前N位取A,后N位取B)
        int forNum = list.size();   //要循环的次数
        for (int i = 0;i<forNum;i++){
            Integer[] minLi = list.get(0); int minIndex = 0;
            for (int j = 0;j<list.size();j++){
                if (list.get(j)[1]<minLi[1]){
                    minLi = list.get(j);
                    minIndex = j;
                }
            }
            System.out.println(minLi[0] +" "+minLi[1] );
            result.add(minLi);
            list.remove(minIndex);
        }
        for (int i = 0;i<nums.length/2;i++)
            sum += nums[result.get(i)[0]][0];
        for (int i = nums.length/2;i<nums.length;i++)
            sum += nums[result.get(i)[0]][1];
        return sum;
    }
    //Leetcode上官方题解
    public static int twoCitySchedCost(int[][] costs){
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        int total = 0;
        int n = costs.length/2;
        for (int i = 0;i<n;++i)
            total += costs[i][0] + costs[i+n][1];
        return total;
    }
}
