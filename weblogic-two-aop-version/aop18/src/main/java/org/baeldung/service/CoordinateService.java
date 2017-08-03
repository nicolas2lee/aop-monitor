package org.baeldung.service;

import org.baeldung.performancemonitor.Coordinate;

/**
 * Created by xinrui on 26/07/2017.
 */
public interface CoordinateService {
    public Double getLatitude(Coordinate coordinate);
    public Double getLongitude(Coordinate coordinate);
}
