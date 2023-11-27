package pgdp.collections;

public class LinkedQueue<T> implements Queue<T>{
    private List<T> first;
    private List<T> last;
    @Override
    public int size() {
        if(first == null) return 0;
        return first.length();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void enqueue(T t) {
        if(first == null){
            first = last = new List<>(t);
            return;
        }
        last.insert(t);
        last = last.getNext();
    }

    @Override
    public T dequeue() {
        if(first == null) return null;
        if(first.getNext() == null){
            T inf = first.getInfo();
            first = last = null;
            return inf;
        }
        T inf = first.getInfo();
        first = first.getNext();
        return inf;
    }
}
