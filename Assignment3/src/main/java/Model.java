import java.time.LocalDate;

/**
 * Model is an object extends from class Celebrity, which inherited all method from class Celebrity
 */
public class Model extends Celebrity{

    /**
     * Construct a Model object.
     * @param numberOfFollowers- number of the follower of the Model
     * @param name- the name of the Model
     * @param dateOfBirth- the date of birth of the Model
     * @param socialMediaPlatform- the social media platform of the Model
     * @param latestAppearanceEvent- the latest appearance event of the Model
     */
    public Model(Integer numberOfFollowers, String name, LocalDate dateOfBirth, SocialMediaPlatform socialMediaPlatform, String latestAppearanceEvent) {
        super(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, latestAppearanceEvent);
    }
}
