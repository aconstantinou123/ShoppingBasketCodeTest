import Items.Blanket;
import Items.Chicken;
import Items.HeadPhones;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ItemTest {

    Chicken chicken1;
    Blanket blanket1;
    HeadPhones headPhones1;

    @Before
    public void before(){
        chicken1 = new Chicken("Chicken", 20.0);
        blanket1 = new Blanket("Blanket", 10.0);
        headPhones1 = new HeadPhones("Head Phones", 15.0);
    }

    @Test
    public void canGetItemName(){
        assertEquals("Chicken", chicken1.getName());
    }

    @Test
    public void canGetItemPrice(){
        assertEquals(15.0, headPhones1.getPrice(), 0.1);
    }

    @Test
    public void canSetName(){
        chicken1.setName("Dog");
        assertEquals("Dog", chicken1.getName());
    }

    @Test
    public void canSetPrice(){
        blanket1.setPrice(7.0);
        assertEquals(7.0, blanket1.getPrice());
    }

}
