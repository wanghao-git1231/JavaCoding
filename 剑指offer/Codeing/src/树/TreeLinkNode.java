package 树;

public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;  //指向父结点

    TreeLinkNode(int val) {
        this.val = val;
    }
}
