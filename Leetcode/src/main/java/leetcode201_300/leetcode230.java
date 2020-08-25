package leetcode201_300;
/*
* 二百三十.查找一颗搜索二叉树的第k个小的数
*
* 题目描述:
* 一颗找到一个二叉搜索数的所有元素，第k小的那个元素
*
* 解题思路:
* 因为是二叉搜索树，所以根据中序遍历，得到的结果一定是从小到大有序排列的
* */
public class leetcode230 {
    static int result = 0;
    static int target = 0;
    public static void main(String[] args){
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree4 = new TreeNode(4);
        TreeNode tree5 = new TreeNode(5);

        tree3.left = tree1;
        tree1.right = tree2;
        tree3.right = tree4;
        tree4.right = tree5;

        test(tree3,1);
        System.out.println("result="+result);
    }
    private static void test(TreeNode root,int k){
        if (root == null){
            return;
        }
        test(root.left,k);
        if (k == ++target){
            result = root.val;
        }
        test(root.right,k);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}