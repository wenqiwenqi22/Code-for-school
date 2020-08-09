package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ArtCollection is an object that has a list of all art items
 */
public class ArtCollection {
    private List<ArtItem> allItems;
    private List<ArtItem> result;

    /**
     * Constructs an ArtCollection object with a list of all art items
     *
     * @param allItems - a list of all art items
     */
    public ArtCollection(List<ArtItem> allItems) {
        this.allItems = allItems;
    }

    /**
     * Constructs an empty ArtCollection object
     */
    public ArtCollection() {
    }

    /**
     * Adds a specific art item to the ArtCollection object
     *
     * @param item -  a specific art item wanted to add in the ArtCollection object
     */
    public void addItem(ArtItem item) {
        if (allItems == null || allItems.isEmpty()) {
            allItems = new ArrayList<>();
        }
        allItems.add(item);
    }

    /**
     * Removes a specific art item from the ArtCollection object
     *
     * @param item- a specific art item wanted to remove from the ArtCollection object
     */
    public void removeItem(ArtItem item) {
        if (allItems.contains(item)) {
            allItems.remove(item);
        }
    }

    /**
     * Searches and returns a list of art items which titles contains a specific string as a keyword
     *
     * @param keyword -  a specific string wanted to search
     * @return a list of art items which titles contains a specific string as a keyword
     */
    // insensitive to upper/lower case
    public List<ArtItem> search(String keyword) {
        result = new ArrayList<>();
        if (allItems != null && !allItems.isEmpty()) {
            for (int i = 0; i < allItems.size(); i++) {
                String title = allItems.get(i).getTitle().toLowerCase();
                if (title.contains(keyword.toLowerCase())) {
                    result.add(allItems.get(i));
                }
            }
            return result;
        }
        return result;

    }

    /**
     * Searches and returns a list of art items which created by a specific artist
     *
     * @param artist - the specific artist that wanted to search
     * @return a list of art items which created by a specific artist
     */
    public List<ArtItem> search(Artist artist) {
        result = new ArrayList<>();
        if (allItems != null && !allItems.isEmpty()) {
            for (int i = 0; i < allItems.size(); i++) {
                ArtItem artItem = allItems.get(i);
                // if the art item is a photography, it is definitely has an artist
                //or if the getArtist doesn't return null, it has an artist
                if (artItem instanceof Photography || artItem.getArtist() != null) {
                    if (artist.equals(artItem.getArtist())) {
                        result.add(artItem);
                    }
                    //otherwise it has an artCollective
                }else {
                    ArtCollective artCollective = artItem.getArtCollective();
                    if (artCollective == null) {
                        return result;
                    }
                    List<Artist> artistList = artCollective.getListOfMembers();
                    if (artistList == null) {
                        return result;
                    }
                    for (int j = 0; j < artistList.size(); j++) {
                        if (artistList.get(i).equals(artist)) {
                            result.add(artItem);
                        }
                    }
                }
            }
            return result;
        }
        return result;
    }


    /**
     * Searches and returns a list of art items which created by a specific painter
     *
     * @param painter - the specific painter that wanted to search
     * @return a list of art items which created by a specific painter
     */
    public List<ArtItem> search(Painter painter) {
        result = new ArrayList<>();
        if (allItems != null && !allItems.isEmpty()) {
            for (int i = 0; i < allItems.size(); i++) {
                ArtItem artItem = allItems.get(i);
                // if the artist is not null, meaning painter is not created by art collective
                if (artItem.getArtist() != null && painter.equals(artItem.getArtist())) {
                    result.add(artItem);
                } else {// if the artist is null, meaning it is created by art collective
                    ArtCollective artCollective = artItem.getArtCollective();
                    List<Artist> artistList = artCollective.getListOfMembers();
                    if (artistList == null) {
                        return result;
                    }
                    for (int j = 0; j < artistList.size(); j++) {
                        if (artistList.get(i).equals(painter)) {
                            result.add(artItem);
                        }
                    }
                }
                return result;
            }
        }
        return result;
    }

    /**
     * Returns a list of all art items in the art collection object
     * @return a list of all art items in the art collection object
     */
    public List<ArtItem> getAllItems(){
        return this.allItems;
    }

    /**
     * Returns true if two ArtCollection objects are equal
     * @param o the object that wanted to compare
     * @return true if two ArtCollection objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtCollection that = (ArtCollection) o;
        return Objects.equals(allItems, that.allItems) &&
                Objects.equals(result, that.result);
    }

    /**
     * Returns the hashcode of the object
     * @return the hashcode of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(allItems, result);
    }

    /**
     * Returns the String format of the object
     * @return the String format of the object
     */
    @Override
    public String toString() {
        return "ArtCollection{" +
                "allItems=" + allItems +
                ", result=" + result +
                '}';
    }
}
