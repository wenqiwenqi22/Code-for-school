import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class RealityStarTest {
    private RealityStar realityStar;
    private RealityStar realityStar2;
    private Integer numberOfFollowers = 50000000;
    private String name = "Kim";
    private LocalDate dateOfBirth = LocalDate.of(1980,10,21);
    private LocalDate dateOfBirth2 = LocalDate.of(2009,10,21);
    private SocialMediaPlatform socialMediaPlatform = SocialMediaPlatform.valueOf("INSTAGRAM");
    private String latestAppearanceEvent = "Oscar";
    private int age;

    @Before
    public void setUp() throws Exception {
        realityStar = new RealityStar(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, latestAppearanceEvent);
        realityStar2 = new RealityStar(numberOfFollowers, name, dateOfBirth2, socialMediaPlatform, latestAppearanceEvent);
    }


    @Test
    public void getLatestAppearanceEvent() {
        assertEquals(realityStar.getNumberOfFollowers(), numberOfFollowers);
    }
    @Test
    public void getNumberOfFollowers() {
        assertEquals(realityStar.getNumberOfFollowers(), numberOfFollowers);
    }

    @Test
    public void getDateOfBirth() {
        assertEquals(realityStar.getDateOfBirth(), dateOfBirth);
    }

    @Test
    public void getSocialMediaPlatform() {
        assertEquals(realityStar.getSocialMediaPlatform(), socialMediaPlatform);
    }

    @Test
    public void getAge() {
        assertEquals(realityStar.getAge(dateOfBirth), 39);
    }

    @Test
    public void getBaseImpact() throws ImpactEstimationException {
        assertEquals(realityStar.getBaseImpact(numberOfFollowers, 30), 50000, 0.0);
    }

    @Test(expected = ImpactEstimationException.class)
    public void getBaseImpactFail() throws ImpactEstimationException {
        realityStar.getBaseImpact(numberOfFollowers,10);
    }

    @Test
    public void estimateInfluence() throws ImpactEstimationException{
        int age = realityStar.getAge(dateOfBirth);
        Double baseImpact = realityStar.getBaseImpact(numberOfFollowers,age);
        assertEquals(realityStar.estimateInfluence(baseImpact, age, socialMediaPlatform), 60000, 0.0);
    }

    @Test(expected = ImpactEstimationException.class)
    public void estimateInfluenceFail() throws ImpactEstimationException{
        int age2 = realityStar2.getAge(realityStar2.getDateOfBirth());
        Double baseImpact2 = realityStar2.getBaseImpact(numberOfFollowers, age);
        realityStar2.estimateInfluence(baseImpact2, age2, socialMediaPlatform);
    }

    @Test
    public void estimateInfluenceOver40() throws ImpactEstimationException{
        LocalDate dateOfBirth3 = LocalDate.of(1969,12,13);
        RealityStar realityStar3 = new RealityStar(numberOfFollowers, name, dateOfBirth3, socialMediaPlatform, latestAppearanceEvent);
        int age3 = realityStar3.getAge(realityStar3.getDateOfBirth());
        Double baseImpact = realityStar3.getBaseImpact(numberOfFollowers,45);
        assertEquals(realityStar3.estimateInfluence(baseImpact, age3, socialMediaPlatform), 33000, 0.0);
    }

}