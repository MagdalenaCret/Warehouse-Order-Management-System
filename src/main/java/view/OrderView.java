package view;

import java.util.Date;

/**
 * OrderView is a class that contains information about orders and it's products for sanding the information to UI components.
 */
public class OrderView {

    private String productName;

    private Double orderPrice;

    private Integer quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
