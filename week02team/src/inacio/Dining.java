package inacio;

public class Dining implements Expense{
    private Destination dest; //an object reference (a reference for the class)
    private int nights;
    public Dining (Destination dest, int nights) {
        this.dest = dest;
        this.nights = nights;
    }

    @Override
    public float getCost() {
        switch (dest) {
            case Mexico:
                return 10.00f * nights;
            case Europe:
                return 20.00f * nights;
            case Japan:
                return 30.00f * nights;
            default:
                return 0.0f; //if any country is selected
        }
    }
}
