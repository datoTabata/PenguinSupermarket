package pgdp.collections;

public class PenguinSupermarket {
    private Checkout[] checkouts;
    public Checkout[] getCheckouts(){
        return checkouts;
    }

    public PenguinSupermarket(int n){
        if(n <= 0) ExceptionUtil.illegalArgument("Number <= 0");
        checkouts = new Checkout[n];
        for (int i = 0; i< checkouts.length; i++){
            checkouts[i] = new Checkout();
        }
    }

    public Checkout getCheckoutWithSmallestQueue(){
        Checkout min = checkouts[0];
        for (int i = 0; i< checkouts.length; i++){
            if(checkouts[i].queueLength() < min.queueLength()){
                min = checkouts[i];
            }
        }
        return min;
    }


    public void closeCheckout(int index){
        if(checkouts.length == 1) ExceptionUtil.unsupportedOperation("This is the last register...");
        if(index >= checkouts.length || index < 0) ExceptionUtil.illegalArgument("Index >= checkouts.length...");
        Checkout[] b = new Checkout[checkouts.length-1];
        int bIndex = 0;
        for (int i = 0; i< checkouts.length; i++){
            if(i == index) continue;
            b[bIndex++] = checkouts[i];
        }
        DataStructureConnector<PenguinCustomer> sawyisi = new QueueConnector<>(checkouts[index].getQueue());
        checkouts = b;
        Stack<PenguinCustomer> st = new LinkedStack<>();
        DataStructureConnector<PenguinCustomer> meore = new StackConnector<>(st);
        DataStructureLink<PenguinCustomer> d = new DataStructureLink<>(sawyisi, meore);
        d.moveAllFromAToB();
        while (!st.isEmpty()){
            st.pop().goToCheckout(this);
        }
    }

    public void serveCustomers(){
            for (int i = 0; i < checkouts.length; i++) {
                checkouts[i].serveNextCustomer();
            }
        }
    }

