import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    public static void consumer(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", StringDeserializer.class.getName());
        properties.put("group.id", "group-1");
        properties.put("auto.offset.reset", "earliest");
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Arrays.asList("cat.dog.stories"));

        while(true){
            LOGGER.info("Polling ...");
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> consumerRecord : records){
                LOGGER.info("TOPIC: {} KEY: {} VALUE: {} PARTITION: {}", consumerRecord.topic(), consumerRecord.key(), consumerRecord.value(), consumerRecord.partition());
                System.out.printf("TOPIC: {%s} KEY: {%s} VALUE: {%s} \n", consumerRecord.topic(), consumerRecord.key(), consumerRecord.value());
            }

        }
    }

    public static void main(String[] args) {
        consumer();
    }
}
