package leetcode1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 十五.三数之和
*
* 题目描述:
* 找出数组内的3个数和为0，得到这些数的集合(不能重复)
* */
public class leetcode15 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums.length<3 || nums == null)
            return lists;
        Arrays.sort(nums);
        int lenght = nums.length;
        for (int i = 0;i<lenght;i++){
            //如果当前数字大于0，则不可能存在等于0的情况了
            if( nums[i] > 0) break;
            //去除重复  注：：可借鉴这个写法
            if(i>0 && nums[i] == nums[i-1]) continue;
            //左指针
            int l = i+1;
            //右指针
            int r = lenght - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    lists.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //前后去重
                    while(l<r && nums[l] == nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
                //如果数小于0 ，证明前面的数太小
                else if(sum < 0) l++;
                    //如果数大于1，证明后面的数太大
                else if(sum > 0) r--;
            }

        }
        return lists;
    }
}
