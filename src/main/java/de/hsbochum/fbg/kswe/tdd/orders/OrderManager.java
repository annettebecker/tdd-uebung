package de.hsbochum.fbg.kswe.tdd.orders;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class OrderManager {

    private final ProductDeliveryService delivery;
    private final List<Order> queuedOrders = new LinkedList<>();

    public OrderManager(ProductDeliveryService delivery) {
        this.delivery = delivery;
    }

    void submitOrder(Order o) {
        queuedOrders.add(o);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    List getQueuedOrders() {
        return queuedOrders;
    }

    void processOrders() {
        queuedOrders.sort((o1, o2) -> {
            return o2.getPriority()-o1.getPriority(); 
        });

        int size = queuedOrders.size() - 1;
        while (!queuedOrders.isEmpty()) {
            Order o = queuedOrders.get(size);
            delivery.deliver(o.getProduct(), o.getCustomer());
            queuedOrders.remove(o);
            size--;
        }
//        int size = queuedOrders.size();
//        for (int i = size-1; i >= 0; i--){
//            Order o = queuedOrders.get(i);
//            delivery.deliver(o.getProduct(), o.getCustomer());
//            queuedOrders.remove(o);
//        }
    }

}
