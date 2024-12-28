package groceries;

// -------------------------------------------------------------------------
/**
 * The Grocery Bag class is a bag data structure that holds String objects that
 * represent grocery store items.
 *
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.04.25
 * @author Grace Fields
 * @version 2016.02.01
 */
public class GroceryBag extends ArrayBasedBag {
    // Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public GroceryBag() {
        super(10);
    }


    // Public methods ........................................................
    /**
     * If an element is in both bags, then it will be in the intersection. If
     * there are multiple occurrences of that element, then the number of
     * occurrences of that element in the intersection will equal the minimum
     * number of occurrences in either set.
     * 
     * Examples: intersection of ({"apple","apple","cereal","chips"}, {"chips",
     * "apple","apple","chips","cake"}) = {"apple","apple","chips"}
     * 
     * @param bag
     *            Bag to be intersected with.
     * @return The intersection of the two bags.
     */
    public GroceryBag intersection(GroceryBag bag) {
        String[] list1 = this.contents();
        String[] list2 = bag.contents();
        GroceryBag intersectionResult = new GroceryBag();
        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != null) {
                for (int j = 0; j < list2.length; j++) {
                    if (list1[i] != null && list2[j] != null && list1[i].equals(
                        list2[j])) {
                        intersectionResult.add(list1[i]);
                        list1[i] = null;
                        list2[j] = null;
                    }
                }
            }
        }
        return intersectionResult;
    }


    /**
     * For two bags to be equal they need to contain items with the same names
     * and frequencies (so equality across specific attributes; identity is not
     * required). Order does not matter, but number of occurrences does.
     *
     * @param givenBag
     *            Other bag to be compared with for equality.
     * @return Returns true if the two bags have the same items.
     */
    @Override
    public boolean equals(Object givenBag) {
        if (givenBag == null) {
            return false;
        }
        if (givenBag == this) {
            return true;
        }
        if (givenBag.getClass() != this.getClass()) {
            return false;
        }
        GroceryBag otherBag = (GroceryBag)givenBag;
        if (this.size() != otherBag.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if ( this.occurrence(this.contents()[i]) != 
                    otherBag.occurrence(otherBag.contents()[i])) {
                return false;
            }
        }
        return true;
    }
}
