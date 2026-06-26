
public class Main{
    public static void main(String args[]) {
        FullBinaryTree tree = new FullBinaryTree();
        tree.root = new FullBinaryTree.Node(1);
        tree.root.leftChild = new FullBinaryTree.Node(2);
        tree.root.rightChild = new FullBinaryTree.Node(3);
        tree.root.leftChild.leftChild = new FullBinaryTree.Node(4);
        tree.root.leftChild.rightChild = new FullBinaryTree.Node(5);
        tree.root.rightChild.leftChild = new FullBinaryTree.Node(6);
        tree.root.rightChild.rightChild = new FullBinaryTree.Node(7);

        if (tree.isFullBinaryTree(tree.root))
            System.out.print("The tree is a full binary tree");
        else
            System.out.print("The tree is not a full binary tree");
    }
}
