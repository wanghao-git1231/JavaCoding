package Medium.Case208;

import java.util.ArrayList;
import java.util.List;

/**********************************
 *  LeetCode Case:实现Trie（前缀树）
 *  题目描述：实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *  思路：
 *      1.前缀树应有的数据结构，一个类似多叉树，同时根据需要在加入其它属性和方法
 *      2.对于精确搜索，字符结尾标志位的设置
 *      3.其它看下面注释把
 *********************************/


public class Trie {
    //根据需要建立TreeNode类，自定义其属性，方法
    private class TreeNode {
        private Character val;
        //也可以使用数组加快长度26加快查找速度
        private List<TreeNode> children;
        //标记是否是字符的结尾
        private boolean isEnd = false;
        public TreeNode(Character val){
            this.val = val;
            this.children = new ArrayList<>();
        }

        //给当前节点加子节点
        public TreeNode add(Character c){

            this.children.add(new TreeNode(c));
            return this.children.get(this.children.size()-1);
        }
        //查询当前节点是否包含子节点val = c
        public TreeNode get(Character c){

            for (int i = 0;i < this.children.size();i++) {
                if (this.children.get(i).val == c) return this.children.get(i);
            }
            return null;

        }
    }
    //前缀树的头结点，数据值为null
    private TreeNode head = null;
    /** Initialize your data structure here. */
    public Trie() {
        head = new TreeNode(null);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode temp = head;
        insertHelp(temp,word,0);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode temp = head;
        return searchHelp(temp,word,0);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode temp = head;
        return startsWithhHelp(temp,prefix,0);
    }

    //字符串插入辅助函数
    private void insertHelp(TreeNode temp,String word,int index){

        //先判断该字符是否存在，不存在调用add，并递归
        TreeNode t = temp.get(word.charAt(index));
        if(t == null) temp = temp.add(word.charAt(index));
        else temp = t;
        //当全部字符串插入完毕后，设置标志位当前字符是某个字符串的结尾
        if(index == word.length()-1) {
            temp.isEnd = true;
            return;
        }
        insertHelp(temp,word,++index);
    }

    //字符串精确搜索辅助函数
    private boolean searchHelp(TreeNode temp,String word,int index){
        //匹配字符走到头
        if(index == word.length()){
            //判断该字符是不是一个已经存入的完整字符串
            if(temp.isEnd == true) return true;
            else return false;
        }
        //判断是否存在字符
        TreeNode t = temp.get(word.charAt(index));
        if(t == null) return false;
        return searchHelp(t,word,++index);

    }

    //字符串前缀查询辅助函数
    private boolean startsWithhHelp(TreeNode temp,String word,int index){
        //只要匹配字符串走到头就对了
        if(index == word.length()) return true;
        TreeNode t = temp.get(word.charAt(index));
        if(t == null) return false;
        return startsWithhHelp(t,word,++index);
    }
}
