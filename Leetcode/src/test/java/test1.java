public class test1 {
    public static void main(String[] args){
        String str = "AbdaAfljekf";
        test(str);
    }
    public static void test(String str){
        String result="";
        int[] isDisplay = new int[512];
        char[] strs = str.toCharArray();
        for(int i = 0;i<strs.length;i++){
            if (isDisplay[(int)strs[i]]==0){
                isDisplay[(int)strs[i]] = 1;
                result+=strs[i];
            }
        }
        System.out.println(result);
    }
}