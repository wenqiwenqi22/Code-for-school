import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class SingerTest {
    private Singer singer;
    private Singer singer2;
    private Integer numberOfFollowers = 50000000;
    private String name = "Taylor";
    private LocalDate dateOfBirth = LocalDate.of(1989,12,13);
    private LocalDate dateOfBirth2 = LocalDate.of(2009,12,13);
    private SocialMediaPlatform socialMediaPlatform = SocialMediaPlatform.valueOf("INSTAGRAM");
    private String award = "grammys";
    private Integer yearOfTheLastMovieOrTV = 2019;
    private Double grossIncomeOfTheirLastMovieOrTV = 10000000.0;
    private int age;
    @Before
    public void setUp() throws Exception {
        singer = new Singer(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, award,
                             yearOfTheLastMovieOrTV, grossIncomeOfTheirLastMovieOrTV);
        singer2 = new Singer(numberOfFollowers, name, dateOfBirth2, socialMediaPlatform, award,
                yearOfTheLastMovieOrTV, grossIncomeOfTheirLastMovieOrTV);
    }

    @Test
    public void getAward() {
        assertEquals(singer.getAward(), award);
    }

    @Test
    public void getYearOfTheLastMovieOrTV() {
        assertEquals(singer.getYearOfTheLastMovieOrTV(), yearOfTheLastMovieOrTV);
    }

    @Test
    public void getGrossIncomeOfTheirLastMovieOrTV() {
        assertEquals(singer.getGrossIncomeOfTheirLastMovieOrTV(), grossIncomeOfTheirLastMovieOrTV, 0.0);
    }

    @Test
    public void getNumberOfFollowers() {
        assertEquals(singer.getNumberOfFollowers(), numberOfFollowers);
    }

    @Test
    public void getDateOfBirth() {
        assertEquals(singer.getDateOfBirth(), dateOfBirth);
    }

    @Test
    public void getSocialMediaPlatform() {
        assertEquals(singer.getSocialMediaPlatform(), socialMediaPlatform);
    }

    @Test
    public void getAge() {
        assertEquals(singer.getAge(dateOfBirth), 30);
    }

    @Test
    public void getBaseImpact() throws ImpactEstimationException {
        assertEquals(singer.getBaseImpact(numberOfFollowers, 30), 65000, 0.0);
    }

    @Test(expected = ImpactEstimationException.class)
    public void getBaseImpactFail() throws ImpactEstimationException {
        singer2.getBaseImpact(numberOfFollowers, 10);
    }

    @Test
    public void estimateInfluence() throws ImpactEstimationException{
        int age = singer.getAge(dateOfBirth);
        Double baseImpact = singer.getBaseImpact(numberOfFollowers, age);
        assertEquals(singer.estimateInfluence(baseImpact, age, socialMediaPlatform), 78000, 0.0);
    }

    @Test(expected = ImpactEstimationException.class)
    public void estimateInfluenceFail() throws ImpactEstimationException{
        int age2 = singer2.getAge(singer2.getDateOfBirth());
        Double baseImpact2 = singer2.getBaseImpact(numberOfFollowers, age);
        singer2.estimateInfluence(baseImpact2, age2, socialMediaPlatform);
    }

    @Test
    public void estimateInfluenceOver40() throws ImpactEstimationException{
        LocalDate dateOfBirth3 = LocalDate.of(1969,12,13);
        Singer singer3 = new Singer(numberOfFollowers, name, dateOfBirth3, socialMediaPlatform, award,
        yearOfTheLastMovieOrTV, grossIncomeOfTheirLastMovieOrTV);
        int age3 = singer3.getAge(singer3.getDateOfBirth());
        Double baseImpact = singer3.getBaseImpact(numberOfFollowers, 45);
        assertEquals(singer3.estimateInfluence(baseImpact, age3, socialMediaPlatform), 42900, 0.0);
    }
}