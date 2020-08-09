package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CyclistTest {
    private Cyclist cyclist;
    private Time startTime;
    private Time endTime;

    @Before
    public void setUp() throws Exception {
        cyclist =  new Cyclist("aaa");
        startTime = new Time (1, 0, 1);
        endTime = new Time(4, 0, 0);
        cyclist.setStartTime(startTime);
        cyclist.setEndTime(endTime);
    }

    @Test
    public void getDuration() {
        int durationSeconds = 59;
        int durationMinutes = 59;
        int durationHours = 2;
        assertEquals(durationSeconds, cyclist.getDuration().getSeconds());
        assertEquals(durationMinutes, cyclist.getDuration().getMinutes());
        assertEquals(durationHours, cyclist.getDuration().getHours());
    }

    @Test
    public void getStartTime() {
        assertEquals(1, cyclist.getStartTime().getHours());
        assertEquals(0, cyclist.getStartTime().getMinutes());
        assertEquals(1, cyclist.getStartTime().getSeconds());
    }

    @Test
    public void setStartTime() {
        // before setting
        assertEquals(1, cyclist.getStartTime().getHours());
        assertEquals(0, cyclist.getStartTime().getMinutes());
        assertEquals(1, cyclist.getStartTime().getSeconds());
        // after setting
        int newHours = 2;
        int newMinutes = 0;
        int newSeconds = 0;
        Time newStartTime = new Time(newHours, newMinutes,newSeconds);
        cyclist.setStartTime(newStartTime);
        assertEquals(newHours, cyclist.getStartTime().getHours());
        assertEquals(newMinutes, cyclist.getStartTime().getMinutes());
        assertEquals(newSeconds, cyclist.getStartTime().getSeconds());
    }

    @Test
    public void getEndTime() {
        assertEquals(4, cyclist.getEndTime().getHours());
        assertEquals(0, cyclist.getEndTime().getMinutes());
        assertEquals(0, cyclist.getEndTime().getSeconds());
    }

    @Test
    public void setEndTime() {
        // before setting
        assertEquals(4, cyclist.getEndTime().getHours());
        assertEquals(0, cyclist.getEndTime().getMinutes());
        assertEquals(0, cyclist.getEndTime().getSeconds());
        // after setting
        int newHours = 15;
        int newMinutes = 10;
        int newSeconds = 58;
        Time newStartTime = new Time(newHours, newMinutes,newSeconds);
        cyclist.setEndTime(newStartTime);
        assertEquals(newHours, cyclist.getEndTime().getHours());
        assertEquals(newMinutes, cyclist.getEndTime().getMinutes());
        assertEquals(newSeconds, cyclist.getEndTime().getSeconds());
    }

    @Test
    public void getCyclistId() {
        assertEquals("aaa", cyclist.getCyclistId());
    }

    @Test
    public void setCyclistId() {
        // before setting
        assertEquals("aaa", cyclist.getCyclistId());
        // after setting
        cyclist.setCyclistId("bbb");
        assertEquals("bbb", cyclist.getCyclistId());
    }
}