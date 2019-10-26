import java.util.ArrayList;
import java.util.List;

public class test extends Base {
    public void fun(int n){

    }
    public static void  main(String[] args){
        test("ds");
    }
    private static final List<String> list = new ArrayList<String>();
    private static String test(String j){
        int i = 1, s = 1, f = 1, a = 1, b = 1,c = 1,d = 1,e = 1;
        list.add(new String("11111111111111111111111111111"));
        return test(s+i+f+a+b+c+d+e+"");
    }
}
class Base{
    public Base (){
        //...
    }
    public Base ( int m ){
        //...
    }
    public void fun( int n ){
        //...
    }
}
