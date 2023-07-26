package com.location.service;

import com.location.pojo.Location;
import com.location.util.LocationSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class LocationService {

    private final String topic;

    public LocationService(String topic){
        this.topic = topic;
    }
    public void updateLocation(String device, Location location){
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", LocationSerializer.class.getName());

        KafkaProducer<String, Location> kafkaProducer = new KafkaProducer<>(properties);
        ProducerRecord<String, Location> producerRecord = new ProducerRecord<>(topic, device, location);
        kafkaProducer.send(producerRecord);
    }
}
