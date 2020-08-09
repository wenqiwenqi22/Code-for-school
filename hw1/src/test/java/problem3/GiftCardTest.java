package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiftCardTest {
    private String cardNumber = "abc";
    private final String firstName = "Ellie";
    private final String lastName = "Cao";
    private final Owner owner = new Owner(firstName, lastName);
    private final int dollarBalance = 100;
    private final int centBalance = 99;
    private final CardBalance cardBalance = new CardBalance(dollarBalance, centBalance);
    private final GiftCard giftCard = new GiftCard(cardNumber, owner, cardBalance);
    private final int dollarBalance2 = -1;
    private final int centBalance2 = 199;
    private final CardBalance cardBalance2 = new CardBalance(dollarBalance2, centBalance2);
    private final GiftCard giftCard2 = new GiftCard(cardNumber, owner, cardBalance2);


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getCardNumber() {
        assertEquals(cardNumber, giftCard.getCardNumber());
    }

    @Test
    public void getOwner() {
        assertEquals(firstName, giftCard.getOwner().getFirstName());
        assertEquals(lastName, giftCard.getOwner().getLastName());
    }

    @Test
    public void getCardBalance() {
        // case 1
        assertEquals(dollarBalance, giftCard.getCardBalance().getDollarBalance());
        assertEquals(centBalance, giftCard.getCardBalance().getCentBalance());
        // case 2: if the card balance is an invalid number, return null
        assertEquals(null, giftCard2.getCardBalance());
    }

    @Test
    public void deposit() {
        // case 1 : deposit 200.7 to 100.99, remains 301.99
        int depositDollarAmount1 = 200;
        int depositCentAmount1 = 70;
        int newDollarBalance1 = 301;
        int newCentBalance1 = 69;
        GiftCard newCard1 = giftCard.deposit(giftCard, depositDollarAmount1, depositCentAmount1);
        assertEquals(newDollarBalance1, newCard1.getCardBalance().getDollarBalance());
        assertEquals(newCentBalance1, newCard1.getCardBalance().getCentBalance());
        // case 2: deposit 1 to 100.99, remains 101.99
        int depositDollarAmount2 = 1;
        int depositCentAmount2 = 0;
        int newDollarBalance2 = 101;
        int newCentBalance2 = 99;
        GiftCard newCard2 = giftCard.deposit(giftCard, depositDollarAmount2, depositCentAmount2);
        assertEquals(newDollarBalance2, newCard2.getCardBalance().getDollarBalance());
        assertEquals(newCentBalance2, newCard2.getCardBalance().getCentBalance());
        // case 3: deposit -1.-1 from 100.99, remains. 100.99
        int depositDollarAmount3 = -1;
        int depositCentAmount3 = -1;
        GiftCard newCard3 = giftCard.deposit(giftCard, depositDollarAmount3, depositCentAmount3);
        assertEquals(dollarBalance, newCard3.getCardBalance().getDollarBalance());
        assertEquals(centBalance, newCard3.getCardBalance().getCentBalance());
    }

    @Test
    public void withdraw() {
        // case 1:withdraw 51.41 from 100.99, remains 49.58
        int withdrawDollarAmount1 = 51;
        int withdrawCentAmount1 = 41;
        int newDollarBalance1 = 49;
        int newCentBalance1 = 58;
        GiftCard newCard1 = giftCard.withdraw(giftCard, withdrawDollarAmount1, withdrawCentAmount1);
        assertEquals(newDollarBalance1, newCard1.getCardBalance().getDollarBalance());
        assertEquals(newCentBalance1, newCard1.getCardBalance().getCentBalance());
        // case 2: withdraw 9.9 from 49.58, remains 39.68
        int withdrawDollarAmount2 = 9;
        int withdrawCentAmount2 = 9;
        int newDollarBalance2 = 39;
        int newCentBalance2 = 68;
        GiftCard newCard2 = newCard1.withdraw(giftCard, withdrawDollarAmount1, withdrawCentAmount1);
        assertEquals(newDollarBalance1, newCard2.getCardBalance().getDollarBalance());
        assertEquals(newCentBalance1, newCard2.getCardBalance().getCentBalance());
        // case 3: withdraw -1.-1 from 100.99, remains 100.99
        int withdrawDollarAmount3 = -1;
        int withdrawCentAmount3 = -1;
        GiftCard newCard3 = giftCard.withdraw(giftCard, withdrawDollarAmount3, withdrawCentAmount3);
        assertEquals(dollarBalance, newCard3.getCardBalance().getDollarBalance());
        assertEquals(centBalance, newCard3.getCardBalance().getCentBalance());
    }
}