/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.List;
import java.util.ArrayList;


public class DrivableTrader<T> {
    private final List<Drivable> inventory;
    private final List<Drivable> wishlist;
    private int money;


    /**
     * Construct a Trader, giving them the given inventory,
     * wishlist, and money.
     *
     * @param inventory Objects in this Trader's inventory
     * @param wishlist  Objects in this Trader's wishlist
     * @param money     The Trader's money
     */
    public DrivableTrader(List<Drivable> inventory, List<Drivable> wishlist,
                  int money) {
        this.inventory = inventory;
        this.wishlist = wishlist;
        this.money = money;
    }

    /* Add a new constructor that takes a single argument
     *       representing the Trader's money. Give the Trader
     *       empty ArrayLists for their inventory and wishlist.
     */
    public DrivableTrader(int money) {
        this.inventory = new ArrayList<>();
        this.wishlist = new ArrayList<>();
        this.money = money;
    }

    /* Implement the method addToWishlist that takes an
     *       object of type T and adds it to this Trader's wishlist.
     */
    public void addToWishlist(Drivable item) {
        wishlist.add(item);
    }

    /* The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
     */
    public int getSellingPrice(Drivable item) {
        if (item instanceof Tradable) {
            return ((Tradable) item).getPrice() + item.getMaxSpeed();
        } else {
            return Tradable.MISSING_PRICE;
        }
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder("-- Inventory --\n");

        for (Drivable item : this.inventory) {
            details.append(item).append("\n");
        }

        details.append("-- Wishlist --\n");
        for (Drivable item : this.wishlist) {
            details.append(item).append("\n");
        }

        return details.toString();
    }

    public List<Drivable> getWishlist(){
        return this.wishlist;
    }

    public List<Drivable> getInventory(){
        return this.inventory;
    }

}