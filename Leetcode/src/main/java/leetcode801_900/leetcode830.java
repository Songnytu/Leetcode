package leetcode801_900;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. 较大分组的位置
 *
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 */
public class leetcode830 {
    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
        String s1 = "abbxxxxzyy";
        String s2 = "aaa";
        for ( List<Integer> list : largeGroupPositions(s)){
            for (Integer li : list){
                System.out.print(li+",");
            }
            System.out.println();
        }
        System.out.println("结束");
    }
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        char currentChar = '#';
        Integer start = 0;
        Integer end = 0;
        for (int i = 0;i<s.length();i++){
            if (currentChar != s.charAt(i)){
                if (end-start >= 2){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(start);
                    list.add(end);
                    result.add(list);
                }
                currentChar = s.charAt(i);
                start = i;
                end = i;
            }else{
                end++;
            }
        }
        // 测试能否提交
        if (end-start >= 2){
            List<Integer> list = new ArrayList<Integer>();
            list.add(start);
            list.add(end);
            result.add(list);
        }
        return result;
    }
}
