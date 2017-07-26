package org.baeldung.service.impl;

import org.baeldung.performancemonitor.Coordinate;
import org.baeldung.service.CoordinateService;

/**
 * Created by xinrui on 26/07/2017.
 */
public class CoordinateServiceImpl implements CoordinateService {

    @Override
    public Double getLatitude(Coordinate coordinate) {
        return coordinate.getLatitude()+1;
    }

    @Override
    public Double getLongitude(Coordinate coordinate) {
        return coordinate.getLongitude()+1;
    }
}
