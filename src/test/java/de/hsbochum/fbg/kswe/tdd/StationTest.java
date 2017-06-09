/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbochum.fbg.kswe.tdd;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.hamcrest.CoreMatchers;
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
         
         Assert.assertThat(s1.calculateDistance(s3), CoreMatchers.is(42.72));
        
        
        
    }
    
}
