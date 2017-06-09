/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbochum.fbg.kswe.tdd;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Annette
 */
public class StationTest {
    
    @Test
    public void testStation(){
        GeometryFactory gf = new GeometryFactory();
        Point point = gf.createPoint(new Coordinate(10.0, 20.0));
        Station s1 = new Station(point, "test");

        Point point2 = gf.createPoint(new Coordinate(20.0, 20.0));
        Station s2 = new Station(point2, "test2");
        
        Point point3 = gf.createPoint(new Coordinate(50.0, 35.0));
        Station s3 = new Station(point3, "test3");
        
        Assert.assertThat(s1.calculateDistance(s2), CoreMatchers.is(10.0));
    }
    
    @Test
    public void testStation2(){
        TimeSeries ts = new TimeSeries("waterGauge");
        ts.addObservation(new Observation(12.2, new DateTime("2017-06-06T12:00:00+01:00")));
        ts.addObservation(new Observation(12.4, new DateTime("2017-06-06T12:30:00+01:00")));
        ts.addObservation(new Observation(14.4, new DateTime("2017-06-06T13:00:00+01:00")));        
        
        TimeSeries ts2 = new TimeSeries("test2");
        ts.addObservation(new Observation(17.2, new DateTime("2017-06-06T12:00:00+02:00")));
        ts.addObservation(new Observation(178.4, new DateTime("2017-06-06T12:30:00+02:00")));      
        
        List <TimeSeries> l = new ArrayList <>();
        l.add(ts);
        l.add(ts2);
        
        GeometryFactory gf = new GeometryFactory();
        Point point = gf.createPoint(new Coordinate(10.0, 20.0));
        Station s1 = new Station(point, "test");
                
        //Hinzufuegen einer TimeSerie
        s1.addTimeSeries(ts);
        s1.addTimeSeries(ts2);
        Assert.assertThat(s1.getTimeSeries(), CoreMatchers.is(l));
    }
    
}
