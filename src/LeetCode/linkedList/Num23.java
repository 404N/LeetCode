package LeetCode.linkedList;

import LeetCode.tree.ListNode;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Num23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=null;
        ListNode mark=null;
        boolean flag=true;
        while(flag){
            flag=false;
            int tempIdx=-1;
            int tempVal=0;
            int cnt=0;
            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null){
                    cnt++;
                    if(tempIdx==-1){
                        tempIdx=i;
                        tempVal=lists[i].val;
                    }
                    flag=true;
                    if(lists[i].val<tempVal){
                        tempVal=lists[i].val;
                        tempIdx=i;
                    }
                }
            }
            if(flag){
                if(res==null){
                    res=lists[tempIdx];
                    mark=res;
                }else{
                    mark.next=lists[tempIdx];
                    mark=mark.next;
                }
                lists[tempIdx]=lists[tempIdx].next;
            }
            if(cnt==1){
                break;
            }
        }
        return res;
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

    public static void main(String[] args) {
        Num23 num23=new Num23();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(4);
        ListNode node3=new ListNode(5);
        node1.next=node2;
        node2.next=node3;

        ListNode node21=new ListNode(1);
        ListNode node22=new ListNode(3);
        ListNode node23=new ListNode(4);
        node21.next=node22;
        node22.next=node23;

        ListNode node31=new ListNode(2);
        ListNode node32=new ListNode(6);
        node31.next=node32;

        ListNode[] listNodes={node1,node21,node31};

        ListNode res=num23.mergeKLists(listNodes);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }

    }
}
