import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ModelTest {
    
    private Model model;
    private Model model2;
    private Integer numberOfFollowers = 50000000;
    private String name = "Kate";
    private LocalDate dateOfBirth = LocalDate.of(1980,1,16);
    private LocalDate dateOfBirth2 = LocalDate.of(2009,1,16);
    private SocialMediaPlatform socialMediaPlatform = SocialMediaPlatform.valueOf("INSTAGRAM");
    private String latestAppearanceEvent = "Fashion show";
    private int age;

    @Before
    public void setUp() throws Exception {
        model = new Model(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, latestAppearanceEvent);
        model2 = new Model(numberOfFollowers, name, dateOfBirth2, socialMediaPlatform, latestAppearanceEvent);
    }


    @Test
    public void getLatestAppearanceEvent() {
        assertEquals(model.getNumberOfFollowers(), numberOfFollowers);
    }
    @Test
    public void getNumberOfFollowers() {
        assertEquals(model.getNumberOfFollowers(), numberOfFollowers);
    }

    @Test
    public void getDateOfBirth() {
        assertEquals(model.getDateOfBirth(), dateOfBirth);
    }

    @Test
    public void getSocialMediaPlatform() {
        assertEquals(model.getSocialMediaPlatform(), socialMediaPlatform);
    }

    @Test
    public void getAge() {
        assertEquals(model.getAge(dateOfBirth), 40);
    }

    @Test
    public void getBaseImpact() throws ImpactEstimationException {
        assertEquals(model.getBaseImpact(numberOfFollowers, 30), 50000, 0.0);
    }

    @Test(expected = ImpactEstimationException.class)
    public void getBaseImpactFail() throws ImpactEstimationException {
        model.getBaseImpact(numberOfFollowers, 10);
    }

    @Test
    public void estimateInfluence() throws ImpactEstimationException{
        int age = model.getAge(dateOfBirth);
        Double baseImpact = model.getBaseImpact(numberOfFollowers, age);
        assertEquals(model.estimateInfluence(baseImpact, age, socialMediaPlatform), 60000, 0.0);
    }

    @Test(expected = ImpactEstimationException.class)
    public void estimateInfluenceFail() throws ImpactEstimationException{
        int age2 = model2.getAge(model2.getDateOfBirth());
        Double baseImpact2 = model2.getBaseImpact(numberOfFollowers, age);
        model2.estimateInfluence(baseImpact2, age2, socialMediaPlatform);
    }

    @Test
    public void estimateInfluenceOver40() throws ImpactEstimationException{
        LocalDate dateOfBirth3 = LocalDate.of(1974,1,16);
        Model model3 = new Model(numberOfFollowers, name, dateOfBirth3, socialMediaPlatform, latestAppearanceEvent);
        int age3 = model3.getAge(model3.getDateOfBirth());
        Double baseImpact = model3.getBaseImpact(numberOfFollowers, 45);
        assertEquals(model3.estimateInfluence(baseImpact, age3, socialMediaPlatform), 33000, 0.0);
    }
}