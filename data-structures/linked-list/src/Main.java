/**
 * Test runner class to validate the functionality of the various LinkedList operations
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   RUNNING LINKED LIST OPERATION TESTS    ");
        System.out.println("==========================================\n");

        LinkedList list = new LinkedList();

        // ---------------------------------------------------------
        // 1. TEST INSERTIONS
        // ---------------------------------------------------------
        System.out.println("--- Testing Insertions ---");

        // Test insertion at the beginning
        System.out.println("Inserting 20 and then 10 at the beginning...");
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.printList(); // Expected: 10->20->null

        // Test insertion at the end
        System.out.println("\nAppending 40 and 50 to the end...");
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.printList(); // Expected: 10->20->40->50->null

        // Test insertion after a specific Node reference
        System.out.println("\nInserting 15 directly after the head node (10)...");
        list.insertAfter(list.head, 15);
        list.printList(); // Expected: 10->15->20->40->50->null

        // Test insertion after a zero-based position index
        System.out.println("\nInserting 30 after position index 2 (node value 20)...");
        list.insertAfter(2, 30);
        list.printList(); // Expected: 10->15->20->30->40->50->null

        // Test insertion out of bounds safety handling
        System.out.println("\nAttempting to insert after an out-of-bounds position (index 10)...");
        list.insertAfter(10, 99); // Expected: "Position out of bounds" message

        // ---------------------------------------------------------
        // 2. TEST SEARCHING
        // ---------------------------------------------------------
        System.out.println("\n--- Testing Search ---");
        int searchKeySuccess = 30;
        int searchKeyFailure = 100;

        System.out.println("Searching for existing key (" + searchKeySuccess + "): "
                + list.search(list.head, searchKeySuccess)); // Expected: true

        System.out.println("Searching for non-existent key (" + searchKeyFailure + "): "
                + list.search(list.head, searchKeyFailure)); // Expected: false

        // ---------------------------------------------------------
        // 3. TEST DELETIONS & BOUNDARY CONDITIONS
        // ---------------------------------------------------------
        System.out.println("\n--- Testing Deletions ---");

        // Delete a middle node
        System.out.println("Deleting node at position index 3 (value 30)...");
        list.deleteNode(3);
        list.printList(); // Expected: 10->15->20->40->50->null

        // Delete the head node (position 0)
        System.out.println("\nDeleting the head node at position index 0 (value 10)...");
        list.deleteNode(0);
        list.printList(); // Expected: 15->20->40->50->null

        // Attempting to delete an invalid out-of-bounds node
        System.out.println("\nAttempting to delete at an out-of-bounds index (index 8)...");
        list.deleteNode(8); // Expected: "Index Out of Bounds!!!" message

        // ---------------------------------------------------------
        // 4. TEST SORTING (BUBBLE SORT DATA SWAP)
        // ---------------------------------------------------------
        System.out.println("\n--- Testing Sorting ---");

        // Let's scramble the list structure first by adding un-ordered values
        System.out.println("Inserting unsorted elements: 99 at beginning, 5 at end...");
        list.insertAtBeginning(99);
        list.insertAtEnd(5);
        System.out.print("Current Unsorted List: ");
        list.printList(); // Expected: 99->15->20->40->50->5->null

        System.out.println("\nExecuting sortLinkedList()...");
        list.sortLinkedList(list.head);
        System.out.print("Sorted List Result:    ");
        list.printList(); // Expected: 5->15->20->40->50->99->null

        System.out.println("\n==========================================");
        System.out.println("         ALL TESTS COMPLETED              ");
        System.out.println("==========================================");
    }
}