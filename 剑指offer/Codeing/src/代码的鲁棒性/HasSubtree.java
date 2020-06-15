package 代码的鲁棒性;

/************************
 * 剑指offer:树的子结构
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 ***********************/

public class HasSubtree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);

        TreeNode t3 = new TreeNode(2);
        t1.left = t3;

        t3.left =  new TreeNode(2);
        t3.right = new TreeNode(3);
        t1.right = new TreeNode(1);


        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        System.out.println(Subtree(t1,t2));
    }

    public static boolean Subtree(TreeNode root1,TreeNode root2) {

        if(root1 == null || root2 == null) return false; //判断输入是不是空

        return Sub(root1,root2);

    }

    public static boolean Sub(TreeNode root1,TreeNode root2){
        if(root2 == null) return true;  //都走到头，为true
        if(root1 == null&& root2!=null) return false;

        boolean res1,res2,res = false;
        //当根节点值相同时，比较左右子树
        if(root1.val == root2.val){
            res1 = Sub(root1.left, root2.left);

            res2 = Sub(root1.right, root2.right);

            if(res1 == true &&res2 == true) res =  true;
        }
        //1.当根节点值不相同时，分别比较左子树或右子树与子结构是否相同
        //2.当根节点相同，但左右子树不同时，分别比较左子树或右子树与子结构是否相同
        res1 =  Sub(root1.left,root2);
        if(res1 == true) res = true;  //如果左子树中相同，则直接返回
        res2 =  Sub(root1.right,root2);
        if(res2 == true) res =  true; //如果右子树中相同，则直接返回


        return res;
    }
}
