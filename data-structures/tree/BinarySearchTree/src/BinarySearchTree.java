/**
 * A hierarchical data structure that implements a Binary Search Tree (BST).
 * A binary tree qualifies as a BST if for every node, all keys in its left
 * subtree are strictly less than its own key, and all keys in its right
 * subtree are strictly greater than its own key. This implementation
 * behaves like a set and discards duplicate values.
 *
 * @author M.Adebawojo
 * @version 1.0
 */
public class BinarySearchTree {

    /**
     * Nested class representing an individual node within the binary search tree.
     */
    class Node {
        /** The integer data value used as the key for sorting the tree. */
        int key;
        /** Reference to the left child node containing smaller keys. */
        Node left;
        /** Reference to the right child node containing larger keys. */
        Node right;

        /**
         * Constructs a new Node with a specified key value.
         *
         * @param item The integer value to be stored in this node.
         */
        public Node(int item){
            key = item;
        }
    }

    /** The root node of the binary search tree. Initialized to null when empty. */
    Node root;

    /**
     * Constructs an empty Binary Search Tree.
     */
    BinarySearchTree(){
        root = null;
    }

    /**
     * Inserts a new key into the binary search tree.
     * This is a wrapper method that initiates recursion from the root node.
     *
     * @param key The integer value to be inserted.
     */
    void insert(int key){
        root = insertKey(root, key);
    }

    /**
     * Recursively traverses the tree to insert a key at its correct structural position.
     *
     * @param root The current node being evaluated in the traversal path.
     * @param key The integer value to insert into the tree.
     * @return The updated node reference after insertion.
     */
    Node insertKey(Node root, int key){
        // Case 1: If the subtree is empty, create and return the new node
        if (root == null){
            root = new Node(key);
            return root;
        }

        // Case 2: Traverse down the left subtree if the key is smaller
        if(key < root.key){
            root.left = insertKey(root.left, key);
        }

        // Case 3: Traverse down the right subtree if the key is larger
        else if(key > root.key){
            root.right = insertKey(root.right, key);
        }

        // Case 4: Duplicate found (key == root.key). Node is returned unmodified.
        return root;
    }

    /**
     * Performs an in-order traversal of the tree, printing keys to the console.
     * The traversal processes the left subtree, visits the root, and then
     * processes the right subtree, resulting in sorted ascending output.
     *
     * @param root The starting node for the traversal.
     */
    void inorderRec(Node root){
        if(root == null)
            return;

        inorderRec(root.left);
        System.out.print(root.key + "->");
        inorderRec(root.right);
    }

    /**
     * Deletes a target key from the binary search tree.
     * This is a wrapper method that initiates recursion from the root node.
     *
     * @param key The integer value to be removed from the tree.
     */
    void deleteKey(int key){
        root = deleteRec(root, key);
    }

    /**
     * Recursively searches for and removes a target key from the tree,
     * maintaining the BST properties during structural updates.
     *
     * @param root The current node being evaluated in the search path.
     * @param key The integer value to be removed.
     * @return The updated node reference after the deletion process concludes.
     */
    Node deleteRec(Node root, int key) {
        // Case 1: The key does not exist in the tree
        if(root == null)
            return root;

        // Case 2: Target key is smaller than current node's key; look left
        if(key < root.key){
            root.left = deleteRec(root.left, key);
        }

        // Case 3: Target key is larger than current node's key; look right
        else if(key > root.key){
            root.right = deleteRec(root.right, key);
        }

        // Case 4: Target key matches current node's key (key == root.key)
        else {
            // Subcase A: Node has 0 children (leaf) or only a right child
            if(root.left == null)
                return root.right;

                // Subcase B: Node has only a left child
            else if(root.right == null)
                return root.left;

            // Subcase C: Node has 2 children. Find the inorder successor (smallest in right subtree)
            root.key = minValue(root.right);

            // Delete the old duplicate inorder successor node from the right subtree
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    /**
     * Finds the minimum key value within a given subtree.ff
     * It iteratively traverses down to the leftmost leaf node.
     *
     * @param root The root node of the subtree to search.
     * @return The minimum integer key value found in the subtree.
     */
    int minValue(Node root){
        int minVal = root.key;
        while(root.left != null){
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }

    /**
     * Finds the maximum key value within a given subtree.
     * It iteratively traverses down to the rightmost leaf node.
     *
     * @param root The root node of the subtree to search.
     * @return The maximum integer key value found in the subtree.
     */
    int maxVal(Node root){
        int maxVal = root.key;
        while(root.right != null){
            maxVal = root.right.key;
            root = root.right;
        }
        return maxVal;
    }
}
