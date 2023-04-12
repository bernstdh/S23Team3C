package testing;


import shopping.ShoppingListViewer;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListViewerTest {

    private ShoppingListViewer shoppingListViewer;
    private ArrayList<String> itemList;
    
    public ShoppingListViewer setUp() {
        itemList = new ArrayList<>();
        itemList.add("bread");
        itemList.add("cheese");
        itemList.add("eggs");
        itemList.add("apple");
        return new ShoppingListViewer(itemList, "Test");
    }
    
//    @Test
//    public void testSortList() {
//    	ShoppingListViewer a = setUp();
//        List<String> sortesdList = a.sortList(itemList);
//        assertEquals("apple", sortedList.get(0));
//        assertEquals("bread", sortedList.get(1));
//        assertEquals("cheese", sortedList.get(2));
//    }

}
