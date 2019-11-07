package leetcode701_800;
/*
* 七百六十六.托普利茨矩阵
*
* 题目描述:
* 输入一个二维int型数组,返回true 或者 false
* 判断矩阵是否从左上到右下对角线都相等
* 例子1: {
*       [1,2,3,4],
*       [5,1,2,3],
*       [9,5,1,2]
*       }                  返回true
* 例子2: {
*        [1,2],
*        [2,2]
*        }                 返回false,因为   [1         不相同
*                                               2]
*
* 解题思路:暴力求解
* */
public class leetcode766 {
    public static void main(String[] args){
        int[][] nums = {
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        };
        System.out.println(test(nums));
    }
    public static boolean test(int[][] nums){

        int n = nums.length,m = nums[0].length;   //n行m列
        if (n == 1 || m == 1){
            return true;
        }
        for (int i = 0,j = 0;j<m;j++){
            int target = nums[i][j];
            for (int q = i,w =j;q<n && w<m;w++,q++){
                if (nums[q][w] != target) {
                    return false;
                }
            }
        }
        for (int j = 0,i = 1;i<n;i++){
            int row = i,line = j;
            int target = nums[i][j];
            for (int q = i,w =j;q<n && w <m;q++,w++){
                if (nums[q][w] != target) {
                    System.out.println("是你？");
                    return false;
                }
            }
        }
        return true;
    }
    /*更优秀的解法
        解题思路,从1，1开始两层for循环,每遍历一个值就跟左上角那个值比较是否相等
    */
    public static boolean test2(int[][] nums){
        if (nums.length == 1)
            return true;
        for (int i = 1;i<nums.length;i++){
            for (int j = 1;j < nums[0].length;j++){
                if (nums[i][j] != nums[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
}
