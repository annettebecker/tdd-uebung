
package de.hsbochum.fbg.kswe.tdd;

import com.vividsolutions.jts.geom.Point;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class Station {
    
    private Point location;
    private String name;

    public Station(Point location, String name) {
        this.location = location;
        this.name = name;
    }
    
    
    public double calculateDistance(Station s2){
        double dist = Math.sqrt( Math.pow(this.getLocation().getX()-s2.getLocation().getX(), 2) + 
                            Math.pow(this.getLocation().getY()-s2.getLocation().getY(), 2));
        return dist;
    }
    

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
