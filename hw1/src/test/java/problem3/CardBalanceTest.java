package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardBalanceTest {
    private CardBalance cardBalance1;
    private int dollarBalance1;
    private int centBalance1;
    private CardBalance cardBalance2;
    private int dollarBalance2;
    private int centBalance2;


    @Before
    public void setUp() throws Exception {
        dollarBalance1 = 100;
        centBalance1 = 50;
        cardBalance1 = new CardBalance(dollarBalance1, centBalance1);
        dollarBalance2 = -1;
        centBalance2 = 150;
        cardBalance2 = new CardBalance(dollarBalance2, centBalance2);

    }

    @Test
    public void getDollarBalance() {
        // case 1
        assertEquals(dollarBalance1, cardBalance1.getDollarBalance());
        // case 2
        assertEquals(-1, cardBalance2.getDollarBalance());
    }

    @Test
    public void getCentBalance() {
        // case 1
        assertEquals(centBalance1, cardBalance1.getCentBalance());
        // case 2
        assertEquals(-1, cardBalance2.getCentBalance());
    }

    @Test
    public void depositDollar() {
        //case 1: deposit dollar and new dollar balance are >= 0
        int depositDollar1 = 10;
        int newDollar1 = dollarBalance1 + depositDollar1;
        assertEquals(newDollar1, cardBalance1.depositDollar(depositDollar1));
        // case 2: new dollar balance >= 0, but deposit dollar <= 0
        int depositDollar2 = -10;
        int newDollar2 = dollarBalance1 + depositDollar2;
        assertEquals(-1, cardBalance1.depositDollar(depositDollar2));
        // case 3: new dollar balance and deposit dollar are  <= 0
        int depositDollar3 = -110;
        int newDollar3 = dollarBalance1 + depositDollar3;
        assertEquals(-1, cardBalance1.depositDollar(depositDollar3));
    }

    @Test
    public void depositCent() {
        // case 1: deposit centAmount >= 0 and centAmount <= 99
        int depositCent1 = 10;
        int newCent1 = centBalance1 + depositCent1;
        assertEquals(newCent1, cardBalance1.depositCent(depositCent1));
        // case 2: deposit centAmount < 0 or centAmount > 100
        int depositCent2 = 100;
        int newCent2 = centBalance1 + depositCent2;
        assertEquals(-1, cardBalance1.depositCent(depositCent2));
    }

    @Test
    public void withdrawDollar() {
        //case 1: withdraw dollar and new dollar balance are >= 0
        int withdrawDollar1 = 10;
        int newDollar1 = dollarBalance1 - withdrawDollar1;
        assertEquals(newDollar1, cardBalance1.withdrawDollar(withdrawDollar1));
        // case 2: new dollar balance >= 0, but withdraw dollar <= 0
        int withdrawDollar2 = -10;
        int newDollar2 = dollarBalance1 - withdrawDollar2;
        assertEquals(-1, cardBalance1.withdrawDollar(withdrawDollar2));
        // case 3: new dollar balance and deposit dollar are  <= 0
        int withdrawDollar3 = -110;
        int newDollar3 = dollarBalance1 - withdrawDollar3;
        assertEquals(-1, cardBalance1.withdrawDollar(withdrawDollar3));
    }

    @Test
    public void withdrawCent() {
        // case 1: withdraw centAmount >= 0 and centAmount <= 99
        int withdrawCent1 = 10;
        int newCent1 = centBalance1 - withdrawCent1;
        assertEquals(newCent1, cardBalance1.withdrawCent(withdrawCent1));
        // case 2: deposit centAmount < 0 or centAmount > 100
        int withdrawCent2 = -10;
        int newCent2 = centBalance1 + withdrawCent2;
        assertEquals(-1, cardBalance1.withdrawCent(withdrawCent2));
    }
}