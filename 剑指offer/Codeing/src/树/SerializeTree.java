package 树;

import java.util.ArrayList;
import java.util.Collections;

/***********************************
 * 剑指offer：序列化二叉树
 * 题目描述：
 *      请实现两个函数，分别用来序列化和反序列化二叉树。具体略
 * 思路：序列化，先中后层序遍历，返序列化根据序列化使用方法反推
 *      1.在这里使用先序、中序加一起可以重建二叉树的方法重建的，有点麻烦
 *      2.实际只需要一种遍历二叉树方法，如先序，再重建过程与变量过程差不多，不用太麻烦
 *
 **********************************/

public class SerializeTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(12);
        t2.right = new TreeNode(25);

        TreeNode t3 = new TreeNode(522);
        t3.left = new TreeNode(36);
        t3.right = null;
        t1.left = t2;
        t1.right = t3;
        /*
        String s = Serialize(t1);
        System.out.println(s);

        TreeNode node = Deserialize(s);
        */
        StringBuffer sb = new StringBuffer();
        First(t1,sb);
        System.out.println(sb.toString());
        TreeNode node = Deserialize2(sb.toString());
        show(node);

    }

    public static String Serialize(TreeNode root) {
        if(root == null) return new String();

        StringBuffer sb = new StringBuffer();
        First(root,sb);
        Mid(root,sb);
        return sb.toString();

    }

    //先序序列化
    private static void First(TreeNode root, StringBuffer sb){
        if(root == null) {
            sb.append("#!");
            return ;
        }

        sb.append(root.val+"!");

        First(root.left,sb);
        First(root.right,sb);

    }
    //中序序列化
    private static void Mid(TreeNode root, StringBuffer sb){
        if(root == null) {
            sb.append("#!");
            return ;
        }

        Mid(root.left,sb);
        sb.append(root.val+"!");
        
        Mid(root.right,sb);

    }
    private static ArrayList<Integer> first = new ArrayList<>();
    private static ArrayList<Integer> mid = new ArrayList<>();

    //反序列化
    public static TreeNode Deserialize(String str) {
        if(str.length() == 0) return null;
        //根据！分割字符串
        String[] split = str.split("!");
        
        //将字符串分为先序与中序
        for (int i = 0; i < split.length; i++) {
            if(i < split.length/2){
                if(split[i].charAt(0)!='#') {

                    first.add(Integer.valueOf(split[i]));
                }
            }else {

                if(split[i].charAt(0)!='#') {

                    mid.add(Integer.valueOf(split[i]));
                }
            }
        }

        //重建二叉树
        TreeNode treeNode = RebuildTree(0, first.size() - 1, 0, mid.size() - 1);

        return treeNode;
    }

    //根据先序中序重建二叉树
    private static TreeNode RebuildTree(int firstS,int firstE,int midS,int midE){
        //.out.println(firstS + " " + firstE +" "+ midS +" "+ midE);
        if(midS>midE) return null;
        //读取第一个
        int fir = first.get(firstS);
        int index = midS;
        for (;index<=midE;index++){
            if(mid.get(index) == fir) break;
        }
        int len = index - midS;
        TreeNode root = new TreeNode(fir);
        root.left = RebuildTree(firstS+1,firstS+len,midS,index-1);
        root.right = RebuildTree(firstS+len+1,firstE,index+1,midE);
        return root;
    }

    private static void show(TreeNode root){
        if(root == null) {

            return ;
        }

        System.out.println(root.val);

        show(root.left);
        show(root.right);

    }
    /********************
     * 方法二：只根据先序序列就可重建，善用递归
     ********************/
    //根据先序序列字符反序列重建二叉树
    public static TreeNode Deserialize2(String str) {
        if(str.length() == 0) return null;
        //根据！分割字符串
        String[] split = str.split("!");
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0;i<split.length;i++){
            strings.add(split[i]);
        }
        return rebuild(strings);
    }

    //根据先序序列字符反序列重建二叉树
    private static TreeNode rebuild(ArrayList<String> strings){
        if(strings.size() == 0) return null;
        //#代表null，
        if(strings.get(0).charAt(0) == '#'){
            //移除当前值
            strings.remove(0);
            return null;
        }
        //每一次最顶上的即为当前节点值，然后返回给上一级
        TreeNode root = new TreeNode(Integer.valueOf(strings.get(0)));
        strings.remove(0);
        root.left = rebuild(strings);
        root.right = rebuild(strings);
        return root;
    }
}
