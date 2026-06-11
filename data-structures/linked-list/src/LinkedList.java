/**
 * A linear data structure composed of sequentially linked elements called nodes.
 * Each node encapsulates an integer data value and a reference to the succeeding node.
 * <p>
 * This class provides a basic implementation of a <b>Singly Linked List</b>,
 * supporting fundamental operations such as insertion, deletion, searching,
 * traversal, and data sorting.
 * </p>
 * @author M.Adebawojo
 * @version 1.0
 */
public class LinkedList {
    /** Pointer to the first node in the linked list. Will be {@code null} if the list is empty. */
    Node head;

    static class Node{
        /** The integer value stored in the node. */
        int data;
        /** Reference to the next node in the chain, or {@code null} if it is the terminal node. */
        Node next;

        /**
         * Constructs a new node with the specified data.
         * The next pointer is initialized to {@code null}.
         *
         * @param d The integer value to be stored inside this node.
         */
        Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    /**
     * Inserts a new node at the very beginning of the linked list.
     * The new node becomes the new head, pointing to the previous head node.
     *
     * @param newData The integer value to be stored in the new node.
     */
    void insertAtBeginning(int newData){
        Node newNode = new Node(newData);
        newNode.next = this.head;
        head = newNode;
    }

    // Use the first one if you are writing a low-level data structure library where performance matters.
    /**
     * Inserts a new node immediately following a specified reference node.
     * <p>
     * <i>Use case:</i> Ideal for low-level data structure components or internal manipulations
     * where direct node access is available and performance matters ($O(1)$ time complexity).
     * </p>
     *
     * @param prevNode The existing node after which the new node will be inserted.
     * @param newData  The integer value to be stored in the new node.
     */
    void insertAfter(Node prevNode, int newData){
        if(prevNode == null){
            System.out.println("Previous node is null");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Use this  if you are building an API where users interact with the list using indices, like a standard array.
    /**
     * Inserts a new node immediately after a specified index position relative to the head node.
     * <p>
     * <i>Use case:</i> Ideal for client-facing APIs where users interact with the list
     * using traditional 0-indexed positions similar to an array.
     * </p>
     *
     * @param position The zero-based index of the node after which the entry should be placed.
     * @param newData  The integer value to be stored in the new node.
     */
    void insertAfter(int position, int newData){
        if (this.head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node newNode = new Node(newData);

        Node current = this.head;

        for(int i = 0; i <  position; i++){
            if (current == null) { // Safety check for out-of-bounds
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }

        // Double check current is not null after loop
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        // swapping
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;

        // shorter version of the swapping
        // newNode.next = current.next;
//        current.next = newNode;
    }

    /**
     * Appends a new node to the terminal end (tail) of the linked list.
     * If the list is empty, this node becomes the head element.
     *
     * @param newData The integer value to be stored in the new node.
     */
    void insertAtEnd(int newData){
        Node newNode = new Node(newData);

        if(this.head == null){
            this.head = newNode;
            newNode.next = null;
            return;
        }

        Node current = this.head;

        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        newNode.next = null;
    }

    /**
     * Deletes the node located at the specified index position.
     * If the specified position falls outside the current bounds of the list,
     * the operation is safely aborted.
     *
     * @param position The zero-based index of the node to be removed.
     */
    void deleteNode(int position){
        if(this.head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        Node current = this.head;

        // Special Case: Removing the root element
        if(position == 0){
            this.head = current.next;
            return;
        }

        // Advance to the node right BEFORE the one we want to delete (position - 1)
        for(int i = 0; i < position; i++){
            if(current == null){
                System.out.println("Index Out of Bounds!!!");
                return;
            }
            current = current.next;
        }

        // Safety check to verify target node exists
        if(current == null || current.next == null){
            System.out.println("Index Out of Bounds!!!");
            return;
        }

        // Bypass the target node to decouple it from the chain
        current.next = current.next.next;
    }

    /**
     * Linearly searches the list for a target key value.
     *
     * @param head The starting node (typically the head) from which to begin searching.
     * @param key  The integer target value to locate.
     * @return {@code true} if the value is found within the list chain; {@code false} otherwise.
     */
    boolean search(Node head, int key){
        Node current = head;
        while(current != null){
            if(current.data == key){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Traverses the list and prints all data items sequentially from head to tail.
     * Outputs in the format: {@code value->value->null}.
     */
    void printList(){
        if(this.head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        Node current = this.head;

        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }

    /**
     * Sorts the linked list elements in ascending order using a Bubble Sort algorithm.
     * <p>
     * <b>Note:</b> This method only exchanges the internal node data structures ({@code data}).
     * The physical links and references connecting the {@link Node} objects remain completely unaltered.
     * </p>
     *
     * @param head The structural entry node of the list segment to be sorted.
     */
    void sortLinkedList(Node head) {
        Node current = head;
        Node index = null;
        int temp;

        if (current == null) {
            System.out.println("Empty LinkedList");
            return;
        }

        while (current != null) {
            // index here points to the node next to current
            index = current.next;

            while (index != null) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }

    }

}
