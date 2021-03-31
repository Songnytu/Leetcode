package leetcode401_500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 方法：贪心算法
 * 1.先按区间尾进行排序
 * 2.贪心比较，区间重叠就 total+1 表示要删除的区间 不重叠就替换
 */
public class leetcode435 {
    public static void main(String[] args) {
        int [][]intervals = {{1,100},{11,22},{1,11},{2,12}};
        int [][]intervals3 ={};
        int [][]intervals2 = {{1,2},{2,3},{3,4},{1,3}};
        int [][]intervals1= {{1,2}, {1,2}, {1,2}};
        System.out.printf(eraseOverlapIntervals(intervals)+"");
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        // 1.判空
        if (intervals.length <= 0 || intervals ==null){
            return 0;
        }
        // 2.排序
//        sort(intervals);
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        // 3.贪心算法
        int total = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] < prev){
                total++;
            }else{
                prev = intervals[i][1];
            }
        }

        return total;
    }

    //排序
    public static void sort(int[][] instervals){
        for (int i = 0; i < instervals.length-1;i++){
            for (int j = i; j < instervals.length-1;j++){
                if (instervals[j][1] > instervals[j+1][1]){
                    int[] temp = instervals[j];
                    instervals[j] = instervals[j+1];
                    instervals[j+1] = temp;
                }
            }
        }
    }
}
