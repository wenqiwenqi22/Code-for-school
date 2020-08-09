package problem2;

import java.util.Objects;

/**
 * Artist is an abstract object that has a first name and a last name
 */
public abstract class Artist {
    private String firstName;
    private String lastName;

    /**
     * Construct an Artist object with  a first name and a last name
     * @param firstName - the first name of the Artist
     * @param lastName - the last name of the Artist
     */
    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the first name of the Artist
     * @return the first name of the Artist
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the Artist
     * @return the last name of the Artist
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Return true if two artist has the same first name and  last name
     * @param o - the object wanted to compare with
     * @return true if two artist has the same first name and  last name
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(firstName, artist.firstName) &&
                Objects.equals(lastName, artist.lastName);
    }

    /**
     * Return the hashcode for the Artist object
     * @return the hashcode for the Artist object
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    /**
     * Returns the overrided toString result of Artist object
     * @return the overrided toString result of Artist object
     */
    @Override
    public String toString() {
        return "Artist{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
