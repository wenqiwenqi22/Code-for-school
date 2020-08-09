import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JournalistTest {
    private Journalist journalist;
    private Journalist journalist2;
    private Integer numberOfFollowers = 7500000;
    private Integer numberOfFollowers2 = 7500;
    private String name = "Yamiche";
    private LocalDate dateOfBirth = LocalDate.of(1987,2,21);
    private SocialMediaPlatform socialMediaPlatform = SocialMediaPlatform.valueOf("TWITTER");
    private String publishingCompany = "NBC";
    private String journalisticAwards = "Shorty";

    @Before
    public void setUp() throws ImpactEstimationException {

        journalist = new Journalist(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, publishingCompany, journalisticAwards);
        journalist2 = new Journalist(numberOfFollowers2, name, dateOfBirth, socialMediaPlatform, publishingCompany, journalisticAwards);
    }

    @Test
    public void getNumberOfFollowers() {
        assertEquals(journalist.getNumberOfFollowers(), numberOfFollowers);
    }

    @Test
    public void getDateOfBirth() {
        assertEquals(journalist.getDateOfBirth(), dateOfBirth);
    }

    @Test
    public void getSocialMediaPlatform() {
        assertEquals(journalist.getSocialMediaPlatform(), socialMediaPlatform);
    }

    @Test
    public void getAge() {
        assertEquals(journalist.getAge(dateOfBirth), 33);
    }

    @Test
    public void getPublishingCompany() {
        assertEquals(journalist.getPublishingCompany(), publishingCompany);
    }

    @Test
    public void getJournalisticAwards() {
        assertEquals(journalist.getJournalisticAwards(), journalisticAwards);
    }

    @Test
    public void getBaseImpact() throws ImpactEstimationException {
        try {
            double baseImpact = journalist.getBaseImpact(journalist.getNumberOfFollowers());
            assertEquals(baseImpact, 272.7, 0.1);
        }catch (ImpactEstimationException e) {
            fail("An exception should not have been thrown.");
        }
    }

    @Test(expected = ImpactEstimationException.class)
    public void getBaseImpactFail() throws ImpactEstimationException {
        journalist2.getBaseImpact(journalist2.getNumberOfFollowers());

    }

    @Test
    public void estimateInfluence() throws ImpactEstimationException {
        try {
            double baseImpact = journalist.getBaseImpact(journalist.getNumberOfFollowers());
            assertEquals(journalist.estimateInfluence(baseImpact,journalist.getNumberOfFollowers(), socialMediaPlatform), 340.9, 0.1);
        }catch (ImpactEstimationException e) {
            fail("An exception should not have been thrown.");
        }
    }

    @Test(expected = ImpactEstimationException.class)
    public void estimateInfluenceFail() throws ImpactEstimationException {
        double baseImpact = journalist2.getBaseImpact(journalist2.getNumberOfFollowers());
        journalist2.estimateInfluence(baseImpact, journalist2.getNumberOfFollowers(), socialMediaPlatform);

    }
}