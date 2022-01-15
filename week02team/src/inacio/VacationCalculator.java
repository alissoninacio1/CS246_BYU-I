package inacio;

import java.util.ArrayList;
import java.util.List;

public class VacationCalculator {
    public static void main(String[] args) {

        VacationCalculator vc = new VacationCalculator();

        // Calculate some vacation costs...
        float europaCost = vc.calculateVacationCost(Destination.Europe,8);
        float mexicoCost = vc.calculateVacationCost(Destination.Mexico,7);
        float japanCost = vc.calculateVacationCost(Destination.Japan,4);

        // Print the cost...
        System.out.println("Europe: " + europaCost);
        System.out.println("Mexico: " + mexicoCost);
        System.out.println("Japan: " + japanCost);
    }

    /**
     * Calculates the total cost for vacationing at a given location for
     * a specific number of nights.
     *
     * @param  dest the destination of the vacation
     * @return      the total cost of the vacation
     *
     * public float calculateVacationCost(Destination dest, int nights) {
     *         Cruise calc = new Cruise(dest,nights);
     *         return calc.getCost();
     *     }
     */
    public float calculateVacationCost(Destination dest, int nights) {
        //call the ArrayList class
        List<Expense> itinerary = new ArrayList<Expense>();
        itinerary.add(new Cruise(dest, nights));
        itinerary.add(new Dining(dest, nights));
        itinerary.add(new Lodging(dest, nights));
        float costVac = tallyExpenses(itinerary);
        return costVac;
    }

    /**
     * An internal method used by VacationCalculator to loop through
     * a List of items that implement the Expense interface and
     * determine their cost
     *
     * @param  expenses A list of items that implement the Expense interface
     * @return          the total cost calculated by the items
     */

    float tallyExpenses(List<Expense> expenses) {
        float cost = 0;
        for(Expense i : expenses) {
            cost +=  i.getCost();
        }
        return cost;
    }
}
