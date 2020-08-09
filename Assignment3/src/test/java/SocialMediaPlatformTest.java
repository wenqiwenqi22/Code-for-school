import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SocialMediaPlatformTest {


    @Test
    public void valueOf() {
        assertThat(SocialMediaPlatform.valueOf("YOUTUBE"), is(notNullValue()));
        assertThat(SocialMediaPlatform.valueOf("FACEBOOK"), is(notNullValue()));
        assertThat(SocialMediaPlatform.valueOf("INSTAGRAM"), is(notNullValue()));
        assertThat(SocialMediaPlatform.valueOf("SNAPCHAT"), is(notNullValue()));
        assertThat(SocialMediaPlatform.valueOf("TIKTOK"), is(notNullValue()));
    }
}