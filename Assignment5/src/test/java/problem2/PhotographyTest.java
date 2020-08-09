package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhotographyTest {
    private Photography photography;
    private Photographer photographer;
    private  String title;
    private  Integer yearOfCreation;


    @Before
    public void setUp() throws Exception {
        photographer = new Photographer("Amy", "Chen");
        title = "One";
        yearOfCreation = 2012;
        photography = new Photography(photographer, title, yearOfCreation);

    }

    @Test
    public void getArtist() {
        assertEquals(photography.getArtist(), photographer);
    }


    @Test
    public void getTitle() {
        assertEquals(photography.getTitle(), title);
    }

    @Test
    public void getYearOfCreation() {
        assertEquals(photography.getYearOfCreation(), yearOfCreation);
    }

    @Test
    public void testEquals() {
        assertEquals(photography, new Photography(photographer, title, yearOfCreation));
    }

    @Test
    public void testHashCode() {
        assertEquals(photography.hashCode(), new Photography(photographer, title, yearOfCreation).hashCode());
    }

    @Test
    public void testToString() {
        String s = "ArtItem{artist=Artist{firstName='Amy', lastName='Chen'}, artCollective=null, title='One', yearOfCreation=2012}";
        assertEquals(photography.toString(), s);
    }
}