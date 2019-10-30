package leetcode301_400;
/*
* 三百七十六.摆动序列
*
* 题目:如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
* 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
*
* 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
* 相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值
* 都是正数，第二个序列是因为它的最后一个差值为零。
*
* 给定一个整数序列，返回作为摆动序列的最长子序列的长度。
* 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，
* 剩下的元素保持其原始顺序。
*
* 例子1:输入: [1,7,4,9,2,5]   输出: 6    解释: 整个序列均为摆动序列。
* 例子2:输入: [1,17,5,10,13,15,10,5,16,8]   输出: 7  解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
*
* 解题思路:先得出没两个数之间的状态,1.表示升,2.表示降 3.表示没变(即等于上一个值)
* 再通过判断状态与状态之间的关系得结果。
*
* */
public class leetcode376 {
    public static void main(String[] args){
        int[] nums = {3,3,3,2,5};
        System.out.println(test(nums));
    }
    public static int test(int []nums){
        if (nums.length <= 1)
            return nums.length;
        int[] result = new int[nums.length];          //1表示升  2表示降  3表示等于
        for (int i =1;i<nums.length;i++){
            if (nums[i] > nums[i-1])
                result[i] = 1;
            else if (nums[i] < nums[i-1])
                result[i] = 2;
            else
                result[i] = 3;
        }
        int max = 1;
        int last = result[1];  //初始状态
        if (last != 3)
            max++;
        for (int i=2;i<result.length;i++){
            if (last !=result[i] && result[i]!=3)
                max++;
            if (result[i] !=3)
                last = result[i];
        }
        return max;
    }
}
