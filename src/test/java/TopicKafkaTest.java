import org.apache.kafka.common.internals.Topic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopicKafkaTest {
    TopicKafka topicKafka;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        topicKafka = new TopicKafka();
    }

    @Test
    public void testShouldCreateATopicInKafka(){
        topicKafka.createTopic("test-topic");
    }


    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}