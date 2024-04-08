/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
   “Stackoverflow.Com.” Fan Prob with toString() Method -- Simple [Duplicate], Nov. 2016,
   stackoverflow.com/questions/27006339/fan-prob-with-tostring-method-simple. 
    Additional modifications by Daniel W. 2024
*/
import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> list; 
    public GenericQueue() {
        list = new LinkedList<>();
    }
  // Method to enqueue an item
    public void enqueue(E item) {
        list.addFirst(item);
    }
 // Method to dequeue an item
    public E dequeue() {
        return list.removeFirst();
    }
   // Method to get size of the queue
    public int size() {
        return list.size();
    }
}
