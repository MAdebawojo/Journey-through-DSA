/**
 * A non-linear data structure representing a Binary Tree where each node 
 * can have at most two children, referred to as the left and right child.
 * This class provides depth-first traversal algorithms (Preorder, Inorder, Postorder).
 *
 * @author M.Adebawojo
 * @version 1.0
 */
public class BinaryTree {

    /**
     * Nested static class representing an individual node within the binary tree.
     */
    static class Node {
        /** The integer data value stored in the node. */
        int item;
        /** Reference to the left child node. */
        Node left;
        /** Reference to the right child node. */
        Node right;

        /**
         * Constructs a new Node with a specified key value.
         * Both left and right child pointers are initialized to null.
         *
         * @param key The integer value to be stored in this node.
         */
        public Node(int key){
            item = key;
            left = right = null;
        }
    }

    /** The root node of the binary tree. Initialized to null when the tree is empty. */
    Node root;

    /**
     * Constructs an empty Binary Tree.
     */
    BinaryTree(){
        root = null;
    }

    /**
     * Traverses the binary tree using the Postorder algorithm (Left, Right, Root).
     * * @param node The starting node for the traversal (typically the root).
     */
    void postorder(Node node){
        if(node == null)
            return;

        // Traverse left subtree
        postorder(node.left);

        // Traverse right subtree
        postorder(node.right);

        // Visit the Root node
        System.out.println(node.item + "->");
    }

    /**
     * Traverses the binary tree using the Inorder algorithm (Left, Root, Right).
     * For a Binary Search Tree (BST), this traversal visits nodes in ascending order.
     * * @param node The starting node for the traversal (typically the root).
     */
    void inorder(Node node){
        if(node == null)
            return;

        // Traverse left subtree
        inorder(node.left);

        // Visit the Root node
        System.out.println(node.item + "->");

        // Traverse right subtree
        inorder(node.right);
    }

    /**
     * Traverses the binary tree using the Preorder algorithm (Root, Left, Right).
     * Commonly used to create a copy of the tree structure.
     * * @param node The starting node for the traversal (typically the root).
     */
    void preorder(Node node){
        if(node == null)
            return;

        // Visit the Root node
        System.out.println(node.item + "->");

        // Traverse left subtree
        preorder(node.left);

        // Traverse right subtree
        preorder(node.right);
    }
}