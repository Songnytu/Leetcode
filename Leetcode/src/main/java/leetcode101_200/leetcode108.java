package leetcode101_200;

import java.util.Arrays;

/*
* 一百零八.将有序数组转化为二叉搜索树
*
* 题目描述:
* 给定一个有序的数组，将其转为二叉搜索树
*
* 解题思路:
* 通过二分的递归的方式构造二叉搜索树，每一次遍历的nums中间节点作为树的根节点
* */
public class leetcode108 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        test(nums);
    }
    public static TreeNode test(int[] nums){
        if (nums.length == 0)
            return null;
        int len = nums.length/2;
        TreeNode root = new TreeNode(nums[len]);
        root.left = test(Arrays.copyOfRange(nums,0,len));
        root.right = test(Arrays.copyOfRange(nums,len+1,nums.length));
        return root;
    }
}
/*
树结构
class TreeNode{
    int val;
    TreeNode left;
    TreeNode rigth;
    TreeNode(int val){
        this.val = val;
    }
}
*/