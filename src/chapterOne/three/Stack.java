package chapterOne.three; /*************************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack < input.txt
 *
 *  A generic stack, implemented using a linked list. Each stack
 *  element is of type Item.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java Stack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 *************************************************************************/

import stdlib.StdIn;
import stdlib.StdOut;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * The <tt>Stack</tt> class represents a last-in-first-out (LIFO) stack of generic items.
 * It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 * for peeking at the top item, testing if the stack is empty, and iterating through
 * the items in LIFO order.
 * <p>
 * All stack operations except iteration are constant time.
 * <p>
 * For additional documentation, see <a href="/algs4/13stacks">Section 1.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Stack<Item> implements Iterable<Item> {
    private int N;          // size of the stack
    private Node first;     // top of stack
    private int popNum;  // 用来记录出栈的次数
    private int pushNum;  // 用来记录入栈的次数

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        N = 0;
    }

    /**
     * 得到一个与s相同的独立的副本
     *
     * @param s
     */
    public Stack(Stack<Item> s) {
        // 通过一个中间栈来实现
        Stack<Item> temp = new Stack<>();
        while (!s.isEmpty()) {
            temp.push(s.pop());
        }

        Item item;
        while (!temp.isEmpty()) {
            item = temp.pop();
            s.push(item);
            push(item);
        }
    }

    /**
     * （破坏性地）连接两个同类对象
     */
    public void catenation(Stack<Item> addStack) {
        if (this == addStack) throw new RuntimeException("不能连接本身！");
        if (addStack == null || addStack.isEmpty()) return;

        // 使用临时栈
        Stack<Item> temp = new Stack<>();

        // 把添加栈的元素先放到临时栈
        while (!addStack.isEmpty()) {
            temp.push(addStack.pop());
        }

        // 再把临时栈的元素放入本栈
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
    }

    /**
     * Is the stack empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Return the number of items in the stack.
     */
    public int size() {
        return N;
    }

    /**
     * Add the item to the stack.
     */
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
        pushNum++;
    }

    /**
     * Delete and return the item most recently added to the stack.
     * Throw an exception if no such item exists because the stack is empty.
     */
    public Item pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        N--;
        popNum++;
        return item;                   // return the saved item
    }


    /**
     * Return the item most recently added to the stack.
     * Throw an exception if no such item exists because the stack is empty.
     */
    public Item peek() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        return first.item;
    }

    /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    /**
     * Return an iterator to the stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        private int recordPopNum = popNum;
        private int recordPushNum = pushNum;

        public boolean hasNext() {
            isModified();
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            isModified();
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        private void isModified(){
            if(recordPopNum != popNum || recordPushNum != pushNum){
                throw new ConcurrentModificationException();
            }
        }
    }


    /**
     * A test client.
     */
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}

