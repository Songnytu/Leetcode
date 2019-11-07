package leetcode701_800;
/*
* 七百六十五.情侣牵手
*
* 题目描述:
* N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，
* 以便每对情侣可以并肩坐在一起。一次交换可选择任意两人，让他们站起来交换座位。
*
* 解题思路:
* 循环判断每两个两个是否是情侣,如果不是情侣再循环往下寻找到对应的情侣再交换一次位置
*
* */
public class leetcode765 {
    public static void main(String[] args){
        int[] nums = {6,2,1,7,4,5,3,8,0,9};
        System.out.println(test(nums));
    }
    public static int test(int[] nums){
        int sum = 0;
        for (int i = 0;i<nums.length;i+=2){
            if (nums[i]%2 == 0){
                if (nums[i]+1 == nums[i+1])
                    continue;

            }else {
                if (nums[i]-1 == nums[i+1])
                    continue;
            }

            for (int j = i+1;j<nums.length;j++){
                if (nums[i]%2==0){
                    if (nums[j] == nums[i]+1){
                        int temp = nums[i+1];
                        nums[i+1] = nums[j];
                        nums[j] = temp;
                        sum++;
                        break;
                    }
                }else {
                    if (nums[j] == nums[i]-1){
                        int temp = nums[i+1];
                        nums[i+1] = nums[j];
                        nums[j] = temp;
                        sum++;
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
