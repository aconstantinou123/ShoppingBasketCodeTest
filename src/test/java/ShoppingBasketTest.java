import Discounts.Bogof;
import Discounts.LoyaltyCard;
import Discounts.TenPercentOff;
import Items.Blanket;
import Items.Chicken;
import Items.HeadPhones;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket1;
    Chicken chicken1;
    Blanket blanket1;
    Blanket blanket2;
    HeadPhones headPhones1;
    Bogof bogof1;
    TenPercentOff tenPercentOff1;
    LoyaltyCard loyaltyCard;


    @Before
    public void before(){
        shoppingBasket1 = new ShoppingBasket();
        chicken1 = new Chicken("Chicken", 20.0);
        blanket1 = new Blanket("Blanket", 10.0);
        blanket2 = new Blanket("Blanket", 10.0);
        headPhones1 = new HeadPhones("Head Phones", 15.0);
        bogof1 = new Bogof();
        tenPercentOff1 = new TenPercentOff();
        loyaltyCard = new LoyaltyCard();
    }

    @Test
    public void shoppingBasketIsEmpty(){
        assertEquals(0, shoppingBasket1.itemsSize());
    }

    @Test
    public void DiscountsAreEmpty(){
        assertEquals(0, shoppingBasket1.discountsSize());
    }

    @Test
    public void canAddItemsToBasket(){
        shoppingBasket1.addItems(chicken1);
        shoppingBasket1.addItems(blanket1);
        shoppingBasket1.addItems(headPhones1);
        assertEquals(3, shoppingBasket1.itemsSize());
    }

    @Test
    public void canGetTotalPrice(){
        shoppingBasket1.addItems(chicken1);
        shoppingBasket1.addItems(blanket1);
        shoppingBasket1.addItems(headPhones1);
        assertEquals(45.0, shoppingBasket1.totalPrice(), 0.1);

    }

    @Test
    public void canGetTotalPricePlusDiscounts_1() {
        shoppingBasket1.addItems(chicken1);
        shoppingBasket1.addItems(blanket1);
        shoppingBasket1.addItems(blanket2);
        shoppingBasket1.addItems(headPhones1);
        assertEquals(55.0, shoppingBasket1.totalPrice(), 0.1);
        shoppingBasket1.addDiscounts(bogof1);
        assertEquals(45.0, shoppingBasket1.totalPrice(), 0.1);
    }

    @Test
    public void canGetTotalPricePlusDiscounts_2() {
        shoppingBasket1.addItems(chicken1);
        shoppingBasket1.addItems(blanket1);
        shoppingBasket1.addItems(blanket2);
        shoppingBasket1.addItems(headPhones1);
        shoppingBasket1.addDiscounts(bogof1);
        shoppingBasket1.addDiscounts(tenPercentOff1);
        assertEquals(40.5, shoppingBasket1.totalPrice(), 0.1);
    }

    @Test
    public void canGetTotalPricePlusDiscounts_3() {
        shoppingBasket1.addItems(chicken1);
        shoppingBasket1.addItems(blanket1);
        shoppingBasket1.addItems(blanket2);
        shoppingBasket1.addItems(headPhones1);
        shoppingBasket1.addDiscounts(bogof1);
        shoppingBasket1.addDiscounts(tenPercentOff1);
        shoppingBasket1.addDiscounts(loyaltyCard);
        assertEquals(39.69, shoppingBasket1.totalPrice(), 0.1);
    }
}
