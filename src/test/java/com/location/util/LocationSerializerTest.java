package com.location.util;

import com.location.pojo.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationSerializerTest {

    private  LocationSerializer locationSerializer;
    private LocationDeserializer locationDeserializer;

    @BeforeEach
    public void beforeEachTest(){
        locationSerializer = new LocationSerializer();
        locationDeserializer = new LocationDeserializer();
    }

    @Test
    public void testSerialize(){

        byte[] bytes = locationSerializer.serialize("iphone", new Location("Mumbai", 23.44f, 25.88f));
        /*for (byte b : bytes) {
            if(':' == (char) b) {
                System.out.println();
                continue;
            }
            System.out.print((char)b);
        }*/

        Location location = locationDeserializer.deserialize("iphone", bytes);
        Assertions.assertNotNull(location);
        Assertions.assertEquals(23.44f, location.getLatitude());
        Assertions.assertEquals(25.88f, location.getLongitude());
        Assertions.assertEquals("Mumbai", location.getCity());
    }

}
