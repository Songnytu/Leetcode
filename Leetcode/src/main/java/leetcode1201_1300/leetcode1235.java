package leetcode1201_1300;

import java.util.Arrays;

/*
* 一千两百三十五.规划兼职找工作(困难)
*
* 题目描述:
* 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，
* 报酬为 profit[i]。给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime
* 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。注意，
* 时间上出现重叠的 2 份工作不能同时进行。如果你选择的工作在时间 X 结束，
* 那么你可以立刻进行在时间 X 开始的下一份工作。
*
* 例子1:输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
* 输出：120
* 解释：
* 我们选出第 1 份和第 4 份工作，
* 时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
*
* 例子2:输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
* 输出：150
* 解释：
* 我们选择第 1，4，5 份工作。
* 共获得报酬 150 = 20 + 70 + 60。
*
* 例子3:输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
* 输出：6
*
* 提示:
* 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
* 1 <= startTime[i] < endTime[i] <= 10^9
* 1 <= profit[i] <= 10^4
*
* 解题思路:
* 采用动态规划思想dp[i]表示从0~i时间段，能获得的最大工资
* 每次获取一个新的时间节点时，先从dp[0]~dp[i]
* 判断是否符合条件获取并+profit[n]得结果dp[n]的值
*
* 总结:该算法虽然采用动态规划是思想，但是由于先决条件需要endTime有序,在排序上面
* 发生超时,所以还不够完善。
* */
public class leetcode1235 {
    public static void main(String[] args){
        int[] startTime = {6,15,7,11,1,3,16,2},
                endTime = {19,18,19,16,10,8,19,8},
                profit = {2,9,1,19,5,7,3,19};
        System.out.println(test(startTime,endTime,profit));
    }
    public static int test(int[] startTime,int[] endTime,int[] profit){
        //先写一个排序，确保endTime是从小到大排序的，因为要为了动态规划需要dp[0~n]计算出来
        int lenght = endTime.length;
        for (int i=0;i<endTime.length;i++ ){
            int maxIndex = 0;
            for (int j=1;j<lenght;j++){
                if (endTime[maxIndex]<endTime[j]){
                    maxIndex = j;
                }
            }
            lenght--;
            int startTemp = startTime[maxIndex]; startTime[maxIndex] = startTime[lenght];  startTime[lenght]=startTemp;
            int endTemp = endTime[maxIndex]; endTime[maxIndex] = endTime[lenght];  endTime[lenght]=endTemp;
            int profitTemp = profit[maxIndex]; profit[maxIndex] = profit[lenght];  profit[lenght]=profitTemp;
        }
        //正式开始
        int max = 0;
        for (int y = 0;y<endTime.length;y++){
            if (endTime[y] > max)
                max = endTime[y];
        }
        int[] dp = new int[max+1];  //动态规划dp数组
        int maxInDp = 0;
        for (int i = 0;i < startTime.length;i++){     //遍历第i+1个兼职
            for (int n = 1;n<=startTime[i];n++){
                if (dp[n]+ profit[i]>dp[endTime[i]]){
                    dp[endTime[i]] = dp[n]+ profit[i];
                    System.out.println("dp["+endTime[i]+"]="+dp[endTime[i]]+" dp["+n+"]="+dp[n]+" profit[i]="+profit[i]+" i="+i);
                    if (dp[endTime[i]] > maxInDp){
                        maxInDp = dp[endTime[i]];
                    }
                }
            }
        }
        for (int k = 1;k<=max;k++)
            System.out.print("dp["+k+"]="+dp[k]+" ");
        System.out.println();
        return maxInDp;
    }
}
