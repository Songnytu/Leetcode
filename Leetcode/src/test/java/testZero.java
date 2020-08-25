class ok {
    static int s = 100;
}
public class testZero {
    public static void main(String[] args) {
        new ok().s = 4;
        ok.s ++;
        System.out.println(new ok().s);
    }
}