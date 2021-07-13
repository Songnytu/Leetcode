import java.util.HashMap;

public class Kingmanhonor {
    public static void main(String[] args) {
//        String []strs = {"曾维碟","许锦鹏","张文宇"};
//        int max=strs.length+1,min=1;
//        long randomNum = System.currentTimeMillis();
//        int ran3 = (int) (randomNum%(max-min)+min);
//
//        System.out.println(strs[ran3-1]);
        HashMap<String,Object> map = new HashMap<>();
        map.put("zt",1);
        if(0==Integer.valueOf(map.get("zt").toString())) {

        }else {
            System.out.println("报错");
        }
    }
}
