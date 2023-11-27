package pgdp.collections;

public class PenguinCustomer {
    private final String name;
    private int money;
    private final Stack<FishyProduct> products;

    public PenguinCustomer(String name, int initialMoney) {
        if(name == null){
            ExceptionUtil.illegalArgument("Name null");
        }
        if(initialMoney < 0){
            ExceptionUtil.illegalArgument("Money negative");
        }

        this.name = name;
        this.money = initialMoney;
        this.products = new LinkedStack<>();
    }



    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public Stack<FishyProduct> getProducts() {
        return products;
    }

    public void addProductToBasket(FishyProduct fish){
        products.push(fish);
    }

    public void placeAllProductsOnBand(Queue<FishyProduct> band){
        if(products.isEmpty())
            return;
        DataStructureConnector<FishyProduct> d1 = new StackConnector<>(products);
        DataStructureConnector<FishyProduct> d2 = new QueueConnector<>(band);

        DataStructureLink<FishyProduct> nirvana = new DataStructureLink<>(d1,d2);
        nirvana.moveAllFromAToB();
    }



    public void takeAllProductsFromBand(Queue<FishyProduct> band){
        if(band.isEmpty())
            return;
        DataStructureConnector<FishyProduct> d1 = new QueueConnector<>(band);
        DataStructureConnector<FishyProduct> d2 = new StackConnector<>(products);

        DataStructureLink<FishyProduct> nirvana = new DataStructureLink<>(d1,d2);
        nirvana.moveAllFromAToB();
    }


    public void pay(int cost){
        if(cost<0){
            ExceptionUtil.illegalArgument("Cost is negative");
        }
        if(money < cost){
            ExceptionUtil.unsupportedOperation("Not enough money");
        }
        money -= cost;

    }



    public void goToCheckout(PenguinSupermarket supermarket){
        supermarket.getCheckoutWithSmallestQueue().getQueue().enqueue(this);
    }



    @Override
    public String toString() {
        return "PenguinCustomer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", products=" + products +
                '}';
    }
}