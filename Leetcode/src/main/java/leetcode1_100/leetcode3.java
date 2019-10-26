package leetcode1_100;

import java.util.ArrayList;
import java.util.List;

/*
* 三.重复字符的最长字串
*
* //思路:暴力
* */
public class leetcode3 {
    public static void main(String[] args){
        String str = "sheisgood";   //结果heisgo 为 6
        System.out.println(lengthOfLongestSubstring(str));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] ar = s.toCharArray();
        char lastadd;
        int best = 0,now = 0,jump=0;
        List templist = new ArrayList();
        for(int i=0;i<ar.length;i++){
            for(int j=i;j<ar.length;j++){
                templist.add(ar[j]);
                lastadd = (Character) templist.get(templist.size()-1);
                if(best<1){best=templist.size();}
                for(int k=0;k<templist.size()-1;k++){
                    if((Character)templist.get(k)==lastadd){
                        if(best<now){
                            best = now;
                        }
                        now = 0;
                        templist.clear();
                        jump = 1;
                        break;
                    }
                }
                if(jump==1){
                    jump=0;
                    break;
                }
                now++;
            }
        }
        return best;
    }
}
