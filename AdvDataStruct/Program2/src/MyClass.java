import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;	
    Node parent;
    /**
     * Creates a node with a key pointer that points to the given data, while 
     * left, right and parent pointers point to null.
     * @param data 
     */
	public Node(int data){
            key = data;
            left = null;
            right = null;
            parent = null;
        }
        /**
         * Creates a node with a key, left, right and parent pointers that 
         * point to the respective given value.
         * @param data
         * @param l
         * @param r
         * @param p 
         */
        public Node(int data, Node l, Node r, Node p){
            key = data;
            left = l;
            right = r;
            parent = p;
        }
}


class BST {
    /**
     * Root of the binary search tree.
     */
    public Node root;
    /**
     * Creates an empty binary search tree with a root of null. 
     */
    public BST(){
        root = null;
    }
    /**
     * This method finds the Node that the give value is or should be.
     * @param k
     * @return 
     */
    public Node search(int k){
       Node v = root;
       while(v.key != k){
           if (v.key > k){
               v = v.left;
           }
           else{
               v = v.right;
           }
       }
       return v;
    }
    /**
     * This method inserts the given value into the tree that the 
     * method was called on.
     * Values less than or equal to the root are store in the left subtree.
     * Values greater than the root are stored in the right subtree.
     * @param key 
     */
	public void insert(int key){
        if (root == null){
            root = new Node (key, null, null, null);
            return;
        }
        Node cur = root;
        Node p;
        while(true){
            p = cur;
            if ( key <= cur.key){
                cur = cur.left;
                if (cur == null){
                    p.left = new Node (key, null, null, p);
                    return;
                }
            }
            else{
                cur = cur.right;
                if (cur == null){
                    p.right = new Node (key, null, null, p);
                    return;
                }
            }
        }
    }
    /**
     * This method removes the node containing the given value from the tree.
     * @param k
     * @return 
     */
    public boolean remove(int k){
        Node cur = search(k);
        if (cur == null)
            return false;
        else if(cur.left == null && cur.right == null){
            if (cur == root)
                root = null;
            else if(cur.parent.left == cur)
                cur.parent.left = null;
            else
                cur.parent.right = null;
        }
        else if (cur.left != null && cur.right != null){
            Node s = successor(cur);
            Node p = cur.parent;
            if (cur == root)
                root = s;
            else
                replace(cur, s);
            s.left = cur.left;
        }
        else if(cur.right == null){
            if (cur == root)
                root = cur.left;
            else 
                replace(cur, cur.left);
        }
        else if(cur.left == null){
            if(cur == root){
		root = cur.right;
            }
            else
               replace(cur, cur.right);
                
        }
        return true;
    }
    /**
     * Replaces the first given node with the second node.
     * @param s
     * @param t 
     */
    private void replace(Node s, Node t){
        if (s.parent.left == s)
            s.parent.left = t;
        else
            s.parent.right = t;
        t.parent = s.parent;
    }
    /**
     * Finds the successor of the given node.
     * The successor is the smallest value in the right subtree of the given node.
     * @param v
     * @return 
     */
    private Node successor(Node v){
        Node s = null;
        Node p = null;
        Node cur = v.right;
        while(cur != null){
            p = s;
            s = cur;
            cur = cur.left;
        }
        if (s != v.right){
            p.left = s.right;
            s.right = v.right;
        }
        return s;
    }
    /**
     * Prints the tree in level by level order starting from the root. 
     * @param u
     */
    public void printLevelOrder(Node u) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(u);
        while (!q.isEmpty()) {
            int levelSize = q.size(); //size of the current level on tree
            for (int i = 0; i < levelSize; i++) {
                Node node = q.remove();
                System.out.print(node.key + " ");
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }    
            System.out.println();
        }
        System.out.println();
    }
    /**
     * Prints the tree in in-order starting from the root. 
     * @param u
     */
    public void printInOrder(Node u) {
        if (u.left != null) {
            printInOrder(u.left);
        }
        System.out.printf("%d ", u.key);
        if (u.right != null) {
            printInOrder(u.right);
        }
    }

}




public class MyClass{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BST tree = new BST();
        while (input.hasNextLine()) {
            String s = input.nextLine();
            if (s.isEmpty()) {
                break;
            }
            String[] p = s.split("\\s+");
            String p0 = p[0]; // insert or delete
            int p1 = Integer.parseInt(p[1]); // integer
            if (p0.equals("insert")) {
                tree.insert(p1);
            } else if (p0.equals("delete")) {
                tree.remove(p1);
            }
        }
        tree.printLevelOrder(tree.root);
        tree.printInOrder(tree.root);
        input.close();
    }

}
