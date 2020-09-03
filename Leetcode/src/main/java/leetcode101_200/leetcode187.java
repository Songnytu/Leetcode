package leetcode101_200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 就是个字符串找重复子序列
 */
public class leetcode187 {
    public static void main(String[] args){
        String strs = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> strList = findRepeatedDnaSequences(strs);
        for (String str:strList){
            System.out.print(str+",");
        }
    }
    public static List<String> findRepeatedDnaSequences(String s){
        int lenght = 10;
        Set<String> input = new HashSet();
        List<String> result = new ArrayList<String>();
        for (int i =0;i<s.length()-lenght;i++){
            String currentStr = s.substring(i,i+10);
            if (input.contains(currentStr)){
                result.add(currentStr);
            }
            input.add(currentStr);
        }
        return result;
    }
}
