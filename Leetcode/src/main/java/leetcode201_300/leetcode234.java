package leetcode201_300;
/*
* 二百三十四.回文链表
*
* */
public class leetcode234 {
   public boolean test(ListNode head){
       if(head == null || head.next == null) return true;
       ListNode slow = head, fast = head.next, pre = null, prepre = null;
       while(fast != null && fast.next != null) {
           //反转前半段链表
           pre = slow;
           slow = slow.next;
           fast = fast.next.next;
           //先移动指针再来反转
           pre.next = prepre;
           prepre = pre;
       }
       ListNode p2 = slow.next;
       slow.next = pre;
       ListNode p1 = fast == null? slow.next : slow;
       while(p1 != null) {
           if(p1.val != p2.val)
               return false;
           p1 = p1.next;
           p2 = p2.next;
       }
       return true;
   }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}