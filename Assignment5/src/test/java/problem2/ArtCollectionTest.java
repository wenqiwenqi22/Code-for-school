package problem2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArtCollectionTest {
    private ArtCollection artCollection;
    private ArtCollection artCollection1;
    private List<ArtItem> allItems;
    private List<ArtItem> result;
    private Painter artist1;
    private Artist artist2;
    private ArtItem artItem1;
    private ArtItem artItem2;

    @Before
    public void setUp() throws Exception {
        artist1 = new Painter("wenqi", "cao");
        artist2 = new Photographer("Junqi", "Ma");
        artItem1 = new Painting((Painter)artist1, "Rain", 2011);
        artItem2 = new Photography((Photographer) artist2, "Warald", 2012);
        allItems = new ArrayList<>();
        allItems.add(artItem1);
        artCollection = new ArtCollection(allItems);

        //empty artCollection
        artCollection1 = new ArtCollection();

    }

    @Test
    public void addItem() {

        List<ArtItem> items = artCollection.getAllItems();
        assertEquals(items.size(), 1);
        assertEquals(items.get(0), artItem1);
        artCollection.addItem(artItem2);
        assertEquals(items.size(), 2);
        assertEquals(items.get(0), artItem1);
        assertEquals(items.get(1), artItem2);

        //add item to an empty art collection
        assertEquals(artCollection1.getAllItems(), null);
        artCollection1.addItem(artItem1);
        List<ArtItem> items2 = artCollection1.getAllItems();
        assertEquals(items2.size(), 1);
        assertEquals(items2.get(0), artItem1);
    }

    @Test
    public void removeItem() {
        List<ArtItem> items = artCollection.getAllItems();
        assertEquals(items.size(), 1);
        artCollection.removeItem(artItem1);
        assertEquals(items.size(), 0);
    }

    @Test
    public void search() {
        //happy path
        String keyword = "ra";
        List<ArtItem> res = new ArrayList<>();
        res.add(artItem1);
        assertEquals(artCollection.search(keyword), res);

        //can't find keyword
        String keyword2 = "aa";
        assertEquals(artCollection.search(keyword2), new ArrayList<>());

        //search an empty art collection
        assertEquals(artCollection1.search(keyword), new ArrayList<>());
    }

    @Test
    public void testSearch() {
        List<ArtItem> res = new ArrayList<>();
        assertEquals(artCollection.search(artist2), res);
        res.add(artItem2);
        artCollection.addItem(artItem2);
        artCollection.search(artist2);
        assertEquals(artCollection.search(artist2), res);

        //search an empty art collection
        assertEquals(artCollection1.search(artist2), new ArrayList<>());

    }

    @Test
    public void testSearch1() {
        List<ArtItem> res = new ArrayList<>();
        res.add(artItem1);
        artCollection.search(artist1);
        assertEquals(artCollection.search(artist1), res);

        //search an empty art collection
        assertEquals(artCollection1.search(artist1), new ArrayList<>());
    }

    @Test
    public void testGetAllItems(){
        assertEquals(artCollection.getAllItems(), allItems);
    }

    @Test
    public void toStringTest() {
        String s = "ArtCollection{allItems=[ArtItem{artist=Artist{firstName='wenqi', lastName='cao'}, artCollective=null, title='Rain', yearOfCreation=2011}], result=null}";
        assertEquals(artCollection.toString(), s);
    }

    @Test
    public void equalsTest() throws Exception {
        assertEquals(artCollection, new ArtCollection(allItems));
    }

    @Test
    public void hashCodeTest() throws Exception {
        assertEquals(artCollection.hashCode(), new ArtCollection(allItems).hashCode());
    }
}