import java.time.LocalDate;

/**
 * Artist is an object extends from class Influencers with basic attribute such as award, year of the last
 * movie or Tv series and gross income of their last movie or TV series.
 * And base impact denominator, base impact factor, over 40 factor, youtube factor, instagram factor,
 * age lower bound for calculate the artist's estimated impact.
 */
public class Artist extends Influencers {
    public static final int BASE_IMPACT_DENOMINATOR = 1000;
    public static final double BASE_IMPACT_FACTOR = 1.3;
    public static final double OVER_40_FACTOR = 0.55;
    public static final double YOUTUBE_FACTOR = 1.0;
    public static final double INSTAGRAM_FACTOR = 1.2;
    public static final int AGE_LOWER_BOUND = 18;
    public static final int AGE_UPPER_BOUND = 40;
    private String award;
    private Integer yearOfTheLastMovieOrTV;
    private Double grossIncomeOfTheirLastMovieOrTV;

    /**
     * Construct an artist object.
     * @param numberOfFollowers- number of the follower of the artist
     * @param name- the name of the artist
     * @param dateOfBirth- the date of birth of the artist
     * @param socialMediaPlatform- the social media platform of the artist
     * @param award- the name won by the artist
     * @param yearOfTheLastMovieOrTV- the year of the last movie or Tv series played by the artist
     * @param grossIncomeOfTheirLastMovieOrTV -  the gross income of their last movie or TV series of the artist
     */
    public Artist(Integer numberOfFollowers, String name, LocalDate dateOfBirth, SocialMediaPlatform socialMediaPlatform,
                  String award, Integer yearOfTheLastMovieOrTV, Double grossIncomeOfTheirLastMovieOrTV) {
        super(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, BASE_IMPACT_DENOMINATOR, BASE_IMPACT_FACTOR, OVER_40_FACTOR, YOUTUBE_FACTOR,
                INSTAGRAM_FACTOR, AGE_LOWER_BOUND, AGE_UPPER_BOUND);
        this.award = award;
        this.yearOfTheLastMovieOrTV = yearOfTheLastMovieOrTV;
        this.grossIncomeOfTheirLastMovieOrTV = grossIncomeOfTheirLastMovieOrTV;
    }

    /**
     * Returns the award of the artist
     * @return the award of the artist
     */
    public String getAward() {
        return this.award;
    }

    /**
     * Returns the year of the last movie or Tv series played by the artist
     * @return the year of the last movie or Tv series played by the artist
     */
    public Integer getYearOfTheLastMovieOrTV() {
        return this.yearOfTheLastMovieOrTV;
    }

    /**
     * Returns the gross income of their last movie or TV series of the artist
     * @return the gross income of their last movie or TV series of the artist
     */
    public Double getGrossIncomeOfTheirLastMovieOrTV() {
        return this.grossIncomeOfTheirLastMovieOrTV;
    }

    /**
     * Calculate the base impact for calculating the total estimated impact of the influencer with the types of artist or celebrity
     * @param numberOfFollowers- number of the follower of the influencer
     * @param age - the age of the influencer
     * @return the base impact of the influencer
     * @throws ImpactEstimationException when the influencer is under 18 years old
     */
    protected Double getBaseImpact(Integer numberOfFollowers, int age) throws ImpactEstimationException {
        return super.getBaseImpact(numberOfFollowers, BASE_IMPACT_DENOMINATOR, BASE_IMPACT_FACTOR, age);
    }

    /**
     * Calculate the total estimated impact of the influencer with the types of artist
     * @param baseImpact - the base impact of the artist
     * @param age - the age of the artist
     * @param socialMediaPlatform- the social media platform of the artist
     * @return the total estimated impact of the artist for artist over or equals 18 years old.
     * @throws ImpactEstimationException when the age of the artist is under 18 years old
     */
    public Double estimateInfluence(Double baseImpact, int age, SocialMediaPlatform socialMediaPlatform) throws ImpactEstimationException {
        return super.estimateInfluence(baseImpact, age, socialMediaPlatform, AGE_LOWER_BOUND, AGE_UPPER_BOUND, OVER_40_FACTOR , YOUTUBE_FACTOR, INSTAGRAM_FACTOR);
    }
}
