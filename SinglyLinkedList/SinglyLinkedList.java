import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */


    // helper 1 validate data not null
    private void checknull(T data){
        if (data == null) {
            throw new IllegalArgumentException("java.lang.IllegalArgumentException");
        }
    }

    // helper 2 validate array not empty
   private void checkempty(){
        if (size == 0) {
            throw new NoSuchElementException("java.util.NoSuchElementException");
        }
    }   
  
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        checknull(data);
        SinglyLinkedListNode<T> newnode = new SinglyLinkedListNode<T>(data, head);
        head = newnode;
        if (size == 0){
            tail = newnode;
        }
        size++;
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        checknull(data);
        SinglyLinkedListNode<T> newnode = new SinglyLinkedListNode<T>(data);
        if (size == 0){
            head = newnode;
        } else{
            tail.setNext(newnode);
        }
        tail = newnode;
        size++;
    }


    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        checkempty();
        SinglyLinkedListNode<T> remove = head;
        head = remove.getNext();
        remove.setNext(null);
        size--;
        if (size == 0){
            tail = null;
        }
        return remove.getData();  
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        checkempty();
        SinglyLinkedListNode<T> remove = tail;

        SinglyLinkedListNode<T> temp = head;
        for (int i=0; i<size-2; i++){
            temp = temp.getNext();
        }
        tail = temp;
        tail.setNext(null);
        size--;
        if (size == 0){
            tail = null;
            head = null;
        }
        return remove.getData();  

    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}