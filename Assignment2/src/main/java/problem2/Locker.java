package problem2;
/**
 * Locker is a object extends from class Item that contains maximum width, maximum height, maximum depth
 * and mail item of the object.
 */
public class Locker extends Item{
    protected MailItem mail;


    /**
     * Construct a  locker with  maximum width, maximum height, maximum depth of the locker.
     * @param maximumWidth - the  maximum width of a specific locker.
     * @param maximumHeight- the  maximum height of a specific locker.
     * @param maximumDepth- the  maximum depth of a specific locker.
     * @param mail- the mail in a specific locker.
     * @throws Exception when the width/height/depth are invalid.
     */
    public Locker(int maximumWidth, int maximumHeight, int maximumDepth, MailItem mail) throws Exception {
        super(maximumWidth, maximumHeight, maximumDepth);
        this.mail = mail;
    }

    /**
     * add the mail item in a specific locker.
     * @param mail- the mail wanted to be added in the locker.
     * @throws Exception when the locker is not null or the mail is too large to be added in the locker.
     */
    public void addMail(MailItem mail) throws Exception{
        if (this.mail != null){
            throw new Exception("The locker is occupied.");
        } else if (mail.maximumDepth > this.maximumDepth ||
                   mail.maximumHeight > this.maximumHeight ||
                   mail.maximumWidth > this.maximumWidth){
            throw new Exception("The mail is too large to be added.");
        } else {
            this.mail = mail;
        }
    }

    /**
     * pick up the mail from the locker by the corresponding recipient and remove the mail from the locker.
     * @param recipient-the corresponding recipient for the mail in the locker.
     * @return the mail in the locker
     * @throws Exception when the recipient doesn't match the recipient of the mail or when there is no mail for picking up.
     */
    public MailItem pickupMail(Recipient recipient) throws Exception{
        if (this.mail != null && this.mail.getRecipient().equals(recipient)) {
            MailItem pickedUpMail = this.mail;
            this.mail = null;
            return pickedUpMail;
        }
        throw new Exception("No mail or invalid recipient.");
    }

    /**
     * Return the mail in the locker.
     * @return the mail in the locker.
     */
    public MailItem getMail() {
        return this.mail;
    }
}
