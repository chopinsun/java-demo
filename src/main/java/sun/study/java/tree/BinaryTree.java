package sun.study.java.tree;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 二叉树遍历
 * 先序、中序、后序的递归和非递归遍历
 * 树的构成： TreeNode组成的链式数据接口，treeNode包含current 和 left、right，left和right分别指向左子树和右子树的treenode
 * 遍历核心思想，把节点倒入栈，到达叶子节点后，再出栈，倒着找每一个节点的另外这一个子树
 */
public class BinaryTree {


    /**
     * 先序遍历，递归
     * @param root
     */
    public static void leftTraversalWithRecursive(TreeNode root){
        System.out.print(root.data+"->");
        if(root.lChild!=null ){
            leftTraversal(root.lChild);
        }
        if(root.rChild!=null){
            leftTraversal(root.rChild);
        }
    }

    /**
     * 先序遍历，无递归
     * @param root
     */
    public static void leftTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
       while (node!=null || !stack.isEmpty()){
           while (node != null) {
               System.out.print(node.data + "->");
               stack.push(node);
               node = node.lChild;
           }
           if(!stack.isEmpty()){
               node = stack.pop();
               node = node.rChild;
           }
       }
    }




    public static class TreeNode<T>{
        private T data;
        private TreeNode<T> lChild;
        private TreeNode<T> rChild;

        public TreeNode() {
        }

        public TreeNode(T data) {
            this.data = data;
        }

        public TreeNode(T data, TreeNode<T> lChild, TreeNode<T> rChild) {
            this.data = data;
            this.lChild = lChild;
            this.rChild = rChild;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public TreeNode<T> getlChild() {
            return lChild;
        }

        public void setlChild(TreeNode<T> lChild) {
            this.lChild = lChild;
        }

        public TreeNode<T> getrChild() {
            return rChild;
        }

        public void setrChild(TreeNode<T> rChild) {
            this.rChild = rChild;
        }
    }
}
