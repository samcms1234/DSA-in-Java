import java.util.EmptyStackException;
import java.util.Stack;

public class StackArrayImplementation {
    private int capacity;
    private int top;
    private int stack[];

    public StackArrayImplementation(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity-1;
    }
     public void push(int data) {
        if(isFull()) {
            throw new StackOverflowError();
        }
        else {
            stack[++top] = data;
        }
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
            int res = stack[top];
            top--;
            return res;
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    // Reverse a String

    public static String reverseString(String s) {

        Stack<Character> stack= new Stack<>();
        char[] chars = s.toCharArray();

        for(char ch: chars) {
            stack.push(ch);
        }

        for(int i = 0; i < s.length(); i++) {
            chars[i] = stack.pop();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        StackArrayImplementation st = new StackArrayImplementation(10);
        st.push(10);
        st.push(11);
        st.push(12);
        st.pop();
        System.out.println(st.peek());

        System.out.println(reverseString("ABCD"));
    }
}
