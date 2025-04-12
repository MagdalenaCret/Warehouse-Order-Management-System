package model;

/**
 * The Product class represents a product entity in the system.
 * This class stores information such as product id, name, description, quantity and price.
 */
public class Product {

    protected Integer id;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;

    /**\
     *  Returns the id of the product.
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the name of the product.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the quantity of the product.
     * @return
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Returns the price of the product.
     * @return
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Set the id for the product.
     * @param id
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Set the name for the product.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the quantity for the product.
     * @param quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Set the price for the product.
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Returns the description of the product.
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description for the product.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method returns a string representation of the product.
     * @return a string representation of the product
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}