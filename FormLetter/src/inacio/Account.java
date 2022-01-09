package inacio;

public class Account {
    //attributes
    private String name;
    private String lastPurchase;
    private int daySincePurchase;

    //constructor
    public Account(String name, String lastPurchase, int daySincePurchase) {
        this.name = name;
        this.lastPurchase = lastPurchase;
        this.daySincePurchase = daySincePurchase;
    }

    //getters and setters
    //name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //getLastPurchase
    public String getLastPurchase() {
        return lastPurchase;
    }
    public void setLastPurchase(String lastPurchase) {
        this.lastPurchase = lastPurchase;
    }

    //daySincePurchase
    public int getDaySincePurchase() {
        return daySincePurchase;
    }
    public void setDaySincePurchase(int daySincePurchase) {
        this.daySincePurchase = daySincePurchase;
    }
}
