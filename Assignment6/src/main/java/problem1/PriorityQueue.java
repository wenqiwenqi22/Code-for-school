package problem1;

import java.util.Objects;

/**
 * PriorityQueue is an object implement IImmutablePriorityQueue interface. It has priority, value and rest for each elements.
 * It will sort elements based on their priority from the highest to the lowest. For the ones with the same priority, it follows
 * first in first out policy.
 */
public class PriorityQueue implements IImmutablePriorityQueue {
    private final Integer priority;
    private final String value;
    private final IImmutablePriorityQueue rest;

    /**
     * Constructs a PriorityQueue object that with priority, value, rest.
     * @param priority the value of priority of the highest element.
     * @param value the String value with the highest priority.
     * @param rest the rest elements after the highest priority.
     * @throws InvalidPriorityQueueElement if the priority is null or the priority is smaller than the priority of the rest
     */
    public PriorityQueue(Integer priority, String value, IImmutablePriorityQueue rest) throws InvalidPriorityQueueElement {
        if (priority == null) {
            throw  new InvalidPriorityQueueElement("Invalid priority value.");
        }else {
            if (rest == null || rest.isEmpty() ||  priority > rest.getPriority()) {
                this.priority = priority;
                this.value = value;
                this.rest = rest;
            }else {
                throw new  InvalidPriorityQueueElement("Invalid priority value.");
            }
        }

    }

    /**
     * Constructs an empty priority queue.
     */
    public PriorityQueue() {
        this.priority = null;
        this.value = null;
        this.rest = null;
    }

    /**
     * Returns the highest priority of the priority queue.
     * @return the highest priority of the priority queue.
     */
    public Integer getPriority() {
        return this.priority;
    }


    /**
     * Returns the value with the highest priority of the priority queue.
     * @return the value with the highest priority of the priority queue.
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Returns the rest priority of the priority queue.
     * @return the rest priority of the priority queue.
     */
    public IImmutablePriorityQueue getRest() {
        return this.rest;
    }

    /**
     * Return true if the priority queue is empty, otherwise returns false.
     * @return true if the priority queue is empty, otherwise returns false.
     */
    @Override
    public Boolean isEmpty() {
        return this.priority == null;
    }

    /**
     * Returns the new priority queue after adding a specific value of a specific priority.
     * @param priority the priority of the adding value
     * @param value the value that need to be added
     * @return the new priority queue after adding a specific value of a specific priority.
     * @throws InvalidPriorityQueueElement if the priority is null or smaller than the current priority
     */
    //same priority:first in first out(in the front)
    @Override
    public PriorityQueue add(Integer priority, String value) throws InvalidPriorityQueueElement {
        if (this.isEmpty() || priority > this.getPriority()) {
            return new PriorityQueue(priority, value, this);
        }else {

            PriorityQueue newRest = new PriorityQueue();
            if(this.getRest().getPriority() != null || !this.getRest().isEmpty()) {
                newRest = new PriorityQueue(this.getRest().getPriority(), this.getRest().getValue(), this.getRest().getRest());
            }
            newRest = newRest.add(priority, value);
            return new PriorityQueue(this.priority, this.value, newRest);

            }

    }

    /**
     * Returns the value with the highest priority if the priority queue is not empty.
     * @return the value with the highest priority if the priority queue is not empty.
     * @throws InvalidPriorityQueueElement if the priority queue is empty.
     */
    @Override
    public String peek() throws InvalidPriorityQueueElement{
        if (!this.isEmpty()) {
            return this.value;
        } else {
            throw new InvalidPriorityQueueElement("The Queue is empty.");
        }
    }

    /**
     * Returns the priority queue after poping(removing) the value with the highest priority if the priority queue is not empty.
     * @return the priority queue after poping(removing) the value with the highest priority if the priority queue is not empty.
     * @throws InvalidPriorityQueueElement if the priority queue is empty.
     */
    @Override
    public PriorityQueue pop() throws InvalidPriorityQueueElement {
        if (!this.isEmpty()){
            if (!this.getRest().isEmpty()) {
                return new PriorityQueue(this.getRest().getPriority(), this.getRest().getValue(), this.getRest().getRest());
            }else {
                return IImmutablePriorityQueue.createEmpty();
            }
        }else {
            throw new InvalidPriorityQueueElement("The Queue is empty.");
        }
    }

    /**
     * Returns true if two priority queue is the same.
     * @param o the object that want to check
     * @return true if two priority queue is the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriorityQueue that = (PriorityQueue) o;
        return Objects.equals(priority, that.priority) &&
                Objects.equals(value, that.value) &&
                Objects.equals(rest, that.rest);
    }

    /**
     * Returns the hashcode of the specific priority queue.
     * @return the hashcode of the specific priority queue.
     */
    @Override
    public int hashCode() {
        return Objects.hash(priority, value, rest);
    }

    /**
     * Returns the toString format of the specific priority queue.
     * @return the toString format of the specific priority queue.
     */
    @Override
    public String toString() {
        return "PriorityQueue{" +
                "priority=" + priority +
                ", value='" + value + '\'' +
                ", rest=" + rest +
                '}';
    }
}
