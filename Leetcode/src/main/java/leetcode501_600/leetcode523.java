package leetcode501_600;
/*
* 五百二十三.连续的子数组和
*
* 题目:
* 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，
* 其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
*
* 举例:
* 例子1:   输入: [23,2,4,6,7], k = 6        输出: True      解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
* 例子2:   输入: [23,2,6,4,7], k = 6        输出: True      解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
*
* 解题:优化的暴力求解方式
*
* */
public class leetcode523 {
    public static void main(String[] args){
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(test(nums,k));
    }
    public static boolean test(int[] nums,int k){
        for (int i = 0;i<nums.length;i++){
            int result = nums[i];
            for (int j = i+1;j<nums.length;j++){
                result += nums[j];
                if (result == k || (k!=0 &&result % k == 0))  //注意多种特殊情况 例子: [0,0] 0   结果:true
                    return true;
            }
        }
        return false;
    }
}
