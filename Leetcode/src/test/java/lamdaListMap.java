import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// list<Map<String,Object>> 做差集

public class lamdaListMap {
    public static void main(String[] args) {
        String[] value1 = {"A","B","C","F"};
        String[] value2 = {"A","C","D","E","F"};
        List<Map<String,Object>> list1 = new ArrayList<>();
        List<Map<String,Object>> list2 = new ArrayList<>();
        Map<String,Object> map;
        for(String value : value1){
            map = new HashMap<>();
            map.put("zjhm",value);
            list1.add(map);
        }
        for(String value : value2){
            map = new HashMap<>();
            map.put("zjhm",value);
            list2.add(map);
        }

        List<Map<String, Object>> newList1 = list1.stream().filter(
                (mapItem) -> !list2.stream().map(item -> item.get("zjhm")
                ).collect(Collectors.toList()).contains(mapItem.get("zjhm"))
        ).collect(Collectors.toList());

        List<Map<String, Object>> newList2 = list2.stream().filter(
                (mapItem) -> !list1.stream().map(item -> item.get("zjhm")
                ).collect(Collectors.toList()).contains(mapItem.get("zjhm"))
        ).collect(Collectors.toList());

        newList1.addAll(newList2);

        System.out.printf(newList1.toString());
    }
}
