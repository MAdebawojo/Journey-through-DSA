import java.util.ArrayList;

/**
 * Test runner class to validate the functionality and safety of the Max-Heap data structure.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== INITIALIZING EMPTY MAX-HEAP ===");
        Heap maxHeap = new Heap();
        ArrayList<Integer> heapList = new ArrayList<>();

        // 1. Test printing an empty heap
        System.out.print("Heap content (empty check): ");
        maxHeap.printArray(heapList); // Expected: No output/returns early
        System.out.println("[Empty]");

        System.out.println("\n=== TESTING INSERT OPERATIONS ===");
        System.out.println("Inserting: 10, 20, 15, 30, 40");
        maxHeap.insert(heapList, 10);
        maxHeap.insert(heapList, 20);
        maxHeap.insert(heapList, 15);
        maxHeap.insert(heapList, 30);
        maxHeap.insert(heapList, 40);

        System.out.println("\n=== TESTING DISPLAY AND PROPERTY ===");
        System.out.print("Current Max-Heap array representation: ");
        maxHeap.printArray(heapList);
        // Expected: Root must be the maximum value (40), followed by valid Max-Heap structure (e.g., 40 30 15 10 20)
        System.out.println();

        System.out.println("\n=== TESTING NODE DELETION ===");
        // Delete an element that exists (e.g., the root value 40)
        System.out.println("Attempting to delete root item (40)...");
        maxHeap.deleteNode(heapList, 40);

        System.out.print("Heap content after deleting 40: ");
        maxHeap.printArray(heapList);
        // Expected: Root should maintain the max property with remaining values (e.g., 30 20 15 10)
        System.out.println();

        // Delete a non-root element (e.g., 15)
        System.out.println("\nAttempting to delete a middle item (15)...");
        maxHeap.deleteNode(heapList, 15);

        System.out.print("Heap content after deleting 15: ");
        maxHeap.printArray(heapList); // Expected: Valid Max-Heap structure of [30, 20, 10]
        System.out.println();

        System.out.println("\n=== TESTING BUILD HEAP FUNCTIONALITY ===");
        System.out.println("Creating an un-ordered ArrayList...");
        ArrayList<Integer> randomList = new ArrayList<>();
        randomList.add(5);
        randomList.add(12);
        randomList.add(64);
        randomList.add(1);
        randomList.add(37);

        System.out.print("Unordered list before buildHeap: ");
        maxHeap.printArray(randomList);
        System.out.println();

        System.out.println("Invoking buildHeap()...");
        maxHeap.buildHeap(randomList);

        System.out.print("Transformed Max-Heap structure: ");
        maxHeap.printArray(randomList);
        // Expected: Root must be the maximum value (64) -> e.g., 64 37 5 1 12
        System.out.println();
    }
}