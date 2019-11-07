package leetcode601_700;

import java.util.Stack;

/*
* 六百八十二.棒球比赛(栈)
*
* 题目描述:你现在是棒球比赛记录员。
*  给定一个字符串列表，每个字符串可以是以下四种类型之一：
*  1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
*  2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
*  3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
*  4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
*
* 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
* 你需要返回你在所有回合中得分的总和。
*
* 示例1: 输入: ["5","2","C","D","+"]  输出: 30
*  解释:
*  第1轮：你可以得到5分。总和是：5。
*  第2轮：你可以得到2分。总和是：7。
*  操作1：第2轮的数据无效。总和是：5。
*  第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
*  第4轮：你可以得到5 + 10 = 15分。总数是：30。
*
* 示例2:  输入: ["5","-2","4","C","D","9","+","+"]   输出: 27
*  解释:
*  第1轮：你可以得到5分。总和是：5。
*  第2轮：你可以得到-2分。总数是：3。
*  第3轮：你可以得到4分。总和是：7。
*  操作1：第3轮的数据无效。总数是：3。
*  第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
*  第5轮：你可以得到9分。总数是：8。
*  第6轮：你可以得到-4 + 9 = 5分。总数是13。
*  第7轮：你可以得到9 + 5 = 14分。总数是27。
*
* */
public class leetcode682 {
    public static void main(String[] args){
        String[] str = {"5","-2","4","C","D","9","+","+"};
        System.out.println(test(str));
    }
    public static int test(String[] str){
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : str){
            if (s.equals("+")){
                int top = stack.pop();  //将顶弹出
                int newtop = top + stack.peek();   //相当于将上两个值相加
                stack.push(top);             //再将这两个顶按顺序压入栈中
                stack.push(newtop);
            }
            else if (s.equals("C"))
                stack.pop();
            else if (s.equals("D"))
                stack.push(stack.peek()*2);
            else
                stack.push(Integer.parseInt(s));  //或者使用stack.push(Integer.valueOf(s))
        }
        int sum = 0;
        for (int num : stack)
            sum += num;
        return sum;
    }
}
