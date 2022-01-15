package inacio;

public class Cruise implements Expense {
    private Destination dest; //an object reference (a reference for the class)
    private int nights;
    public Cruise(Destination dest, int nights) {
        this.dest = dest;
        this.nights = nights;
   }

    @Override
    public float getCost() {
        switch (dest) {
            case Mexico:
                return 1000.00f * nights;
            case Europe:
                return 2000.00f * nights;
            case Japan:
                return 3000.00f * nights;
            default:
                return 0.0f; //if any country is selected
        }
    }
}
