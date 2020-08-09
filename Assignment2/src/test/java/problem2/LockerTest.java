package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LockerTest {
    private Locker locker;
    private MailItem mail1;
    private MailItem mail2;
    private Recipient recipient1;
    private Recipient recipient2;

    @Before
    public void setUp() throws Exception {
        recipient1 = new Recipient("wenqi", "cao", "123@123.com");
        recipient2 = new Recipient("wenqi", "chen", "123@123.com");
        mail1 = new MailItem(10, 10, 10, recipient1);
        mail2 = new MailItem(31, 10, 10, recipient1);
        locker = new Locker(30, 20, 15, mail1);
    }

    @Test
    public void getMaximumWidth() {
        assertEquals(locker.getMaximumWidth(), 30);
    }

    @Test
    public void getMaximumHeight() {
        assertEquals(locker.getMaximumHeight(), 20);
    }

    @Test
    public void getMaximumDepth() {
        assertEquals(locker.getMaximumDepth(), 15);
    }

    @Test
    public void addMail_happyPath() {
        // case 1: happy path
        try {
            Locker locker2 = new Locker(30, 20, 15, null);
            locker2.addMail(mail1);
        } catch(Exception e){
            fail("An exception should not have been thrown.");
        }
        // case 2: the locker is occupied
        try {
            MailItem mail = new MailItem(10, 10, 10, recipient1);
            locker.addMail(mail);
            fail("An exception should not have been thrown.");
        } catch(Exception e){
        }
        // case 3: the mail is too large to be added
        try {
            Locker locker2 = new Locker(30, 20, 15, null);
            locker2.addMail(mail2);
            fail("An exception should not have been thrown.");
        } catch(Exception e){
        }
    }

    @Test
    public void pickupMail() {
        // case 1: happy path
        try {
            Locker locker2 = new Locker(30, 20, 15, mail1);
            MailItem pickedMail = locker2.pickupMail(recipient1);
            assertEquals(pickedMail.getMaximumWidth(), 10);
            assertEquals(pickedMail.getMaximumHeight(), 10);
            assertEquals(pickedMail.getMaximumDepth(), 10);
            assertTrue(pickedMail.getRecipient().equals(recipient1));
        } catch(Exception e){
            fail("An exception should not have been thrown.");
        }
        // case 2: the recipient is wrong.
        try {
            Locker locker2 = new Locker(30, 20, 15, mail1);
            MailItem pickedMail = locker2.pickupMail(recipient2);
            assertEquals(pickedMail.getMaximumWidth(), 11);
            assertEquals(pickedMail.getMaximumHeight(), 10);
            assertEquals(pickedMail.getMaximumDepth(), 10);
            assertTrue(pickedMail.getRecipient().equals(recipient2));
            fail("An exception should not have been thrown.");
        } catch(Exception e){
        }

    }
}