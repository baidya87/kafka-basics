package com.location.util;

import com.location.pojo.Location;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class LocationDeserializer implements Deserializer<Location> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Location deserialize(String topic, byte[] data) {
        char[] literals = new char[data.length];
        int i=0;
        for(byte b : data){
            literals[i++] = (char) b;
        }
        String deserializedValue = String.valueOf(literals);
        String[] values = deserializedValue.split(":");
        Location location = new Location();
        location.setCity(values[0]);
        location.setLatitude(Float.valueOf(values[1]));
        location.setLongitude(Float.valueOf(values[2]));
        return location;
    }

    @Override
    public Location deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
