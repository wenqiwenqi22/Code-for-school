import java.time.LocalDate;

/**
 * Singer is an object extends from class Artist, which inherited all method from class artist
 */
public class Singer extends Artist {


    /**
     * Construct a singer object.
     * @param numberOfFollowers- number of the follower of the singer
     * @param name- the name of the singer
     * @param dateOfBirth- the date of birth of the singer
     * @param socialMediaPlatform- the social media platform of the singer
     * @param award- the name won by the singer
     * @param yearOfTheLastMovieOrTV- the year of the last movie or Tv series played by the singer
     * @param grossIncomeOfTheirLastMovieOrTV -  the gross income of their last movie or TV series of the singer
     */
    public Singer(Integer numberOfFollowers, String name, LocalDate dateOfBirth, SocialMediaPlatform socialMediaPlatform, String award, int yearOfTheLastMovieOrTV, double grossIncomeOfTheirLastMovieOrTV) {
        super(numberOfFollowers, name, dateOfBirth, socialMediaPlatform, award, yearOfTheLastMovieOrTV, grossIncomeOfTheirLastMovieOrTV);
    }
}
