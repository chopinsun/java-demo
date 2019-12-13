package sun.study.java;

import sun.study.java.tree.BinaryTree;

public class TreeTest {

    public static void main(String[] args) {
        BinaryTree.TreeNode<Integer> root= new BinaryTree.TreeNode<Integer>(1);
        BinaryTree.TreeNode<Integer> l1= new BinaryTree.TreeNode<Integer>(2);
        BinaryTree.TreeNode<Integer> r1= new BinaryTree.TreeNode<Integer>(3);
        BinaryTree.TreeNode<Integer> ll2= new BinaryTree.TreeNode<Integer>(4);
        BinaryTree.TreeNode<Integer> rr2= new BinaryTree.TreeNode<Integer>(5);
        BinaryTree.TreeNode<Integer> llr3= new BinaryTree.TreeNode<Integer>(6);
        BinaryTree.TreeNode<Integer> llrl4= new BinaryTree.TreeNode<Integer>(7);
        BinaryTree.TreeNode<Integer> llrr4= new BinaryTree.TreeNode<Integer>(8);


        root.setlChild(l1);
        root.setrChild(r1);
        l1.setlChild(ll2);
        r1.setlChild(rr2);
        ll2.setrChild(llr3);
        llr3.setlChild(llrl4);
        llr3.setrChild(llrr4);

        BinaryTree.leftTraversal(root);

    }


}
