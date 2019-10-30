package leetcode1_100;

import java.util.Arrays;

/*
* 六十二.不同路径(剑指offer有相同的题)
*
* 地图从做上角到右下角所有路径的总数
*
* 解题思路:
* 动态规划，最右下角的最终结果等于左边加右边的路径数
*
* */
public class leetcode62 {
    public static void main(String[] args){
        int m = 3,n = 2;
        System.out.println(test(m,n));
    }
    public static int test(int m,int n){
        int dp[] = new int[n];     //每一个的结果都来源于上一格加左边一格
        // 首先初始化第一行均为1
        Arrays.fill(dp,1);
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){   //0去掉，第一列只等于上一格
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
