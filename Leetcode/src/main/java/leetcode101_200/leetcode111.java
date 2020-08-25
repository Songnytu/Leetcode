//package leetcode101_200;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///*
//* 一百一十一.二叉树的最小深度
//*
//* 题目描述:
//* 给定一个二叉树，找出其最小深度。
//* 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//* 说明: 叶子节点是指没有子节点的节点。
//* 例子:
//*           3
//*         /  \
//*        9   20
//*           /  \
//*         15    7
//*
//*    返回结果深度为2
//*
//* leetcode上提交会显示找不到对象，不知是因为Pair在javafx包下的原因，又或者是不允许
//* 泛型里面还有泛型，导致提交失败。但是算法是正确的。
//* */
//public class leetcode111 {
//    public static void main(String[] args){
//        //1.自定义一棵树
////        TreeNode treeNode1 = new TreeNode(1);
////        TreeNode treeNode2 = new TreeNode(2);
////        TreeNode treeNode3 = new TreeNode(3);
////        TreeNode treeNode4 = new TreeNode(4);
////        TreeNode treeNode5 = new TreeNode(5);
////        treeNode1.left = treeNode2;
////        treeNode1.right = treeNode3;
////        treeNode3.left = treeNode4;
////        treeNode3.right = treeNode5;
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        treeNode1.right = treeNode2;
//        //执行算法
//        System.out.println(test(treeNode1));
//    }
//    public static int test(TreeNode root){
//        if (root == null)
//            return 0;
//        int nums = 0;
//        //这里简述一下Pair是一个key-value保存形式的数据结构,用泛型指定key,value
//        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<Pair<TreeNode,Integer>>();
//        queue.add(new Pair<TreeNode, Integer>(root,1));
//        while(!queue.isEmpty()){
//            Pair<TreeNode,Integer> currentTreeNode = queue.poll();
//            if (currentTreeNode.getKey().left==null&&currentTreeNode.getKey().right==null){
//                return currentTreeNode.getValue();
//            }
//            if (currentTreeNode.getKey().left!=null)
//                queue.add(new Pair<TreeNode, Integer>(currentTreeNode.getKey().left,currentTreeNode.getValue()+1));
//            if (currentTreeNode.getKey().right!=null)
//                queue.add(new Pair<TreeNode, Integer>(currentTreeNode.getKey().right,currentTreeNode.getValue()+1));
//        }
//        return 0;
//    }
//}
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int val){
//        this.val = val;
//    }
//}