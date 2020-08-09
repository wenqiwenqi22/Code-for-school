import java.time.LocalDate;
/**
 * Acting Professional is an object extends from class Artist, which inherited all method from class artist
 */
public class ActingProfessional extends Artist {

    /**
     * Construct an acting professional object.
     * @param numberOfFollowers- number of the follower of the acting professional
     * @param name- the name of the acting professional
     * @param dateOfBirth- the date of birth of the acting professional
     * @param socialMediaPlatform- the social media platform of the acting professional
     * @param award- the name won by the acting professional
     * @param yearOfTheLastMovieOrTV- the year of the last movie or Tv series played by the acting professional
     * @param grossIncomeOfTheirLastMovieOrTV -  the gross income of their last movie or TV series of the acting professional
     */
    public ActingProfessional(Integer numberOfFollowers, String name, LocalDate dateOfBirth, SocialMediaPlatform socialMediaPlatform, String award, Integer yearOfTheLastMovieOrTV, Double grossIncomeOfTheirLastMovieOrTV) {
        super(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, award, yearOfTheLastMovieOrTV, grossIncomeOfTheirLastMovieOrTV);
    }
}
