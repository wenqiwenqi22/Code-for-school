package problem2;
/**
 * MailItem is a object extends from class Item that contains maximum width, maximum height, maximum depth
 * and recipient of the object.
 */
public class MailItem extends Item{
    private Recipient recipient;

    /**
     * Construct a mail item with  maximum width, maximum height, maximum depth of the mail item .
     * @param maximumWidth - the  maximum width of a specific mail item .
     * @param maximumHeight- the  maximum height of a specific mail item .
     * @param maximumDepth- the  maximum depth of a specific mail item .
     * @param recipient- the recipient of a specific mail item .
     * @throws Exception when the width/height/depth are invalid.
     */
    public MailItem(int maximumWidth, int maximumHeight, int maximumDepth, Recipient recipient) throws Exception{
        super(maximumWidth, maximumHeight, maximumDepth);
        this.recipient = recipient;
    }

    /**
     * Returns the recipient of the mail item.
     * @return the recipient of the mail item.
     */
    public Recipient getRecipient() {
        return recipient;
    }
}
