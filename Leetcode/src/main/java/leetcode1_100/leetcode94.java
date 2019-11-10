package leetcode1_100;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
* 九十四.二叉树的中序遍历
*
* 题目描述:
* 输入: [1,null,2,3] 树结构
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

解题思路:采用stack栈数据结构来做
*
* */
public class leetcode94 {
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root1.right = root2;
        root2.left = root3;
        for (int a:test(root1)){
            System.out.print(a+" ");
        }
    }

    public static List<Integer> test(TreeNode root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentTree = root;
        while(currentTree!= null || !stack.isEmpty()){
            while (currentTree != null){
                stack.push(currentTree);
                currentTree = currentTree.left;
            }
            currentTree = stack.pop();
            list.add(currentTree.val);
            currentTree = currentTree.right;
        }
        return list;
    }
}
//树结构
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
