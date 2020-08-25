import java.util.Scanner;

public class testtrycatch {
    protected testtrycatch(){

    }
    public static void main(String[] args) {
        Integer i1 = -128;
        Integer i2 = -128;
        System.out.println(i1 == i2);
        Scanner sc = new Scanner(System.in);
        String str = "dsds";
        char s = str.charAt(0);
    }
    public static int test(int x,int y){
        //return ((x+y-1)^(~(y-1)));
        return ((x+y-1)&(~(y-1)));    //~表示去二进制的每一位取反
    }
    Thread thread = new Thread(new Runnable() {
        public void run() {

        }
    });
}
