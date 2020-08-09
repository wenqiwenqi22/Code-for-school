package problem2;

import java.util.Objects;

/**
 * ArtItem is an object with creator, it is either an artist or an art collective. It also has a title, and the year of creation.
 */
public abstract class ArtItem {
    private Artist artist;
    private ArtCollective artCollective;
    private String title;
    private Integer yearOfCreation;

    /**
     * Constructs an ArtItem object with an artist, a title, a year of creation
     * @param artist - the artist for the specific ArtItem
     * @param title - the title for the specific ArtItem
     * @param yearOfCreation - the  year of creation for the specific ArtItem
     */
    public ArtItem(Artist artist, String title, Integer yearOfCreation) {
        this.artist = artist;
        this.title = title;
        this.yearOfCreation = yearOfCreation;
        this.artCollective = null;
    }

    /**
     * Constructs an ArtItem object with an artCollective, a title, a year of creation
     * @param artCollective- the group of artists of the ArtItem
     * @param title - the title of the ArtItem
     * @param yearOfCreation - the year of creation of the ArtItem
     */
    public ArtItem(ArtCollective artCollective, String title, Integer yearOfCreation) {
        this.artCollective = artCollective;
        this.title = title;
        this.yearOfCreation = yearOfCreation;
        this.artist = null;
    }

    /**
     * Returns the artist of the specific ArtItem
     * @return the artist of the specific ArtItem
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * Returns the ArtCollective of the specific ArtItem
     * @return the ArtCollective of the specific ArtItem
     */
    public ArtCollective getArtCollective() {
        return artCollective;
    }

    /**
     * Returns the title of the specific ArtItem
     * @return the title of the specific ArtItem
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the year of creation of the specific ArtItem
     * @return the year of creation of the specific ArtItem
     */
    public Integer getYearOfCreation() {
        return yearOfCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtItem artItem = (ArtItem) o;
        return Objects.equals(artist, artItem.artist) &&
                Objects.equals(artCollective, artItem.artCollective) &&
                Objects.equals(title, artItem.title) &&
                Objects.equals(yearOfCreation, artItem.yearOfCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, artCollective, title, yearOfCreation);
    }

    @Override
    public String toString() {
        return "ArtItem{" +
                "artist=" + artist +
                ", artCollective=" + artCollective +
                ", title='" + title + '\'' +
                ", yearOfCreation=" + yearOfCreation +
                '}';
    }
}
