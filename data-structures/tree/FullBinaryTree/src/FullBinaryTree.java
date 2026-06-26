/**
 * A linear-to-hierarchical data structure used to check if a binary tree 
 * qualifies as a Full Binary Tree (also known as a proper or strict binary tree).
 * A binary tree is full if and only if every node has either 0 or 2 children.
 *
 * @author M.Adebawojo
 * @version 1.0
 */
public class FullBinaryTree {

    /**
     * Nested static class representing an individual node within the binary tree.
     */
    static class Node {
        /** The integer data value stored in the node. */
        int data;
        /** Reference to the left child node. */
        Node leftChild;
        /** Reference to the right child node. */
        Node rightChild;

        /**
         * Constructs a new Node with a specified data value.
         * Both left and right child pointers are initialized to null.
         *
         * @param item The integer value to be stored in this node.
         */
        Node(int item){
            data = item;
            leftChild = rightChild = null;
        }
    }

    /** The root node of the binary tree. Initialized to null when the tree is empty. */
    Node root;

    /**
     * Recursively checks if the binary tree rooted at the given node is a Full Binary Tree.
     * A tree is full if every node has either zero children (leaf) or two children (internal node).
     *
     * @param node The node to check (typically the root node of the tree).
     * @return true if the tree structure obeys the full binary tree property; false otherwise.
     */
    boolean isFullBinaryTree(Node node){
        // Case 1: An empty tree is considered a full binary tree by default
        if(node == null)
            return true;

        // Case 2: If the node is a leaf node (0 children), it satisfies the property
        if(node.leftChild == null && node.rightChild == null)
            return true;

        // Case 3: If the node has exactly 2 children, recursively check both subtrees
        if(node.leftChild != null && node.rightChild != null)
            return isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild);

        // Case 4: The node has exactly 1 child, violating the full binary tree property
        return false;
    }
}