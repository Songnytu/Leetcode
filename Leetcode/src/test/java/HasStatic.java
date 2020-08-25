public class HasStatic{
    private void m1(){}
    void m2(){}
    protected void m3(){}
    public static void m4(){}
}
class  Child  extends  HasStatic{
    private void m1(){}
    void m2(){}
    protected void m3(){}
    public static void m4(int nums[]){
        byte[] a = new byte[nums.length+1];
    }


}
