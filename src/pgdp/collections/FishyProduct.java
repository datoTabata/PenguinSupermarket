package pgdp.collections;

public class FishyProduct {
    private final String name;
    private final int price;

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

    public FishyProduct(String name, int price){
        if(name == null) ExceptionUtil.illegalArgument("Name of the FishyProduct must not be null...");
        if(price <= 0) ExceptionUtil.illegalArgument("Price of the FishyProduct must be greater than zero...");
        this.name = name;
        this.price = price;
    }

    public String toString(){
        return "Product: " + name + ", Price: " + price + "$. Take it or leave it.";
    }
}
