package LeetCode.sequence;

import LeetCode.tree.ListNode;

import java.util.List;

public class Num148 {
    public ListNode sortList(ListNode head) {
        int len=0;
        ListNode h=head;
        while(h!=null){
            len++;
            h=h.next;
        }
        ListNode res=new ListNode(0);
        res.next=head;
        for(int listLen=1;listLen<len;listLen<<=1){
            ListNode p=res;
            ListNode curr=res.next;
            while(curr!=null){
                ListNode head1=curr;
                for(int i=1;i<listLen&&curr.next!=null;i++){
                    curr=curr.next;
                }
                ListNode head2=curr.next;
                curr.next=null;
                curr=head2;
                for(int i=1;i<listLen&&curr!=null&&curr.next!=null;i++){
                    curr=curr.next;
                }
                ListNode temp=null;
                if (curr!=null){
                    temp=curr.next;
                    curr.next=null;
                }
                ListNode sort=mergeTwoLists(head1,head2);
                p.next=sort;
                while(p.next!=null){
                    p=p.next;
                }
                curr=temp;
            }

        }
        return res.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode node=head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                node.next=l1;
                l1=l1.next;
            }else{
                node.next=l2;
                l2=l2.next;
            }
            node=node.next;
        }
        if(l1==null){
            node.next=l2;
        }else{
            node.next=l1;
        }
        return head.next;
    }
}
