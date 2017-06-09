
package de.hsbochum.fbg.kswe.tdd.orders;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class OrderManagerTest {

    @Test
    public void testStation(){
        File f = new File("test.txt");
        Product p = new Product("Name", f);
        Customer c = new Customer("A", "B");
        ProductDeliveryService pds = new ProductDeliveryService();      
        OrderManager om = new OrderManager(pds);
        
        Order o = new Order(c,1,p);
        Order o2 = new Order(c,2,p);
        om.submitOrder(o);
        om.submitOrder(o2);
        
        Assert.assertThat(om.getQueuedOrders().size(), CoreMatchers.is(2));
        
        om.processOrders();
        Assert.assertThat(om.getQueuedOrders().size(), CoreMatchers.is(0));
        
        
        
    }
    
    
    
}
