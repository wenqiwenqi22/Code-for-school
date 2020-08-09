package problem2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArtCollectiveTest {
    private ArtCollective artCollective;
    private String groupName;
    private List<Artist> listOfMembers;
    private Painter painter1;
    private Painter painter2;

    @Before
    public void setUp() throws Exception {
        groupName = "Golden";
        painter1 = new Painter("Lily", "Harris");
        painter2 = new Painter("Luis", "Hope");
        listOfMembers = new ArrayList<>();
        listOfMembers.add(painter1);
        listOfMembers.add(painter2);
        artCollective = new ArtCollective(groupName, listOfMembers);
    }

    @Test
    public void getGroupName() {
        assertEquals(artCollective.getGroupName(), groupName);
    }

    @Test
    public void getListOfMembers() {
        assertEquals(artCollective.getListOfMembers(), listOfMembers);
    }

    @Test
    public void equalsTest() {
        ArtCollective artCollective2 = new ArtCollective(groupName, listOfMembers);
        assertEquals(artCollective, artCollective2);
    }

    @Test
    public void hashCodeTest(){
        ArtCollective artCollective2 = new ArtCollective(groupName, listOfMembers);
        assertTrue(artCollective.hashCode() == artCollective2.hashCode());
    }

    @Test
    public void toStringTest(){
        String s = "ArtCollective{groupName='Golden', listOfMembers=[Artist{firstName='Lily', lastName='Harris'}, Artist{firstName='Luis', lastName='Hope'}]}";
        assertEquals(artCollective.toString(), s);
    }
}