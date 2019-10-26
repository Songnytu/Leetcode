package leetcode1_100;
/*
* 二十一.合并两个有序链表
*
* 思路:不难,直接暴力
* */
import java.util.List;

public class leetcode21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode current1 = l1;ListNode current2 = l2;
        ListNode resultHead;
        if (l1.val<l2.val){
            resultHead = current1;
            current1 = current1.next;
        }else {
            resultHead = current2;
            current2 = current2.next;
        }
        ListNode current = resultHead;
        while (current1 !=null && current2 !=null){
            if (current1.val < current2.val){
                current.next = current1;
                current = current.next;
                current1 = current1.next;
            }else {
                current.next = current2;
                current = current.next;
                current2 = current2.next;
            }
        }
        if (current1==null){
            current.next = current2;
        }else {
            current.next = current1;
        }
        return resultHead;
    }
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(3);
        ListNode list3 = new ListNode(4);
        list1.next = list2;list2.next = list3;
        ListNode list4 = new ListNode(5);
        ListNode list5 = new ListNode(6);
        list4.next = list5;
        ListNode get = mergeTwoLists(list1,list4);
        while(get!=null){
            System.out.println(get.val+"->");
            get = get.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}