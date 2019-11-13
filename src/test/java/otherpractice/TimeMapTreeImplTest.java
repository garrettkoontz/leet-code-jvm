package otherpractice;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TimeMapTreeImplTest {

    private static long nowUTC() {
        return LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    @Test
    void get() throws InterruptedException {
        TimeMapTreeImpl<String, String> theDoctor = new TimeMapTreeImpl<>();
        long now1 = nowUTC();
        theDoctor.put("firstKey", "first value");
        Thread.sleep(100);
        long now2 = nowUTC();
        Thread.sleep(100);
        theDoctor.put("firstKey", "second value");
        Thread.sleep(100);
        long now3 = nowUTC();
        assertNull(theDoctor.get("firstKey", now1));
        assertEquals("first value", theDoctor.get("firstKey", now2));
        assertEquals("second value", theDoctor.get("firstKey", now3));
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void containsKey() {
    }

    @Test
    void containsKeyAtTime() {
    }

    @Test
    void containsValue() {
    }

    @Test
    void containsValueAtTime() {
    }

    @Test
    void testGet() {
    }

    @Test
    void put() {
    }

    @Test
    void remove() {
    }

    @Test
    void putAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void keySet() {
    }

    @Test
    void keySetAtTime() {
    }

    @Test
    void values() {
    }

    @Test
    void testValues() {
    }

    @Test
    void entrySet() {
    }

    @Test
    void testEntrySet() {
    }
}