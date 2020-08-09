import java.time.LocalDate;

/**
 * Journalist is an object extends from class Influencers with attributes publishing company, journalistic awards.
 * base impact denominator is 27500 and twitter factor is 1.25, used for calculate the total estimated impact.
 */
public class Journalist extends Influencers {
    public static final int BASE_IMPACT_DENOMINATOR = 27500;
    public static final double TWITTER_FACTOR = 1.25;
    private String publishingCompany;
    private String journalisticAwards;

    /**
     * Construct an Journalist object .
     * @param numberOfFollowers- number of the follower of the journalist
     * @param name- the name of the journalist
     * @param dateOfBirth- the date of birth of the journalist
     * @param socialMediaPlatform- the social media platform of the journalist
     * @param publishingCompany- the publishing company of the journalist
     * @param journalisticAwards - journalistic awards of the journalist
     */
    public Journalist(Integer numberOfFollowers, String name, LocalDate dateOfBirth, SocialMediaPlatform socialMediaPlatform, String publishingCompany,
                      String journalisticAwards){
        super(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, BASE_IMPACT_DENOMINATOR, TWITTER_FACTOR);
        this.publishingCompany = publishingCompany;
        this.journalisticAwards = journalisticAwards;
    }

    /**
     * Returns the publishing company of the journalist
     * @return the publishing company of the journalist
     */

    public String getPublishingCompany() {
        return this.publishingCompany;
    }

    /**
     * Returns the journalistic awards of the journalist
     * @return the journalistic awards of the journalist
     */
    public String getJournalisticAwards() {
        return this.journalisticAwards;
    }

    /**
     * Calculate the base impact for calculating the total estimated impact of the influencer with the types of journalist or professional athlete
     * @param numberOfFollowers- number of the follower of the influencer
     * @return the base impact of the influencer
     * @throws ImpactEstimationException when the number of followers is under 50,000.
     */
    public Double getBaseImpact(Integer numberOfFollowers) throws ImpactEstimationException {
        return super.getBaseImpact(numberOfFollowers, BASE_IMPACT_DENOMINATOR);
    }

    /**
     * Calculate the total estimated impact of the influencer with the types of journalist or professional athlete
     * @param baseImpact - the base impact of the influencer
     * @param numberOfFollowers- number of the follower of the influencer
     * @param socialMediaPlatform- the social media platform of the influencer
     * @return the total estimated impact of the influencer if the number of followers is under 50,000.
     * @throws ImpactEstimationException when the number of followers is under 50,000.
     */
    public Double estimateInfluence(Double baseImpact, Integer numberOfFollowers, SocialMediaPlatform socialMediaPlatform) throws ImpactEstimationException {
        return super.estimateInfluence(baseImpact, numberOfFollowers, socialMediaPlatform, TWITTER_FACTOR);
    }
}
