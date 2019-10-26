package leetcode1_100;

import java.util.Stack;

/*
* 三十二.最长的有效括号
*
* 题目:给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
*
* 示例 1:
* 输入: "(()"       输出: 2          解释: 最长有效括号子串为 "()"
*
*示例 2:
* 输入: ")()())"    输出: 4          解释: 最长有效括号子串为 "()()"
*
* */
public class leetcode32 {
    public static void main(String[] args){
        String s = "(()()()))";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        //该栈只记录符号的坐标
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);  //这里的作用是如果是')'，则出栈，但是如果第一个为')'，出栈会出错
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
