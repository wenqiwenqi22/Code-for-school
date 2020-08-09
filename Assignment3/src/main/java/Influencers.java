import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Influencers is an object with basic attributes, such as number Of Followers, name, date of birth, social media platform.
 * And other attributes like minimum required follower for journalist and professional athlete,  minimum required follower in Twitter for
 * journalist. And base impact denominator, base impact factor, over 40 factor, youtube factor, twitter factor, instagram factor,
 * age lower bound for calculate the artist's and celebrity's estimated impact.
 */
public class Influencers {
    public static final int MINIMUM_REQUIRED_FOLLOWER = 50000;
    public static final int MINIMUM_REQUIRED_FOLLOWER_IN_TWITTER = 100000;
    private Integer numberOfFollowers;
    private String name;
    private LocalDate dateOfBirth;
    private SocialMediaPlatform socialMediaPlatform;
    private Double baseImpact;
    private Double totalImpact;
    private int baseImpactDenominator;
    private double baseImpactFactor;
    private double over40Factor;
    private double youtubeFactor;
    private double twitterFactor;
    private double instagramFactor;
    private int ageLowerBound;
    private int ageUpperBound;

    /**
     * Construct an influencer object within the types of artist and celebrity.
     * @param numberOfFollowers- number of the follower of the influencer
     * @param name- the name of the influencer
     * @param dateOfBirth- the date of birth of the influencer
     * @param socialMediaPlatform- the social media platform of the influencer
     * @param baseImpactDenominator- the base impact denominator of the influencer, use to calculate the base impact
     * @param baseImpactFactor- the base impact factor of the influencer, use to calculate the base impact
     * @param over40Factor- a influencer over 40 will have the factor times their impact value
     * @param youtubeFactor- a factor will have if the influencer use youtube as the social media platform
     * @param instagramFactor - a factor will have if the influencer use instagram as the social media platform
     * @param ageLowerBound - if the influencer are artist or celebrity, age-lower-bound is 18, meaning under 18, there is no meaningful estimated impact
     * @param ageUpperBound - if the influencer are artist or celebrity, age-upper-bound is 40, meaning over 40, there is a impact discount.
     */
    public Influencers(Integer numberOfFollowers, String name, LocalDate dateOfBirth, SocialMediaPlatform socialMediaPlatform,
                       int baseImpactDenominator, double baseImpactFactor, double over40Factor, double youtubeFactor,
                       double instagramFactor, int ageLowerBound, int ageUpperBound) {
        this.numberOfFollowers = numberOfFollowers;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.socialMediaPlatform = socialMediaPlatform;
        this.baseImpactDenominator = baseImpactDenominator;
        this.baseImpactFactor = baseImpactFactor;
        this.over40Factor = over40Factor;
        this.youtubeFactor = youtubeFactor;
        this.instagramFactor = instagramFactor;
        this.ageLowerBound = ageLowerBound;
        this.ageUpperBound = ageUpperBound;
    }

    /**
     * Construct an object within the types of journalist and professional athlete.
     * @param numberOfFollowers- number of the follower of the influencer
     * @param name- the name of the influencer
     * @param dateOfBirth- the date of birth of the influencer
     * @param socialMediaPlatform- the social media platform of the influencer
     * @param baseImpactDenominator- the base impact denominator of the influencer, use to calculate the base impact
     * @param twitterFactor- a factor will have if the influencer use twitter as the social media platform
     */
    public Influencers(Integer numberOfFollowers, String name, LocalDate dateOfBirth,
                       SocialMediaPlatform socialMediaPlatform, int baseImpactDenominator, double twitterFactor) {
        this.numberOfFollowers = numberOfFollowers;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.socialMediaPlatform = socialMediaPlatform;
        this.baseImpactDenominator = baseImpactDenominator;
        this.twitterFactor = twitterFactor;
    }

    /**
     * Returns the number of the follower of the influencer
     * @return the number of the follower of the influencer
     */
    public Integer getNumberOfFollowers() {
        return numberOfFollowers;
    }

    /**
     * Returns the name of the follower of the influencer
     * @return the name of the follower of the influencer
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Returns the social media platform used by the influencer
     * @return the social media platform used by the influencer
     */
    public SocialMediaPlatform getSocialMediaPlatform() {
        return socialMediaPlatform;
    }

    /**
     * Calculate the age of the influencer
     * @param dateOfBirth - date of birth of the influencer
     * @return the age of the influencer
     */
    public int getAge(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        long duration = ChronoUnit.YEARS.between(dateOfBirth, today);

        return (int) duration;

    }

