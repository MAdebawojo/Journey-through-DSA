import java.util.EmptyStackException;

/**
 * A linear data structure that follows the Last In, First Out (LIFO) principle.
 *
 * @author M.Adebawojo
 * @version 1.0
 */
public class Stack {

    /** The index pointer of the top element. Initialized to -1 when empty. */
    private int top = -1;

    /** The internal array holding the stack elements. */
    private int[] stack;

    /** The maximum capacity of the stack. */
    private int k;

    /**
     * Constructs a new Stack with a specified maximum capacity.
     *
     * @param k The maximum number of elements this stack can hold.
     */
    public Stack(int k){
        this.k = k;
        this.stack = new int[k];
    }

    /**
     * Looks at the object at the top of this stack without removing it.
     *
     * @return The integer at the top of the stack.
     * @throws EmptyStackException If this stack is empty.
     */
    int peek(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return stack[this.top];
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param num The integer item to be pushed onto this stack.
     * @throws IllegalStateException If the stack has reached its maximum capacity.
     */
    void push(int num){
        if(this.isFull()){
            throw new IllegalStateException("Stack Overflow: Cannot push to a full stack.");
        }
        System.out.println("Inserting " + num);
        stack[++top] = num;
    }

    /**
     * Removes the object at the top of this stack and returns it.
     *
     * @return The integer at the top of the stack.
     * @throws EmptyStackException If this stack is empty.
     */
    int pop(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    /**
     * Prints all the elements currently in the stack from top to bottom.
     */
    void displayStack(){
        if(this.isEmpty()){
            System.out.println("STACK EMPTY");;
            return;
        }
        for(int i = top; i > -1; i--){
            System.out.println(this.stack[i]);
        }
    }

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is at maximum capacity; false otherwise.
     */
    boolean isFull(){
        // Recall that top is the index pointer for the element at the top of the stack.
        // Therefore if the index pointer is equal to the capacity minus 1,
        // then the stack has reached its last possible index
        return this.top == this.k-1;


        //        if(this.top == this.k - 1){
        //            return true;
        //        }
        //        else {
        //            return false;
        //        }
        // This if-else statement can be simplified to "return this.top == this.k-1;"
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack contains no elements; false otherwise.
     */
    boolean isEmpty(){
        return this.top == -1;

        //        if(this.top == -1){
        //            return true;
        //        }
        //        else{
        //            return false;
        //        }
        // This if-else statement can be simplified to "return this.top == -1;"
    }
}
