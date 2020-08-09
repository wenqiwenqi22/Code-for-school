import java.time.LocalDate;

/**
 * Celebrity is an object extends from class Influencers with basic attribute latest appearance event.
 * And base impact denominator, base impact factor, over 40 factor, youtube factor, instagram factor,
 * age lower bound for calculate the celebrity's estimated impact.
 */
public class Celebrity extends Influencers {
    public static final int BASE_IMPACT_DENOMINATOR = 1000;
    public static final double BASE_IMPACT_FACTOR = 1.0;
    public static final double OVER_40_FACTOR = 0.55;
    public static final double YOUTUBE_FACTOR = 0.9;
    public static final double INSTAGRAM_FACTOR = 1.2;
    public static final int AGE_LOWER_BOUND = 18;
    public static final int AGE_UPPER_BOUND = 40;
    private String latestAppearanceEvent;

    /**
     * Construct a celebrity object.
     * @param numberOfFollowers- number of the follower of the celebrity
     * @param name- the name of the celebrity
     * @param dateOfBirth- the date of birth of the celebrity
     * @param socialMediaPlatform- the social media platform of the celebrity
     * @param latestAppearanceEvent- the latest appearance event of the celebrity
     */
    public Celebrity(Integer numberOfFollowers, String name, LocalDate dateOfBirth, SocialMediaPlatform socialMediaPlatform, String latestAppearanceEvent) {
        super(numberOfFollowers, name, dateOfBirth, socialMediaPlatform,
                BASE_IMPACT_DENOMINATOR,BASE_IMPACT_FACTOR, OVER_40_FACTOR, YOUTUBE_FACTOR,
                INSTAGRAM_FACTOR, AGE_LOWER_BOUND, AGE_UPPER_BOUND);
        this.latestAppearanceEvent = latestAppearanceEvent;
    }

    /**
     * Returns the latest appearance event of the celebrity
     * @return the latest appearance event of the celebrity
     */
    public String getLatestAppearanceEvent() {
        return this.latestAppearanceEvent;
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
     * Calculate the total estimated impact of the celebrity with the types of celebrity
     * @param baseImpact - the base impact of the celebrity
     * @param age - the age of the celebrity
     * @param socialMediaPlatform- the social media platform of the influencer
     * @return the total estimated impact of the celebrity for celebrity over or equals 18 years old.
     * @throws ImpactEstimationException when the age of the celebrity is under 18 years old
     */
    protected Double estimateInfluence(Double baseImpact, int age, SocialMediaPlatform socialMediaPlatform) throws ImpactEstimationException {
        return super.estimateInfluence(baseImpact, age, socialMediaPlatform, AGE_LOWER_BOUND, AGE_UPPER_BOUND, OVER_40_FACTOR, YOUTUBE_FACTOR, INSTAGRAM_FACTOR);
    }
}