    /**
     * Calculate the base impact for calculating the total estimated impact of the influencer with the types of artist or celebrity
     * @param numberOfFollowers- number of the follower of the influencer
     * @param baseImpactDenominator- the base impact denominator of the influencer, use to calculate the base impact
     * @param baseImpactFactor- the base impact factor of the influencer, use to calculate the base impact
     * @param age - the age of the influencer
     * @return the base impact of the influencer
     * @throws ImpactEstimationException when the influencer is under 18 years old
     */
    protected Double getBaseImpact(Integer numberOfFollowers, int baseImpactDenominator, double baseImpactFactor, int age) throws ImpactEstimationException {
        if (age >= ageLowerBound) {
            baseImpact = (double) numberOfFollowers / baseImpactDenominator * baseImpactFactor;
            return baseImpact;
        }else {
            throw new ImpactEstimationException("The influencer is under 18 years old.");
        }
    }

    /**
     * Calculate the total estimated impact of the influencer with the types of artist or celebrity
     * @param baseImpact - the base impact of the influencer
     * @param age - the age of the influencer
     * @param socialMediaPlatform- the social media platform of the influencer
     * @param ageLowerBound- if the influencer are artist or celebrity, age-lower-bound is 18, meaning under 18, there is no meaningful estimated impact
     * @param ageUpperBound - if the influencer are artist or celebrity, age-upper-bound is 40, meaning over 40, there is a impact discount.
     * @param over40Factor- a influencer over 40 will have the factor times their impact value
     * @param youtubeFactor- a factor will have if the influencer use youtube as the social media platform
     * @param instagramFactor - a factor will have if the influencer use instagram as the social media platform
     * @return the total estimated impact of the influencer for influencer over or equals 18 years old.
     * @throws ImpactEstimationException when the age of the influencer is under 18 years old
     */
    protected Double estimateInfluence(Double baseImpact, int age, SocialMediaPlatform socialMediaPlatform, int ageLowerBound,
                                    int ageUpperBound, double over40Factor, double youtubeFactor, double instagramFactor) throws ImpactEstimationException {
        totalImpact = baseImpact;
        if (age >= ageLowerBound) {
            if (age > ageUpperBound) {
                totalImpact = baseImpact * over40Factor;
            }
        } else {
            throw new ImpactEstimationException("The influencer is under 18 years old.");
        }
        if (socialMediaPlatform.toString().equals("YOUTUBE")) {
            totalImpact = totalImpact * youtubeFactor;
        } else if (socialMediaPlatform.toString().equals("INSTAGRAM")) {
            totalImpact = totalImpact * instagramFactor;
        }
        return totalImpact;
    }

    /**
     * Calculate the base impact for calculating the total estimated impact of the influencer with the types of journalist or professional athlete
     * @param numberOfFollowers- number of the follower of the influencer
     * @param baseImpactDenominator- the base impact denominator of the influencer, use to calculate the base impact
     * @return the base impact of the influencer
     * @throws ImpactEstimationException when the number of followers is under 50,000.
     */
    protected Double getBaseImpact(Integer numberOfFollowers, int baseImpactDenominator) throws ImpactEstimationException{
        if(numberOfFollowers > MINIMUM_REQUIRED_FOLLOWER) {
            baseImpact = (double) numberOfFollowers / baseImpactDenominator;
            return baseImpact;
        } else {
            throw new ImpactEstimationException("The journalists/athletes haven't met the minimum required number of followers.(50000)");
        }
    }

    /**
     * Calculate the total estimated impact of the influencer with the types of journalist or professional athlete
     * @param baseImpact - the base impact of the influencer
     * @param numberOfFollowers- number of the follower of the influencer
     * @param socialMediaPlatform- the social media platform of the influencer
     * @param twitterFactor- a factor will have if the influencer use twitter as the social media platform
     * @return the total estimated impact of the influencer if the number of followers is under 50,000.
     * @throws ImpactEstimationException when the journalists/athletes haven't met the minimum required number of followers.(50000)
     */
    protected Double estimateInfluence(Double baseImpact, Integer numberOfFollowers, SocialMediaPlatform socialMediaPlatform, double twitterFactor) throws ImpactEstimationException {
        if (numberOfFollowers > MINIMUM_REQUIRED_FOLLOWER) {
            totalImpact = baseImpact;
            if (socialMediaPlatform.toString().equals("TWITTER")) {
                if (numberOfFollowers > MINIMUM_REQUIRED_FOLLOWER_IN_TWITTER) {
                    totalImpact = totalImpact * twitterFactor;
                }
            }
            return totalImpact;
        } else {
            throw new ImpactEstimationException("The journalists/athletes haven't met the minimum required number of followers.(50000)");
        }
    }

}
