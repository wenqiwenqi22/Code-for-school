package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    private Time time;

    @Before
    public void setUp() throws Exception {
        time = new Time(12,45,55);
    }

    @Test
    public void getHours() {
        assertEquals(12, time.getHours());
    }

    @Test
    public void setHours() {
        // before setting
        assertEquals(12, time.getHours());
        // after setting
        time.setHours(13);
        assertEquals(13, time.getHours());
    }

    @Test
    public void getMinutes() {
        assertEquals(45, time.getMinutes());
    }

    @Test
    public void setMinutes() {
        // before setting
        assertEquals(45, time.getMinutes());
        // after setting
        time.setMinutes(13);
        assertEquals(13, time.getMinutes());
    }

    @Test
    public void getSeconds() {
        assertEquals(55, time.getSeconds());
    }

    @Test
    public void setSeconds() {
        // before setting
        assertEquals(55, time.getSeconds());
        // after setting
        time.setSeconds(13);
        assertEquals(13, time.getSeconds());
    }

    @Test
    public void calculateDuration() {
        Time startTime = new Time(13,13,13);
        Time endTime = new Time(15,15,15);
        int durationHours = 2;
        int durationMinutes = 2;
        int durationSeconds = 2;
        Time duration = Time.calculateDuration(startTime, endTime);
        assertEquals(durationHours, duration.getHours());
        assertEquals(durationMinutes, duration.getMinutes());
        assertEquals(durationSeconds, duration.getSeconds());
    }
}