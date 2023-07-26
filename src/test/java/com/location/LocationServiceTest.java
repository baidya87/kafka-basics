package com.location;

import com.location.pojo.Location;
import com.location.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationServiceTest {

    private LocationService locationService;

    @BeforeEach
    public void beforeEachTest(){
        locationService = new LocationService("location.service");
    }

    @Test
    public void testUpdateLocation_with_valid_input(){
        Location location = new Location("Kolkata", 22.5726f, 88.3639f);
        locationService.updateLocation("iphone", location);
    }

    @Test
    public void testUpdateLocation2_with_valid_input(){
        Location location = new Location("Delhi", 42.5726f, 68.3639f);
        locationService.updateLocation("android", location);
    }

    @Test
    public void testUpdateLocation3_with_valid_input(){
        Location location = new Location("Mumbai", 62.5726f, 98.3639f);
        locationService.updateLocation("iphone", location);
    }

    @Test
    public void testUpdateLocation4_with_valid_input(){
        Location location = new Location("Bangalore", 32.5726f, 58.3639f);
        locationService.updateLocation("iphone", location);
    }

}
