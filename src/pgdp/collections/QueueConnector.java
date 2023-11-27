package pgdp.collections;

public class QueueConnector<T> implements DataStructureConnector<T>{
    private final Queue<T> queue;

    public QueueConnector(Queue<T> queue){
        this.queue = queue;
    }
    @Override
    public boolean hasNextElement() {
        return !queue.isEmpty();
    }

    @Override
    public void addElement(T t) {
        queue.enqueue(t);
    }

    @Override
    public T removeNextElement() {
        return queue.dequeue();
    }
}
