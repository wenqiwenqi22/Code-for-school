package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MailItemTest {
    private MailItem mailItem;
    private Recipient recipient;
    protected int maximumWidth = 20;
    protected int maximumHeight = 13;
    protected int maximumDepth = 21;

    @Before
    public void setUp() throws Exception {
        recipient = new Recipient("WENQI", "CAO", "CWQ@123.COM");
        mailItem = new MailItem(maximumWidth, maximumHeight, maximumDepth, recipient);
    }

    @Test
    public void getMaximumWidth() {
        assertEquals(mailItem.getMaximumWidth(), maximumWidth);
    }

    @Test
    public void getMaximumHeight() {
        assertEquals(mailItem.getMaximumHeight(), maximumHeight);
    }

    @Test
    public void getMaximumDepth() {
        assertEquals(mailItem.getMaximumDepth(), maximumDepth);
    }

    @Test
    public void getRecipient() {
        assertEquals(mailItem.getRecipient().firstName, "WENQI");
        assertEquals(mailItem.getRecipient().lastName, "CAO");
        assertEquals(mailItem.getRecipient().emailAddress, "CWQ@123.COM");
    }
}