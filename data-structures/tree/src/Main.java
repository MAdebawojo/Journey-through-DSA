/**
 * Test runner class to validate the traversal algorithms of the BinaryTree data structure.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== INITIALIZING BINARY TREE ===");
        BinaryTree tree = new BinaryTree();

        /*
         * We will manually construct the following binary tree structure:
         * * 1
         * / \
         * 2   3
         * / \
         * 4   5
         */
        tree.root = new BinaryTree.Node(1);
        tree.root.left = new BinaryTree.Node(2);
        tree.root.right = new BinaryTree.Node(3);
        tree.root.left.left = new BinaryTree.Node(4);
        tree.root.left.right = new BinaryTree.Node(5);

        System.out.println("\n=== TESTING PREORDER TRAVERSAL ===");
        System.out.println("Expected Order: Root -> Left -> Right (1 -> 2 -> 4 -> 5 -> 3)");
        System.out.println("Actual Output:");
        tree.preorder(tree.root);

        System.out.println("\n=== TESTING INORDER TRAVERSAL ===");
        System.out.println("Expected Order: Left -> Root -> Right (4 -> 2 -> 5 -> 1 -> 3)");
        System.out.println("Actual Output:");
        tree.inorder(tree.root);

        System.out.println("\n=== TESTING POSTORDER TRAVERSAL ===");
        System.out.println("Expected Order: Left -> Right -> Root (4 -> 5 -> 2 -> 3 -> 1)");
        System.out.println("Actual Output:");
        tree.postorder(tree.root);

        System.out.println("\n=== TESTING EDGE CASE: EMPTY TREE ===");
        BinaryTree emptyTree = new BinaryTree();
        System.out.println("Attempting to traverse an empty tree (Should return safely with no output):");
        System.out.print("Inorder: ");
        emptyTree.inorder(emptyTree.root);
        System.out.println("[Done]");
    }
}