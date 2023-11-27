package pgdp.collections;

public class Checkout {
    private final Queue<PenguinCustomer> queue;
    private final Queue<FishyProduct> bandBeforeCashier;
    private final Queue<FishyProduct> bandAfterCashier;

    public Checkout(){
        queue = new LinkedQueue<>();
        bandBeforeCashier = new LinkedQueue<>();
        bandAfterCashier = new LinkedQueue<>();
    }

    public Queue<PenguinCustomer> getQueue(){return queue;}
    public Queue<FishyProduct> getBandBeforeCashier(){return bandBeforeCashier;}
    public Queue<FishyProduct> getBandAfterCashier(){return bandAfterCashier;}

    public int queueLength(){
        return queue.size();
    }

    public void serveNextCustomer(){
        if(queue.isEmpty()) return;
        PenguinCustomer p = queue.dequeue();
        p.placeAllProductsOnBand(bandBeforeCashier);
        int totalPrice = 0;
        while(!bandBeforeCashier.isEmpty()){
            FishyProduct f = bandBeforeCashier.dequeue();
            totalPrice += f.getPrice();
            bandAfterCashier.enqueue(f);
        }
        p.takeAllProductsFromBand(bandAfterCashier);
        p.pay(totalPrice);
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "queue=" + queue +
                ", bandBeforeCashier=" + bandBeforeCashier +
                ", bandAfterCashier=" + bandAfterCashier +
                '}';
    }
}
