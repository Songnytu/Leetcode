package leetcode301_400;

import java.util.Arrays;

/**
 * 455.分发饼干
 * 小朋友不同的饥饿量，饼干不同的分量
 * 方法：贪心算法
 */
public class leetcode455 {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.printf(findContentChildren(g,s)+"");
    }

    public static int findContentChildren(int[] g, int[] s) {
        // 1.先排序
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        // 2.循环吃饼干饥饿最小的先吃
        while (child < g.length && cookie < s.length){
            if (g[child] <= s[cookie]){
                ++child;
            }
            ++cookie;
        }

        return child;
    }
}
