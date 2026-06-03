/**
 * A linear data structure that follows the First In, First Out (FIFO) principle.
 *
 * @author M.Adebawojo
 * @version 1.0
 */
public class Queue {
    /** The maximum capacity of the stack. */
    private int k;

    /** The index pointer of the first element in the queue. Initialized to -1 when empty. */
    private int front;

    /** The index pointer of the last element in the queue. Initialized to -1 when empty. */
    private int rear;

    /** The internal array holding the queue elements. */
    private int[] queue;

    /**
     * Constructs a new Queue with a specified maximum capacity.
     *
     * @param k The maximum number of elements this stack can hold.
     */
    public Queue(int k){
        this.k = k;
        this.queue = new int[k];
        this.front = this.rear = -1;
    }

    /**
     * Checks if the queue is full.
     *
     * @return true if the queue has reached its maximum capacity; false otherwise.
     */
    boolean isFull(){
        return this.rear == this.k - 1;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue contains no elements; false otherwise.
     */
    boolean isEmpty(){
        return this.front == -1 && this.rear == -1;
    }

    /**
     * Looks at the element at the front of this queue without removing it.
     * <p>
     * If the queue is empty, an error message is printed to the console
     * and the application terminates immediately.
     * </p>
     *
     * @return The integer element currently sitting at the front of the queue.
     */
    int peek(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            System.exit(1);
        }
        System.out.println("Front element is " + this.front);
        return this.queue[this.front];
    }

    /**
     * Inserts an integer item at the rear of this queue.
     * <p>
     * If the queue has reached its maximum capacity limit, an error message
     * is displayed and the application terminates immediately.
     * </p>
     *
     * @param num The integer value to be added to the back of the queue.
     */
    void enqueue(int num){
        if(isFull()){
            System.out.println("Queue is at its maximum capacity");
            System.exit(1);
        }
        if(front == -1){
            front = 0;
        }
        queue[++this.rear] = num;
    }

    /**
     * Removes and returns the element at the front of this queue.
     * <p>
     * If there are no elements left to remove, an error message is printed
     * and the application terminates immediately.
     * </p>
     *
     * @return The integer element that was removed from the front of the queue.
     */
    int dequeue(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            System.exit(1);
        }
        int element = this.queue[this.front];

        if(this.front == this.rear){
            this.front = -1;
            this.rear = -1;
        }
        else{
            this.front++;
        }
        return element;
    }

    /**
     * Prints all active elements currently inside the queue from front to rear.
     */
    void display(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return;
        }

        System.out.print("Queue content: ");
        for(int i = front; i < k; i++){
            System.out.print(this.queue[i] + " ");
        }
        System.out.println();
    }
}
