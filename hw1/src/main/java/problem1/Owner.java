/**
 * problem1 is about vehicle class and owner class and their method and attributions.
 */
package problem1;

/**
 * Owner is object that has a first name, last name, and phone number of a specific person who owns something.
 */

public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    /**
     *Constructor that creates a owner object with the specified first name,
     * last name
     * and phone number.
     * @param firstName    - first name of the new owner object.
     * @param lastName     - last name of the new owner object.
     * @param phoneNumber  - phone number of the new owner object.
     */

    public Owner(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    /**
     *Returns the first name of the owner.
     *
     * @return the first name of the owner.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the  firstName of the owner
     * @param firstName- the firstName of the owner
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *Returns the first name of the owner.
     *
     * @return the first name of the owner.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the  last name of the owner
     * @param lastName- the last name of the owner
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *Returns the phone number of the owner.
     *
     * @return the phone number of the owner.
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the  phone number of the owner
     * @param phoneNumber- the phone number of the owner
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        }
    }
}
