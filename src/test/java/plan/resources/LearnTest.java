package plan.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;
import plan.api.Event;

public class LearnTest {

    @Test
    public void testMapper() {
        ObjectMapper mapper = new ObjectMapper();
        Event event = new Event();
        System.out.println(event);
    }
}
