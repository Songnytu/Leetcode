package leetcode201_300;
/*
* 二百六十四.丑数II
*
* 题目描述:
* 编写一个程序，找找出第n个丑数。
* 丑数就是只包含质因数 2, 3, 5 的正整数。
*
* 示例:
* 输入: n = 10
* 输出: 12
* 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
*
* 解题思路:由于丑数都是由2，3，5的倍数而来，那么从1开始，1分别乘2，3，5，取其中最小则为1后面的下一个丑数
* 并且该倍数的索引+1   就好比dp[0] = 1  ,2,3,5的倍数下标均从0开始，如果dp[1]是由dp[0]*2得到的,则2的倍数下标
* 要+1,变为下次比较取最小值时在dp[1]*2 ,dp[0]*3,dp[0]*5中取,被选中后继续+1。
* 注意:采用三个判断均采用if,而不用if，elseif，esle ，因为存在两种或三种乘积后都为最小值的情况，则倍数索引都+1
* * */
public class leetcode264 {
    public static void main(String[] args){
        int n = 11;
        System.out.println(test(n));
    }
    //动态规划思想
    public static int test(int n){
        int[] result = new int[n];
        int num_2=0,num_3=0,num_5=0;
        result[0] = 1;
        for (int i = 1;i<n;i++){
            int min = Math.min(result[num_2]*2,Math.min(result[num_3]*3,result[num_5]*5));
            if (result[num_2]*2 == min)
                num_2++;
            if (result[num_3]*3 == min)
                num_3++;
            if (result[num_5]*5 == min)
                num_5++;
            result[i] = min;
        }
        return result[n-1];
    }
}
