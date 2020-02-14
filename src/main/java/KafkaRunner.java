import java.util.concurrent.ExecutionException;

public class KafkaRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //SampleProducer sampleProducer = new SampleProducer();
        //SampleConsumer sampleConsumer = new SampleConsumer();
        TopicKafka topicKafka = new TopicKafka();
        topicKafka.createTopic("india");
        topicKafka.getAllTopics();
    }
}
