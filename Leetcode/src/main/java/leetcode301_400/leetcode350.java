package leetcode301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 三百五十.两个数组的交集II
*
* 题目描述:
* 找出两个数组的交集
* 例子:
*  1 2 2 3 5 4   和  5 8 2 3    结果为 5 2 3 (结果顺序不做要求)
* */
public class leetcode350 {
    public static void main(String[] args) {
        int[] A = {1,2,2,3};
        int[] B = {5,2,2};
    }
    public int[] test(int[] A,int[] B){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int num:A){
            if (!map.containsKey(num))   //containKey校验map存不存在num为key的元素
                map.put(num,1);
            else
                map.put(num,map.get(num)+1);
        }
        //遍历B数组
        for (int num:B){
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0)
                    map.remove(num);
            }
        }
        //将list数据传回数组当中
        int[] result = new int[list.size()];
        for (int i = 0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
