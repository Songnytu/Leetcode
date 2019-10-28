package leetcode101_200;

import java.util.*;

/*
* 一百三十九.单词拆分
*
* 题目:
* 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s
* 是否可以被空格拆分为一个或多个在字典中出现的单词。
*
* 例子1:输入: s = "leetcode", wordDict = ["leet", "code"]  输出: true 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
*
* 例子2:输入: s = "applepenapple", wordDict = ["apple", "pen"]  输出: true  解释: 返回 true 因为 "applepenapple"
* 可以被拆分成 "apple pen apple"。注意你可以重复使用字典中的单词。
*
* 例子3:输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]  输出: false
*
* 思路:递归求解(分解为子问题)
*
*
* */
public class leetcode139 {
    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<String>(Arrays.asList("aaaa","aaa"));
        System.out.println(test1(s,wordDict));
    }

    //动态规划求解
    public static boolean test1(String s, List<String> wordDict){
        Set<String> wordDictSet = new HashSet<String>(wordDict);  //将arraylist改成hashset
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;   //dp[i] = 当长度为i时，能有正确解
        for (int i = 0;i<=s.length();i++){
            for (int j = 0;j<i;j++){
                if (dp[j] && wordDictSet.contains(s.substring(j,i))){  //长度为i时,为长度为j时 + 子串集
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //暴力递归求解 (该算法超时)
    public static boolean test2(String s, List<String> wordDict){
        if (s == null || s.length() == 0){
            return true;
        }
        for (int i=0;i<s.length();i++){   //i代表末尾的数
            boolean coming = false;
            String current = s.substring(0,i+1);
            for (String str:wordDict){
                if (str.equals(current)){
                    coming = true;
                    System.out.print(current+" ");
                    break;
                }
            }
            if (coming){
                System.out.println("子字符串:"+s.substring(i+1));
                if(test2(s.substring(i+1),wordDict)){
                    return true;
                }
            }
        }
        return false;
    }
}
