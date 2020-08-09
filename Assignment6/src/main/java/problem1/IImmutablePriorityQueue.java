package problem1;

/**
 * IImmutablePriorityQueue is an interface for immutable priority queue with a static method - create empty and some other abstract method
 */
public interface IImmutablePriorityQueue {

    /**
     * Returns an empty priority queue.
     * @return an empty priority queue.
     */
    static PriorityQueue createEmpty(){
        return new PriorityQueue();
    }

    /**
     * Returns the value of the highest priority.
     * @return the value of the highest priority.
     */
    Integer getPriority();

    /**
     * Returns the value with the highest priority.
     * @return the value with the highest priority.
     */
    String getValue();

    /**
     * Returns the rest of the priority queue.
     * @return the rest of the priority queue.
     */
    IImmutablePriorityQueue getRest();

    /**
     * Return true if the priority queue is empty, otherwise returns false.
     * @return true if the priority queue is empty, otherwise returns false.
     */
    Boolean isEmpty();

    /**
     * Returns the new priority queue after adding a specific value of a specific priority.
     * @param priority the priority of the adding value
     * @param value the value that need to be added
     * @return the new priority queue after adding a specific value of a specific priority.
     * @throws InvalidPriorityQueueElement if the priority is null or smaller than the current priority
     */
    PriorityQueue add(Integer priority,String value) throws InvalidPriorityQueueElement;

    /**
     * Returns the value with the highest priority if the priority queue is not empty.
     * @return the value with the highest priority if the priority queue is not empty.
     * @throws InvalidPriorityQueueElement if the priority queue is empty.
     */
    String peek() throws InvalidPriorityQueueElement;

    /**
     * Returns the priority queue after poping(removing) the value with the highest priority if the priority queue is not empty.
     * @return the priority queue after poping(removing) the value with the highest priority if the priority queue is not empty.
     * @throws InvalidPriorityQueueElement if the priority queue is empty.
     */
    PriorityQueue pop() throws InvalidPriorityQueueElement;
}
