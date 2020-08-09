import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ActingProfessionalTest {

    private ActingProfessional actingProfessional;
    private ActingProfessional actingProfessional2;
    private Integer numberOfFollowers = 5000000;
    private String name = "Nicole";
    private LocalDate dateOfBirth = LocalDate.of(1989,6,20);
    private LocalDate dateOfBirth2 = LocalDate.of(2009,6,20);
    private SocialMediaPlatform socialMediaPlatform = SocialMediaPlatform.valueOf("YOUTUBE");
    private String award = "oscar";
    private Integer yearOfTheLastMovieOrTV = 2017;
    private Double grossIncomeOfTheirLastMovieOrTV = 5000000.0;
    private int age;
    @Before
    public void setUp() throws Exception {
        actingProfessional = new ActingProfessional(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, award,
                yearOfTheLastMovieOrTV, grossIncomeOfTheirLastMovieOrTV);
        actingProfessional2 = new ActingProfessional(numberOfFollowers, name, dateOfBirth2, socialMediaPlatform, award,
                yearOfTheLastMovieOrTV, grossIncomeOfTheirLastMovieOrTV);
    }

    @Test
    public void getAward() {
        assertEquals(actingProfessional.getAward(), award);
    }

    @Test
    public void getYearOfTheLastMovieOrTV() {
        assertEquals(actingProfessional.getYearOfTheLastMovieOrTV(), yearOfTheLastMovieOrTV);
    }

    @Test
    public void getGrossIncomeOfTheirLastMovieOrTV() {
        assertEquals(actingProfessional.getGrossIncomeOfTheirLastMovieOrTV(), grossIncomeOfTheirLastMovieOrTV, 0.0);
    }

    @Test
    public void getNumberOfFollowers() {
        assertEquals(actingProfessional.getNumberOfFollowers(), numberOfFollowers);
    }

    @Test
    public void getDateOfBirth() {
        assertEquals(actingProfessional.getDateOfBirth(), dateOfBirth);
    }

    @Test
    public void getSocialMediaPlatform() {
        assertEquals(actingProfessional.getSocialMediaPlatform(), socialMediaPlatform);
    }

    @Test
    public void getAge() {
        assertEquals(actingProfessional.getAge(dateOfBirth), 30);
    }

    @Test
    public void getBaseImpact() throws ImpactEstimationException {
        assertEquals(actingProfessional.getBaseImpact(numberOfFollowers, 30), 6500, 0.0);
    }

    @Test(expected = ImpactEstimationException.class)
    public void getBaseImpactFail() throws ImpactEstimationException {
        actingProfessional2.getBaseImpact(numberOfFollowers, 10);
    }

    @Test
    public void estimateInfluence() throws ImpactEstimationException{
        Double baseImpact = actingProfessional.getBaseImpact(numberOfFollowers, 30);
        int age = actingProfessional.getAge(dateOfBirth);
        assertEquals(actingProfessional.estimateInfluence(baseImpact, age, socialMediaPlatform), 6500, 0.0);
    }

    @Test(expected = ImpactEstimationException.class)
    public void estimateInfluenceFail() throws ImpactEstimationException{
        int age2 = actingProfessional2.getAge(actingProfessional2.getDateOfBirth());
        Double baseImpact2 = actingProfessional2.getBaseImpact(numberOfFollowers, age2);
        actingProfessional2.estimateInfluence(baseImpact2, age2, socialMediaPlatform);
    }

    @Test
    public void estimateInfluenceOver40() throws ImpactEstimationException{
        LocalDate dateOfBirth3 = LocalDate.of(1967,6,20);
        ActingProfessional actingProfessional3 = new ActingProfessional(numberOfFollowers, name, dateOfBirth3, socialMediaPlatform, award,
                yearOfTheLastMovieOrTV, grossIncomeOfTheirLastMovieOrTV);
        int age3 = actingProfessional3.getAge(actingProfessional3.getDateOfBirth());
        Double baseImpact = actingProfessional3.getBaseImpact(numberOfFollowers, age3);
        assertEquals(actingProfessional3.estimateInfluence(baseImpact, age3, socialMediaPlatform), 3575, 0.1);
    }

}