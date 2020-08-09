import java.time.LocalDate;

/**
 * Reality star is an object extends from class Celebrity, which inherited all method from class Celebrity
 */
public class RealityStar extends Celebrity {

    /**
     * Construct a reality star object.
     *
     * @param numberOfFollowers     - number of the follower of the reality star
     * @param name                  - the name of the reality star
     * @param dateOfBirth           - the date of birth of the reality star
     * @param socialMediaPlatform   - the social media platform of the reality star
     * @param latestAppearanceEvent - the latest appearance event of the reality star
     */
    public RealityStar(Integer numberOfFollowers, String name, LocalDate dateOfBirth, SocialMediaPlatform socialMediaPlatform, String latestAppearanceEvent) {
        super(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, latestAppearanceEvent);
    }


}
