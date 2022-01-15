package inacio;

public class Lodging implements Expense{
    private Destination dest; //an object reference (a reference for the class)
    private int nights;
    public Lodging (Destination dest, int nights) {
        this.dest = dest;
        this.nights = nights;
    }

    @Override
    public float getCost() {
        switch (dest) {
            case Mexico:
                return 100.00f * nights;
            case Europe:
                return 200.00f * 1.0f * nights;
            case Japan:
                return 300.00f * 3.0f * nights;
            default:
                return 0.0f; //if any country is selected
        }
    }
}
