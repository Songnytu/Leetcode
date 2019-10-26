package leetcode1_100;
/*
* 五.最长回文子串
*
* 题目: 输入s: abcdcbafgh
* 结果得到最长的回文子串abcdcba
*
* 解题思路:中心扩展法,输入2n-1个开始中心点,不断重中心点向两边判断是否左等于右
*
* */
public class leetcode5 {
    public static void main(String[] args){
        String str = "abcdcbafgh";
        System.out.println(longestPalindrome(str));
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0,end = 0;   //最长子串的开始到结束的下标
        for (int i=0;i<s.length();i++){
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len > end - start){
                //len如果是奇数，则表示是由i i情况得的最长子串,如果是偶数则为i i+1开始得的子串
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }
    //计算中心点向向两边扩展的最大长度
    public static int expandAroundCenter(String str,int left,int right){
        int L = left,R = right;
        while(L>=0&&R<str.length()&&str.charAt(L)==str.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
