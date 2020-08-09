package problem2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaintingTest {
    private Painting painting1;
    private Painting painting2;
    private Painter painter;
    private  String title;
    private  Integer yearOfCreation;
    private ArtCollective artCollective;
    private String groupName;
    private List<Artist> listOfMembers;

    @Before
    public void setUp() throws Exception {
        painter = new Painter("Angle", "Chen");
        title = "Hearts";
        yearOfCreation = 2014;
        painting1 = new Painting(painter, title, yearOfCreation);

        groupName = "Golden";
        listOfMembers = new ArrayList<>();
        listOfMembers.add(new Painter("wenqi", "cao"));
        artCollective = new ArtCollective(groupName, listOfMembers);
        painting2 = new Painting(artCollective, title, yearOfCreation);
    }

    @Test
    public void getArtist() {
        assertEquals(painting1.getArtist(),painter);
    }

    @Test
    public void getArtCollective() {
        assertEquals(painting2.getArtCollective().getGroupName(), groupName);
        assertEquals(painting2.getArtCollective().getListOfMembers(), listOfMembers);
    }

    @Test
    public void getTitle() {
        assertEquals(painting1.getTitle(), title);
    }

    @Test
    public void getYearOfCreation() {
        assertEquals(painting1.getYearOfCreation(), yearOfCreation);
    }
    @Test
    public void testEquals() {
        assertEquals(painting1, new Painting(painter, title, yearOfCreation));
    }

    @Test
    public void testHashCode() {
        assertEquals(painting1.hashCode(), new Painting(painter, title, yearOfCreation).hashCode());
    }

    @Test
    public void testToString() {
        String s = "ArtItem{artist=Artist{firstName='Angle', lastName='Chen'}, artCollective=null, title='Hearts', yearOfCreation=2014}";
        assertEquals(painting1.toString(), s);
    }

}