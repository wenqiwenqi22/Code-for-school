package problem2;

/**
 * Photography is an object that extends ArtItem class and has all the methods of ArtItem
 */
public class Photography extends ArtItem {

    /**
     * Constructs a photography object with a photographer, a title, and a year of creation of the photography
     * @param photographer- the photographer of the photography
     * @param title - the title of the photography
     * @param yearOfCreation - the year of creation of the photography
     */
    public Photography(Photographer photographer, String title, Integer yearOfCreation) {
        super(photographer, title, yearOfCreation);
    }
}
