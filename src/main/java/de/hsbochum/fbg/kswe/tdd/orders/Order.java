
package de.hsbochum.fbg.kswe.tdd.orders;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class Order {

    
    private final Customer customer;
    private final int priority;
    private final Product product;

    public Order(Customer customer, int priority, Product product) {
        this.customer = customer;
        this.priority = priority;
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getPriority() {
        return priority;
    }

    public Product getProduct() {
        return product;
    }
    
    @Override
    public String toString() {
        return "Order{" + "customer=" + customer + ", priority=" + priority + ", product=" + product + '}';
    }
    

}
