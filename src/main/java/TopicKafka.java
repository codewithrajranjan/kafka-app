import org.apache.kafka.clients.admin.*;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class TopicKafka {

    private AdminClient adminClient;

    public TopicKafka(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
//        properties.put("group.id", "test");
//        properties.put("enable.auto.commit", true);
//        properties.put("auto.commit.interval.ms", 1000);
//        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        adminClient = AdminClient.create(properties);
    }
    public void createTopic(String topicName){
        NewTopic newTopic = new NewTopic(topicName, 10, (short) 1);
        ArrayList<NewTopic> newTopics = new ArrayList<>();
        newTopics.add(newTopic);
        CreateTopicsResult topicsResult = adminClient.createTopics(newTopics);
        //adminClient.close();
    }

    public void getAllTopics() throws ExecutionException, InterruptedException {
        ListTopicsOptions listTopicsOptions = new ListTopicsOptions();
        listTopicsOptions.listInternal(true);
        ListTopicsResult listTopicsResult = adminClient.listTopics(listTopicsOptions);

        System.out.println(listTopicsResult.names().get());

    }

}
