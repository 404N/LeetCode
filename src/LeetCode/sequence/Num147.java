package LeetCode.sequence;

import LeetCode.tree.ListNode;

public class Num147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode p=head;
        ListNode q=head.next;
        while(q!=null){
            ListNode tempP=p;
            ListNode tempQ=q;
            if(tempQ.val<tempP.val){
                ListNode temp=head;
                while(true){
                    if(temp.next.val<tempQ.val){
                        temp=temp.next;
                    }else{
                        break;
                    }
                }
                if(temp==head){
                    tempP.next=tempQ.next;
                    tempQ.next=head;
                    head=tempQ;
                }else {
                    tempP.next=tempQ.next;
                    tempQ.next=temp.next;
                    temp.next=tempQ;
                }
            }
            p=q;
            q=q.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(5);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(7);
        node.next=node2;
        node2.next=node3;
        node3.next=node4;
        Num147 num147=new Num147();
        ListNode a=num147.insertionSortList(node);
        while(a!=null){
            System.out.println(a.val);
            a=a.next;
        }
    }
}
