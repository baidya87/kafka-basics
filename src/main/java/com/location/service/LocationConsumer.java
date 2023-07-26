package com.location.service;

import com.location.pojo.Location;
import com.location.util.LocationDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class LocationConsumer {

    public static void printLocation(String topic){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", LocationDeserializer.class.getName());

        properties.put("group.id", "location-service-group-1");

        KafkaConsumer<String, Location> kafkaConsumer = new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Arrays.asList("location.service"));
        try{
            while(true){
                ConsumerRecords<String, Location> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(100));
                for(ConsumerRecord consumerRecord : consumerRecords){
                    System.out.println(consumerRecord.value());
                }
            }

        }catch(Exception exception){
            exception.printStackTrace();
        }finally {
            kafkaConsumer.close();
        }
    }

    public static void main(String[] args) {
        printLocation("location.service");
    }
}
