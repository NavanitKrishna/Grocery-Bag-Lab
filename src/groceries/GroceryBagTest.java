/**
 * 
 */
package groceries;

/**
 * @author Navanit Krishna Satish Kumar
 * @version 2024.09.19
 */
public class GroceryBagTest extends student.TestCase {
    private GroceryBag bag1;    // unordered
    private GroceryBag bag2;    // unordered with repeat items
    private GroceryBag bag3;    // ordered
    private GroceryBag bag4;    // ordered with repeat items
    private GroceryBag bag5;    // unordered version of bag4
    private GroceryBag bag6;    // identical bag to bag1
    private GroceryBag nullBag;
    private String diffObj = "Different Object";
    
    /**
     * Sets up each test method.
     */
    public void setUp() {
    
        bag1 = new GroceryBag();
        bag1.add("apples");
        bag1.add("chips");
        bag1.add("yogurt");
        bag1.add("chicken");
        bag1.add("pasta");

        bag2 = new GroceryBag();
        bag2.add("pizza");
        bag2.add("broccoli");
        bag2.add("pasta");
        bag2.add("pasta");
        bag2.add("apples");

        bag3 = new GroceryBag();
        bag3.add("apples");
        bag3.add("chicken");
        bag3.add("chicken");
        bag3.add("pasta");
        bag3.add("pizza");
        bag3.add("soda");
        bag3.add("yogurt");
        bag3.add("wheat");

        bag4 = new GroceryBag();
        bag4.add("chicken");
        bag4.add("chicken");
        bag4.add("pasta");
        bag4.add("pasta");
        bag4.add("yogurt");
        
        bag5 = new GroceryBag();
        bag5.add("pasta");
        bag5.add("yogurt");
        bag5.add("chicken");
        bag5.add("pasta");
        bag5.add("chicken");
        
        bag6 = new GroceryBag();
        bag6.add("apples");
        bag6.add("chips");
        bag6.add("yogurt");
        bag6.add("chicken");
        bag6.add("pasta");
    }
    
    /**
     * Tests the Equals method from GroceryBag Class
     */
    public void testEquals() {
        assertFalse(bag1.equals(nullBag));
        assertFalse(bag1.equals(diffObj));
        assertTrue(bag1.equals(bag1));
        assertFalse(bag1.equals(bag3));
        assertFalse(bag1.equals(bag2));
        assertFalse(bag4.equals(bag5));
        assertTrue(bag1.equals(bag6));
    }
    
    /**
     * Tests the Intersection method from GroceryBag Class
     */
    public void testIntersection() {
        GroceryBag result = bag1.intersection(bag4);
        
        assertTrue(result.equals(bag1.intersection(bag4)));
        assertEquals(result.size(), bag1.intersection(bag4).size());
        for (int i = 0; i < result.size(); i++) {
            assertTrue(result.contents()[i].equals(
                    bag1.intersection(bag4).contents()[i]));
        }
    }
}