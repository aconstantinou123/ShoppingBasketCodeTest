import Discounts.Bogof;
import Discounts.LoyaltyCard;
import Discounts.TenPercentOff;
import Items.Blanket;
import Items.Chicken;
import Items.HeadPhones;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class DiscountTest {

    ShoppingBasket shoppingBasket1;
    Chicken chicken1;
    Chicken chicken2;
    Chicken chicken3;
    Blanket blanket1;
    Blanket blanket2;
    HeadPhones headPhones1;
    HeadPhones headPhones2;
    HeadPhones headPhones3;
    HeadPhones headPhones4;
    Bogof bogof1;
    TenPercentOff tenPercentOff1;
    LoyaltyCard loyaltyCard;


    @Before
    public void before(){
        shoppingBasket1 = new ShoppingBasket();
        chicken1 = new Chicken("Chicken", 20.0);
        chicken2 = new Chicken("Chicken", 20.0);
        chicken3 = new Chicken("Chicken", 20.0);
        blanket1 = new Blanket("Blanket", 10.0);
        blanket2 = new Blanket("Blanket", 10.0);
        headPhones1 = new HeadPhones("Head Phones", 15.0);
        headPhones2 = new HeadPhones("Head Phones", 15.0);
        headPhones3 = new HeadPhones("Head Phones", 15.0);
        headPhones4 = new HeadPhones("Head Phones", 15.0);
        bogof1 = new Bogof();
        tenPercentOff1 = new TenPercentOff();
        loyaltyCard = new LoyaltyCard();
    }

    @Test
    public void canApplyBogof(){
        shoppingBasket1.addItems(chicken1);
        shoppingBasket1.addItems(chicken2);
        shoppingBasket1.addItems(chicken3);
        shoppingBasket1.addItems(blanket1);
        shoppingBasket1.addItems(blanket2);
        shoppingBasket1.addItems(headPhones1);
        shoppingBasket1.addItems(headPhones2);
        shoppingBasket1.addItems(headPhones3);
        shoppingBasket1.addItems(headPhones4);
        bogof1.applyDiscount(shoppingBasket1.getItems());
        assertEquals(80.0, shoppingBasket1.totalPrice());
    }

    @Test
    public void canApplyTenPercentOff(){
        shoppingBasket1.addItems(chicken1);
        shoppingBasket1.addItems(blanket1);
        shoppingBasket1.addItems(headPhones1);
        tenPercentOff1.applyDiscount(shoppingBasket1.getItems());
        assertEquals(40.5, shoppingBasket1.totalPrice());
    }

    @Test
    public void canApplyLoyaltyCard() {
        shoppingBasket1.addItems(chicken1);
        shoppingBasket1.addItems(blanket1);
        shoppingBasket1.addItems(headPhones1);
        loyaltyCard.applyDiscount(shoppingBasket1.getItems());
        assertEquals(44.1, shoppingBasket1.totalPrice());
    }

}
