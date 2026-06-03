import java.util.EmptyStackException;

/**
 * Test runner class to validate the functionality and safety of the Stack data structure.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== INITIALIZING STACK OF CAPACITY 3 ===");
        Stack myStack = new Stack(3);

        // 1. Test isEmpty on an empty stack
        System.out.println("Is stack empty? " + myStack.isEmpty()); // Expected: true

        System.out.println("\n=== TESTING PUSH OPERATIONS ===");
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        // 2. Test isFull on a full stack
        System.out.println("Is stack full? " + myStack.isFull()); // Expected: true

        System.out.println("\n=== TESTING DISPLAY AND PEEK ===");
        System.out.println("Current top item (peek): " + myStack.peek()); // Expected: 30
        System.out.println("Full stack content (top to bottom):");
        myStack.displayStack(); // Expected: 30, 20, 10

        System.out.println("\n=== TESTING EXCEPTION: STACK OVERFLOW ===");
        try {
            System.out.println("Attempting to push a 4th item...");
            myStack.push(40);
        } catch (IllegalStateException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }

        System.out.println("\n=== TESTING POP OPERATIONS ===");
        System.out.println("Popped item: " + myStack.pop()); // Expected: 30
        System.out.println("Popped item: " + myStack.pop()); // Expected: 20
        System.out.println("Popped item: " + myStack.pop()); // Expected: 10

        System.out.println("\n=== TESTING EXCEPTION: STACK UNDERFLOW ===");
        try {
            System.out.println("Attempting to pop from an empty stack...");
            myStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Caught Expected Error: Stack is completely empty!");
        }

        try {
            System.out.println("Attempting to peek into an empty stack...");
            myStack.peek();
        } catch (EmptyStackException e) {
            System.out.println("Caught Expected Error: Cannot peek into an empty stack!");
        }
    }
}
