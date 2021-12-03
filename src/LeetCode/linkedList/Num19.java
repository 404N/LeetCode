package LeetCode.linkedList;

import LeetCode.tree.ListNode;

public class Num19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<=0){
            return head;
        }
        ListNode p=head;
        ListNode q=head.next;
        ListNode tools=head;
        int cnt=0;
        while(cnt<n&&tools.next!=null){
            cnt++;
            tools=tools.next;
        }
        if(cnt<n){
            return head.next;
        }
        while(tools.next!=null){
            tools=tools.next;
            p=q;
            q=q.next;
        }
        if(q!=null){
            p.next=q.next;
        }else{
            head=null;
        }
        return head;
    }

    public static void main(String[] args) {
        Num19 num19=new Num19();
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(5);
//        head.next=node1;
//        node1.next=node2;
        head=num19.removeNthFromEnd(head,1);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
