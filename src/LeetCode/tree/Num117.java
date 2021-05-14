package LeetCode.tree;

public class Num117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        levelOrder(root, null, false);
        return root;
    }

    public void levelOrder(Node root, Node parent, boolean direction) {
        System.out.println(root.val);
        if (parent == null) {
            root.next = null;
        } else {
            if (direction) {
                Node node=parent.next;
                if(node==null){
                    root.next=null;
                }else{
                    while(node.left == null && node.right == null){
                        if(node.next!=null){
                            node=node.next;
                        }else{
                            break;
                        }
                    }
                    if (node.left != null) {
                        root.next = node.left;
                    } else if (node.right != null) {
                        root.next = node.right;
                    }else{
                        root.next=null;
                    }
                }

            } else {
                if (parent.right != null) {
                    root.next = parent.right;
                } else {
                    Node node=parent.next;
                    if(node==null){
                        root.next=null;
                    }else{
                        while(node.left == null && node.right == null){
                            if(node.next!=null){
                                node=node.next;
                            }else{
                                break;
                            }
                        }
                        if (node.left != null) {
                            root.next = node.left;
                        } else if (node.right != null) {
                            root.next = node.right;
                        } else {
                            root.next = null;
                        }
                    }

                }
            }
        }
        if (root.right != null) {
            levelOrder(root.right, root, true);
        }
        if (root.left != null) {
            levelOrder(root.left, root, false);
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        Node root1 = new Node(2);
        Node root2 = new Node(3);
        Node root3 = new Node(4);
        Node root4 = new Node(5);
        Node root5 = new Node(6);
        Node root6 = new Node(7);
        Node root7 = new Node(8);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root3.left=root6;
        root2.right=root5;
        root5.right=root7;
        Num117 num116 = new Num117();
        num116.connect(root);
    }
}

//       1
//    2     3
//  4   5      6
// 7              8