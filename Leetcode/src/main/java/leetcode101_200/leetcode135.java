package leetcode101_200;

/**
 * 135.一群孩子站成一排，每一个孩子有自己的评分。现在需要给这些孩子发糖果，规则是如果一
 * 个孩子的评分比自己身旁的一个孩子要高，那么这个孩子就必须得到比身旁孩子更多的糖果；所
 * 有孩子至少要有一个糖果。求解最少需要多少个糖果。
 *
 * 方法：贪心算法(从左到右计算一次，从右到左算一次)
 *
 */
public class leetcode135 {
    public static void main(String[] args) {
        int [] ratings = {1,3,4,5,2};
        System.out.printf(candy(ratings)+"");
    }
    public static int candy(int[] ratings) {
        int size = ratings.length;
        if (size < 2){
            return size;
        }
        // 初始化都为1
        int[] num = new int[size];
        for (int i = 0;i< size;i++){
            num[i] = 1;
        }
        // 1.从左到右
        for (int i = 1;i<ratings.length;i++){
            if (ratings[i] > ratings[i-1]){
                num[i] = num[i-1]+1;
            }
        }
        // 2.从右到左
        for (int i = ratings.length-2;i >=0 ;i--){
            if (ratings[i] > ratings[i+1]){
                num[i] = Math.max(num[i+1]+1,num[i]);
            }
        }
        // 3.全部糖果相加
        int candyNum = 0;
        for (int i = 0;i < num.length;i++){
            candyNum += num[i];
        }
        return candyNum;
    }
}
