package org.baeldung.performancemonitor;

/**
 * Created by xinrui on 26/07/2017.
 */
public class Coordinate {
    private Double latitude;
    private Double longitude;

    public Coordinate(Double latitude, Double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
