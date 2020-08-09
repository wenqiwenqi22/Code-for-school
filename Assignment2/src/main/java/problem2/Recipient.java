package problem2;

import java.util.Objects;

/**
 * Recipient is a class that contains first name, last name and email address.
 */
public class Recipient {
    protected String firstName;
    protected String lastName;
    protected String emailAddress;

    /**
     * Construct a recipient with first name, last name and email address.
     * @param firstName - the first name of a recipient.
     * @param lastName - the last name of a recipient.
     * @param emailAddress - the email address of a recipient.
     */
    public Recipient(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    /**
     * Override the equals method used to compare two recipient objects.
     * @param o- object, which indicate recipient.
     * @return true if all parameters is the same of two recipient object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipient recipient = (Recipient) o;
        return Objects.equals(firstName, recipient.firstName) &&
                Objects.equals(lastName, recipient.lastName) &&
                Objects.equals(emailAddress, recipient.emailAddress);
    }

    /**
     * Override the hash code method used to compare two recipient objects.
     * @return true if hash codes are the same of two recipient object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, emailAddress);
    }
}
