import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProfessionalAthleteTest {
    private ProfessionalAthlete professionalAthlete;
    private ProfessionalAthlete professionalAthlete2;
    private Integer numberOfFollowers = 7500000;
    private Integer numberOfFollowers2 = 7500;
    private String name = "Tom";
    private LocalDate dateOfBirth = LocalDate.of(1991,8,7);
    private SocialMediaPlatform socialMediaPlatform = SocialMediaPlatform.valueOf("TWITTER");
    private String sport = "baseball";
    private String professionalLeague = "Los Angeles";
    private Double lastSeasonEarning = 5000000.0;

    @Before
    public void setUp() throws ImpactEstimationException {
        professionalAthlete = new ProfessionalAthlete(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, sport, professionalLeague, lastSeasonEarning);
        professionalAthlete2 = new ProfessionalAthlete(numberOfFollowers2, name, dateOfBirth, socialMediaPlatform, sport, professionalLeague, lastSeasonEarning);

    }

    @Test
    public void getSport() {
        assertEquals(professionalAthlete.getSport(), sport);
    }
    @Test
    public void getProfessionalLeague() {
        assertEquals(professionalAthlete.getProfessionalLeague(), professionalLeague);
    }
    @Test
    public void getLastSeasonEarning() {
        assertEquals(professionalAthlete.getLastSeasonEarning(), lastSeasonEarning);
    }

    @Test
    public void getNumberOfFollowers() {
        assertEquals(professionalAthlete.getNumberOfFollowers(), numberOfFollowers);
    }

    @Test
    public void getDateOfBirth() {
        assertEquals(professionalAthlete.getDateOfBirth(), dateOfBirth);
    }

    @Test
    public void getSocialMediaPlatform() {
        assertEquals(professionalAthlete.getSocialMediaPlatform(), socialMediaPlatform);
    }

    @Test
    public void getAge() {
        assertEquals(professionalAthlete.getAge(dateOfBirth), 28);
    }

  

    @Test
    public void getBaseImpact() throws ImpactEstimationException {
        try {
            double baseImpact = professionalAthlete.getBaseImpact(professionalAthlete.getNumberOfFollowers());
            assertEquals(baseImpact, 300, 0.1);
        }catch (ImpactEstimationException e) {
            fail("An exception should not have been thrown.");
        }
    }

    @Test(expected = ImpactEstimationException.class)
    public void getBaseImpactFail() throws ImpactEstimationException {
        professionalAthlete2.getBaseImpact(professionalAthlete2.getNumberOfFollowers());

    }

    @Test
    public void estimateInfluence() throws ImpactEstimationException {
        try {
            double baseImpact = professionalAthlete.getBaseImpact(professionalAthlete.getNumberOfFollowers());
            assertEquals(professionalAthlete.estimateInfluence(baseImpact,professionalAthlete.getNumberOfFollowers(), socialMediaPlatform), 300, 0.1);
        }catch (ImpactEstimationException e) {
            fail("An exception should not have been thrown.");
        }
    }

    @Test(expected = ImpactEstimationException.class)
    public void estimateInfluenceFail() throws ImpactEstimationException {
        double baseImpact = professionalAthlete2.getBaseImpact(professionalAthlete2.getNumberOfFollowers());
        professionalAthlete2.estimateInfluence(baseImpact, professionalAthlete2.getNumberOfFollowers(), socialMediaPlatform);

    }
}