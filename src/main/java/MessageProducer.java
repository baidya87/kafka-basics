import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class MessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageProducer.class);
    public static void produce(){
        LOGGER.info("Producing to kafka topic ..");
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("cat.dogs.stories", "cat", "Amazing cats on the neighbourhood");
        ProducerRecord<String, String> producerRecord2 = new ProducerRecord<>("cat.dogs.stories", "dog", "DOG stuck on the roof...");

        kafkaProducer.send(producerRecord);
        kafkaProducer.send(producerRecord2);

        kafkaProducer.close();
    }

    public static void main(String[] args) {
        produce();
    }


}
