package leetcode601_700;
/*
* 六百五十.只有两个键的键盘
*
* 题目描述：
* 要求只有两个操作:1.复制全部C  2.粘贴P,通过输入n,要求用最少的以上两个操作得到操作次数和
* 初始为A  结果要为n个A                 A  -> AAAAAAAA (所执行的最少步数)
* 例子:
* n = 3
* 则有AAA  (三个A,默认初始为一个A)
*
* 操作方式:
* A    C操作
* AA   P操作
* AAA  P操作
* 结果最少操作了3次,CPP
*
*
* 解题思路:首先需要判断一下是n是否为素数(除了1，然后只有本身的因数)
* */
public class leetcode650 {
    public static void main(String[] args){
        System.out.println(test(12));
    }
    public static int test(int n){
        //1.判断是否为素数
        if (ifSuNumber(n)){
            return n+1;
        }else {   //如果不是素数的话
            int[] dp = new int[n + 1];
            int h = (int) Math.sqrt(n);
            System.out.println("h:"+h);
            for (int i = 2; i <= n; i++) {
                dp[i] = i;
                System.out.println("dp["+i+"]:"+dp[i]+" 这个dp[i]=i");
                for (int j = 2; j <= h; j++) {
                    if (i % j == 0) {
                        dp[i] = dp[j] + dp[i / j];
                        System.out.println("dp[i]="+dp[i] +" i="+i+ " j="+j +" dp[j]="+dp[j]+" dp[i/j]="+dp[i/j]);
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
    //判断n是不是素数
    private static boolean ifSuNumber(int n){
        if (n == 1)
            return true;
        for (int i = 2;i<n;i++){
            if (n % i == 0)    //有其他因数,不是素数
                return false;
        }
        return true;
    }
}
