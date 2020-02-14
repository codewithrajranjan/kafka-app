import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class SampleConsumer {

    public SampleConsumer(){
        String ipAddress = "localhost";
        String port = "9092";
        String groupId = "test";
        String topicId = "user-data";
        String keyDeSerializer = "org.apache.kafka.common.serialization.StringDeserializer";
        String valueDeSerializer = "org.apache.kafka.common.serialization.StringDeserializer";

        Properties properties = new Properties();
        properties.put("bootstrap.servers", ipAddress.concat(":").concat(port));
        properties.put("key.deserializer", keyDeSerializer);
        properties.put("value.deserializer", valueDeSerializer);
        properties.put("group.id", groupId);

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Collections.singletonList(topicId));
        while(true){
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for(ConsumerRecord<String, String> record : records){
                System.out.println("key : ".concat(record.key()).concat("--").concat("value :").concat(record.value()));
            }
        }

    }
}
