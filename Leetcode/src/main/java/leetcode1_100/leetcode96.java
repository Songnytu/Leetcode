package leetcode1_100;
/*
* 九十六.不同的二叉搜索树
*
* 题目:给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
*
* 解题思路:
* 动态规划:
* 1个点的时候返回1   dp[1] = 1 ，2个点的时候返回2   dp[2] = 2
* 3个点的时候遍历没一共点123
* 当i == 1 的时候，即根节点为1，根节点的右边23，为根节点的右子树，右子树的变换情况有两种dp[2] = 2,
* 继续遍历i == 2，1为根节点的左子树，3为根节点的右子树，左右子树变换情况为 1 * 1 ，得结果 1;
* 最后遍历到 i==3 ，1 2 构成根节点3的左子树 dp[2] = 2,得结果2
* 2 + 1 + 2 = 5  dp[3] = 5;
* */
public class leetcode96 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(test(n));
    }
    public static int test(int n){
        if (n < 2)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0;dp[1] = 1;
        for (int i=2;i<=n;i++){
            int currentResult = 0;
            for (int j = 1;j<=i;j++){
                if (dp[j-1]==0){
                    currentResult += dp[i-j];
                }else if (dp[i-j]==0){
                    currentResult += dp[j-1];
                }else {
                    currentResult += dp[j-1]*dp[i-j];
                }
            }
            dp[i] = currentResult;
        }
        return dp[n];
    }
}

