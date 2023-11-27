package pgdp.collections;

public class DataStructureLink<T> {
    private final DataStructureConnector<T> A;
    private final DataStructureConnector<T> B;

    public DataStructureLink(DataStructureConnector<T> A, DataStructureConnector<T> B) {
        this.A = A;
        this.B = B;
    }

    public boolean moveNextFromAToB(){
        if(!A.hasNextElement()) return false;
        T a = A.removeNextElement();
        B.addElement(a);
        return true;
    }
    public void moveAllFromAToB(){
        while (moveNextFromAToB());
    }
}
