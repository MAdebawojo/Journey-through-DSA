/**
 * Test runner class to validate the insertion, traversal, and deletion algorithms
 * of the BinarySearchTree data structure.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== INITIALIZING BINARY SEARCH TREE ===");
        BinarySearchTree bst = new BinarySearchTree();

        /*
         * We will construct the BST by inserting keys sequentially.
         * The structure will automatically balance out as follows:
         *        50
         *       /  \
         *     30    70
         *    /  \   /  \
         *   20  40 60  80
         *
         */
        System.out.println("Inserting elements: 50, 30, 20, 40, 70, 60, 80");
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("\n=== TESTING INORDER TRAVERSAL (SORTED CHECK) ===");
        System.out.println("Expected Order: 20->30->40->50->60->70->80->");
        System.out.print("Actual Output:  ");
        bst.inorderRec(bst.root);
        System.out.println();

        System.out.println("\n=== TESTING EXTRAMA VALUE UTILITIES ===");
        System.out.println("Expected Minimum: 20 | Actual: " + bst.minValue(bst.root));
        System.out.println("Expected Maximum: 80 | Actual: " + bst.maxVal(bst.root));

        System.out.println("\n=== TESTING DUPLICATE INSERTION (SET BEHAVIOR) ===");
        System.out.println("Attempting to insert existing key 30...");
        bst.insert(30);
        System.out.println("Expected Order: 20->30->40->50->60->70->80-> (No duplicate nodes)");
        System.out.print("Actual Output:  ");
        bst.inorderRec(bst.root);
        System.out.println();

        System.out.println("\n=== TESTING NODE DELETION: CASE 1 (LEAF NODE) ===");
        System.out.println("Deleting leaf node 20...");
        bst.deleteKey(20);
        System.out.println("Expected Order: 30->40->50->60->70->80->");
        System.out.print("Actual Output:  ");
        bst.inorderRec(bst.root);
        System.out.println();

        System.out.println("\n=== TESTING NODE DELETION: CASE 2 (SINGLE CHILD) ===");
        System.out.println("Deleting node 30 (which now only has right child 40)...");
        bst.deleteKey(30);
        System.out.println("Expected Order: 40->50->60->70->80->");
        System.out.print("Actual Output:  ");
        bst.inorderRec(bst.root);
        System.out.println();

        System.out.println("\n=== TESTING NODE DELETION: CASE 3 (TWO CHILDREN) ===");
        System.out.println("Deleting root node 50 (will be replaced by inorder successor 60)...");
        bst.deleteKey(50);
        System.out.println("Expected Order: 40->60->70->80->");
        System.out.print("Actual Output:  ");
        bst.inorderRec(bst.root);
        System.out.println();

        System.out.println("\n=== TESTING EDGE CASE: DELETING NON-EXISTENT KEY ===");
        System.out.println("Attempting to delete key 99 (Tree structure should remain unchanged)...");
        bst.deleteKey(99);
        System.out.println("Expected Order: 40->60->70->80->");
        System.out.print("Actual Output:  ");
        bst.inorderRec(bst.root);
        System.out.println();

        System.out.println("\n=== TESTING EDGE CASE: EMPTY TREE ===");
        BinarySearchTree emptyTree = new BinarySearchTree();
        System.out.println("Attempting to traverse an empty tree (Should exit safely with no output):");
        System.out.print("Inorder: ");
        emptyTree.inorderRec(emptyTree.root);
        System.out.println("[Done]");
    }
}