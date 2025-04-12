package model;

import java.util.Date;

/**
 * The WareHouseOrder class represents an order entity in the system.
 * This class stors information such as order id, product id, client id, date of order and quantity.
 */
public class WareHouseOrder {
    private Integer id;
    private Integer productId;

    private Integer clientId;

    private Integer quantity;

    public WareHouseOrder()
    {

    }

    /**
     * Returns the id of the order
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the id for the order
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the product id for the order
     * @return
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Set the product id for the order
     * @param productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * Returns the client id for order
     * @return
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * Set the client id for order
     * @param clientId
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * Returns the quntity of order
     * @return
     */

    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity for order
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the order.
     * @return a string representation of the order
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productId=" + productId +
                ", clientId=" + clientId +
                '}';
    }
}
