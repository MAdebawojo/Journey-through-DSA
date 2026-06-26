import java.util.ArrayList;

/**
 * A complete binary tree data structure that follows the Max-Heap property,
 * where the parent node is always greater than or equal to its children.
 *
 * @author M.Adebawojo
 * @version 1.0
 */
public class Heap {

    /**
     * Maintains the max-heap property for a subtree rooted at the given index.
     * Assumes that the binary trees rooted at the left and right children are already max-heaps.
     *
     * @param hT The ArrayList representing the heap.
     * @param i  The index of the root node of the subtree to be heapified.
     */
    void heapify(ArrayList<Integer> hT, int i){
        int size = hT.size();
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < size && hT.get(left) > hT.get(largest)){
            largest = left;
        }
        if(right < size && hT.get(right) > hT.get(largest)){
            largest = right;
        }
        if(largest != i){
            int temp = hT.get(i);
            hT.set(i, hT.get(largest));
            hT.set(largest, temp);

            // Recursively heapify the affected sub-tree
            heapify(hT, largest);
        }
    }

    /**
     * Inserts a new element into the heap and restores the max-heap property.
     *
     * @param hT     The ArrayList representing the heap.
     * @param newNum The integer value to be inserted.
     */
    void insert(ArrayList<Integer> hT, int newNum){
        int size = hT.size();
        if(size == 0){
            hT.add(newNum);
        }
        else{
            hT.add(newNum);
            // Re-build the heap from the last non-leaf node up to the root
            for(int i = (size / 2) - 1; i >= 0; i--){
                heapify(hT, i);
            }
        }
    }

    /**
     * Deletes the first occurrence of a specific value from the heap,
     * replaces it with the last element, and rebuilds the max-heap.
     *
     * @param hT  The ArrayList representing the heap.
     * @param num The integer value to be removed.
     */
    void deleteNode(ArrayList<Integer> hT, int num){
        int size = hT.size();
        int i;
        // Search for the element to delete
        for(i = 0; i < size; i++){
            if(num == hT.get(i)){
                break;
            }
        }
        // If the element was found in the heap
        if(i < size){
            int temp = hT.get(size - 1);
            hT.set(size - 1, hT.get(i));
            hT.set(i, temp);

            hT.remove(size - 1); // Remove the element now positioned at the end
            buildHeap(hT);       // Re-establish heap invariants across the entire array
        }
    }

    /**
     * Prints all the elements currently in the heap in array-representation order.
     *
     * @param hT The ArrayList representing the heap to print.
     */
    void printArray(ArrayList<Integer> hT){
        int size = hT.size();
        if(size == 0){
            return;
        }
        for(int item : hT){
            System.out.print(item + " ");
        }
    }

    /**
     * Converts an unordered ArrayList into a valid max-heap by running
     * heapify on all non-leaf nodes in bottom-up order.
     *
     * @param hT The ArrayList to be transformed into a max-heap.
     */
    void buildHeap(ArrayList<Integer> hT){
        int size = hT.size();
        // Index (size / 2) - 1 represents the last internal (non-leaf) node
        for(int i = (size / 2) - 1; i >= 0; i--){
            heapify(hT, i);
        }
    }
}