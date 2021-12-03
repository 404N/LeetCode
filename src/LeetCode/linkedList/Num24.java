package LeetCode.linkedList;

import LeetCode.tree.ListNode;

public class Num24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode start = new ListNode();
        start.next = head;
        ListNode p = start;
        while (p.next != null && p.next.next != null) {
            ListNode m=p.next;
            ListNode q=m.next;
            p.next=q;
            m.next=q.next;
            q.next=m;
            p=m;
        }
        return start.next;
    }

    public static void main(String[] args) {
        Num24 num24 = new Num24();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3= new ListNode(5);
        head.next = node1;
        node1.next=node2;
        node2.next=node3;
        ListNode res=num24.swapPairs(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
