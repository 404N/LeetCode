package LeetCode.tree;

public class Num116 {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        levelOrder(root,null,false);
        return root;
    }

    public void levelOrder(Node root,Node parent,boolean direction){
        if(parent==null){
            root.next=null;
        }else{
            if(direction){
                if(parent.next!=null){
                    root.next=parent.next.left;
                }else{
                    root.next=null;
                }
            }else{
                root.next=parent.right;
            }
        }
        if(root.left!=null){
            levelOrder(root.left,root,false);
        }
        if(root.right!=null){
            levelOrder(root.right,root,true);
        }
    }


    public static void main(String[] args) {
        Node root=new Node(1);
        Node root1=new Node(2);
        Node root2=new Node(3);
        Node root3=new Node(4);
        Node root4=new Node(5);
        Node root5=new Node(6);
        Node root6=new Node(7);
        root.left=root1;
        root.right=root2;
        root1.left=root3;
        root1.right=root4;
        root2.left=root5;
        root2.right=root6;
        Num116 num116=new Num116();
        num116.connect(root);
    }
}
