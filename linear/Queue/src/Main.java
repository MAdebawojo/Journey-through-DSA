/**
 * Test runner class to validate the functionality of the array-based Queue.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== INITIALIZING QUEUE OF CAPACITY 3 ===");
        Queue myQueue = new Queue(3);

        // 1. Test initial empty state
        System.out.println("Is queue empty? " + myQueue.isEmpty()); // Expected: true
        System.out.println("Is queue full? " + myQueue.isFull());   // Expected: false

        System.out.println("\n=== TESTING ENQUEUE OPERATIONS ===");
        System.out.println("Adding elements: 10, 20, 30");
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);

        // 2. Test filled state
        System.out.println("Is queue empty? " + myQueue.isEmpty()); // Expected: false
        System.out.println("Is queue full? " + myQueue.isFull());   // Expected: true

        System.out.println("\n=== TESTING PEEK AND DISPLAY ===");
        System.out.println("Current front item (peek): " + myQueue.peek()); // Expected: 10
        myQueue.display(); // Expected: Queue content: 10 20 30

        System.out.println("\n=== TESTING DEQUEUE OPERATIONS ===");
        System.out.println("Dequeued item: " + myQueue.dequeue()); // Expected: 10
        System.out.println("Dequeued item: " + myQueue.dequeue()); // Expected: 20

        System.out.println("\n=== QUEUE STATE AFTER DEQUEUES ===");
        System.out.println("Current front item (peek): " + myQueue.peek()); // Expected: 30
        myQueue.display(); // Expected: Queue content: 30

        System.out.println("Dequeued item: " + myQueue.dequeue()); // Expected: 30

        System.out.println("\n=== TESTING EXCEPTION SYSTEM.EXIT ===");
        System.out.println("Attempting to peek into an empty queue...");
        System.out.println("The program should print 'Empty Queue' and terminate below:");

        // This will trigger System.exit(1) and stop the program execution entirely
        myQueue.peek();

        // This line will never print because the JVM has been shut down above
        System.out.println("This text will not appear.");
    }
}
