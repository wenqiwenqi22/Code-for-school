package problem2;

/**
 * Painting is an object that extends ArtItem class and has all the methods of ArtItem
 */
public class Painting extends ArtItem {

    /**
     * Constructs a painting object with a painter, a title, and a year of creation of the painting
     * @param painter- the painter of the painting
     * @param title - the title of the painting
     * @param yearOfCreation - the year of creation of the painting
     */
    public Painting(Painter painter, String title, Integer yearOfCreation) {
        super(painter, title, yearOfCreation);
    }

    /**
     * Constructs an painting object with an artCollective, a title, a year of creation
     * @param artCollective- the group of artists of the painting
     * @param title - the title of the painting
     * @param yearOfCreation - the year of creation of the painting
     */
    public Painting(ArtCollective artCollective, String title, Integer yearOfCreation) {
        super(artCollective, title, yearOfCreation);
    }


}
