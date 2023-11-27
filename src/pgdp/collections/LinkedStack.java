package pgdp.collections;

public class LinkedStack<T> implements Stack<T>{
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
    public void push(T t) {
        if(last == null){
            first = last = new List<>(t);
          //  System.out.println(first.toString());
            return;
        }
        last.insert(t);
        last = last.getNext();
     //   System.out.println(first.toString());
    }

    @Override
    public T pop() {
        if(first == null) return null;
        if(first.getNext() == null){
            T inf = first.getInfo();
            first = last = null;
            return inf;
        }

        List<T> t = first;
        while (t.getNext().getNext() != null) t = t.getNext();
        T inf = t.getNext().getInfo();
        t.delete();
        last = t;
    //    System.out.println(first.toString());
        return inf;
    }
}
