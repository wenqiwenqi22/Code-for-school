import java.time.LocalDate;

/**
 * Professional Athlete is an object extends from class Influencers with attributes sport, professional league and last season earning.
 * base impact denominator is 25000 and twitter factor is 1, used for calculate the total estimated impact.
 */
public class ProfessionalAthlete extends Influencers {
    public static final int BASE_IMPACT_DENOMINATOR = 25000;
    public static final double TWITTER_FACTOR = 1.0;
    private String sport;
    private String professionalLeague;
    private Double lastSeasonEarning;

    /**
     *Construct an Professional Athlete object .
     * @param numberOfFollowers- number of the follower of the athlete
     * @param name- the name of the athlete
     * @param dateOfBirth- the date of birth of the athlete
     * @param socialMediaPlatform- the social media platform of the athlete
     * @param sport- the sport played by the athlete
     * @param professionalLeague- the professional league of the athlete
     * @param lastSeasonEarning- the last season earning of the athlete
     */
    public ProfessionalAthlete(Integer numberOfFollowers, String name, LocalDate dateOfBirth, SocialMediaPlatform socialMediaPlatform, String sport,
                               String professionalLeague, Double lastSeasonEarning){
        super(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, BASE_IMPACT_DENOMINATOR, TWITTER_FACTOR);
        this.sport = sport;
        this.professionalLeague = professionalLeague;
        this.lastSeasonEarning = lastSeasonEarning;
    }

    /**
     * Returns the sport played by the athlete
     * @return the sport played by the athlete
     */
    public String getSport() {
        return this.sport;
    }

    /**
     * Returns the professional league of the athlete
     * @return the professional league of the athlete
     */
    public String getProfessionalLeague() {
        return this.professionalLeague;
    }

    /**
     * Returns the last season earning of the athlete
     * @return the last season earning of the athlete
     */
    public Double getLastSeasonEarning() {
        return this.lastSeasonEarning;
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
