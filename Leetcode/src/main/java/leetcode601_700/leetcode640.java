package leetcode601_700;

/**
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 * 如果方程没有解，请返回“No solution”。
 * 如果方程有无限解，则返回“Infinite solutions”。
 * 如果方程中只有一个解，要保证返回值 x 是一个整数。
 *
 * 输入: "x+5-3+x=6+x-2"
 *
 * 输出: "x=2"
 */
public class leetcode640 {
    public static void main(String[] args){
        String str = "x+5-3+x=6+x-2";
        //bug
        System.out.println(solveEquation(str));
    }
    public static String solveEquation(String equation){
        String[] strs = equation.split("=");
        /* leftX为左式子的x倍数，leftY为左式子 */
        int leftX=0,rightX=0,leftY=0,rightY=0;
        getXY(leftX,leftY,strs[0]);
        getXY(rightX,rightY,strs[1]);
        /* 计算结果 */
        if (leftX-rightX!=0){
            if (rightY-leftY%(leftX-rightX)==0){
                int result = rightY-leftY/(leftX-rightX);
                return "x="+result;
            }else {
                return "No solution";
            }
        }
        return "Infinite solutions";
    }

    /**
     * 计算x的倍数和常量之和
     * @param X
     * @param Y
     * @param str
     */
    private static void getXY(int X,int Y,String str){
        //去掉字符串所有空格
        String strTrim = str.replace(" ","");
        //首字符加个+如果是负数不加
        if (strTrim.charAt(0)!= '-'){
            strTrim = "+"+strTrim;
        }
        //如果character为false代表'-',否则为'+'
        boolean character = false;
        int initial = 1,lastLetter = 0;
        String getStr = "";
        for (int i=0;i<strTrim.length();i++){
            if (strTrim.charAt(i)=='-' && i!=0){
                getStr = strTrim.substring(initial,i);
                if (getStr.contains("x")){
                    X += changeNumber(character,getStr);
                }else {
                    Y += changeNumber(character,getStr);
                }
                initial = i+1;
                character = false;
            }else if (strTrim.charAt(i)=='+' && i!=0){
                getStr = strTrim.substring(initial,i);
                if (getStr.contains("x")){
                    X += changeNumber(character,getStr);
                }else {
                    Y += changeNumber(character,getStr);
                }
                initial = i+1;
                character = true;
            }
        }
        getStr = strTrim.substring(initial);
        if (getStr.contains("x")){
            X += changeNumber(character,getStr);
        }else {
            Y += changeNumber(character,getStr);
        }
    }
    //转化成数字
    private static int changeNumber(boolean character,String str){
        int result = 0;
        if (str.contains("x")){   //含有x
            if (str.length()==1){
                result = 1;
            }else {
                result = Integer.valueOf(str.substring(0,str.length()-1));
            }
        }else {   //常量
            result = Integer.valueOf(str);
        }
        if (character){
            return result;
        }else {
            return result * (-1);
        }
    }
}
