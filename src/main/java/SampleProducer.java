import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SampleProducer {

    public SampleProducer() {


        //constructing the message that is needed to be sent
        String topicName = "user-data";
        ProducerRecord producerRecord = new ProducerRecord(topicName, "name", "selftuts");

        String ipAddress = "localhost";
        String port = "9092";
        Properties properties = new Properties();
        properties.put("bootstrap.servers",  ipAddress.concat(":").concat(port));
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // creating the instance of kafka producer
        KafkaProducer kafkaProducer = new KafkaProducer<>(properties);
        kafkaProducer.send(producerRecord);
        kafkaProducer.close();

    }
}
