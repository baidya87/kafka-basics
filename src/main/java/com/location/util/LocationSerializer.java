package com.location.util;

import com.location.pojo.Location;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public class LocationSerializer implements Serializer<Location> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, Location data) {
        byte[] bytes = new byte[3];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.writeBytes(data.getCity().getBytes());
        byteArrayOutputStream.writeBytes(":".getBytes());
        byteArrayOutputStream.writeBytes(String.valueOf(data.getLatitude()).getBytes());
        byteArrayOutputStream.writeBytes(":".getBytes());
        byteArrayOutputStream.writeBytes(String.valueOf(data.getLongitude()).getBytes());
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Location data) {
        return Serializer.super.serialize(topic, headers, data);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
