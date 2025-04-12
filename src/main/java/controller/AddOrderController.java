package controller;

import dao.BillDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import gui.AddOrderView;
import model.Bill;
import model.Product;
import model.WareHouseOrder;

import javax.swing.*;
import java.awt.event.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Controller for add order UI page, that add orders in database based on the fields was introduced in UI
 */
public class AddOrderController {
    /**
     * The UI for add order
     */
    private AddOrderView addOrderView;
    /**
     * The product DAO used to bring products for adding an order
     */
    private ProductDAO productDAO;
    /**
     * Order DAO used for save order
     */
    private OrderDAO orderDAO;
    /**
     * Build DAO used to create bill
     */
    private BillDAO billDAO;
    /**
     * Client id used to know for what client is order made
     */
    private Integer clientId;

    /**
     * All available products
     */
    private List<Product> products;

    public AddOrderController(Integer clientId) {
        addOrderView = new AddOrderView();
        productDAO = new ProductDAO();
        orderDAO = new OrderDAO();
        billDAO = new BillDAO();
        products = new ArrayList<>();

        for (Product product : productDAO.findAll()) {
            if (product.getQuantity() > 0) {
                products.add(product);
            }
        }

        this.clientId = clientId;

        addOrderView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrderView.setVisible(false);
                addOrderView.dispose();

                AllOrdersController allOrdersController = new AllOrdersController(clientId);
            }
        });

        for (Product product : products) {
            addOrderView.getComboBoxProducts().addItem(product.getName());
        }


        // Testez daca am produse
        if (!products.isEmpty()) {
            addOrderView.getInStockField().setText(products.get(0).getQuantity().toString());
            addOrderView.getProductPriceField().setText(products.get(0).getPrice().toString());
            addOrderView.getQuantityField().setText("1");
            addOrderView.getPayOrderPriceField().setText(products.get(0).getPrice().toString());
        }

        addOrderView.getComboBoxProducts().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedProduct = (String) e.getItem();

                    for (Product product : products) {
                        if (product.getName().equals(selectedProduct)) {
                            addOrderView.getInStockField().setText(product.getQuantity().toString());
                            addOrderView.getProductPriceField().setText(product.getPrice().toString());
                            Integer quantity = getQuantity(addOrderView.getQuantityField().getText());

                            Double totalPrice = quantity * product.getPrice();
                            addOrderView.getPayOrderPriceField().setText(totalPrice.toString());
                        }
                    }

                }
            }
        });

        addOrderView.getQuantityField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String value = addOrderView.getQuantityField().getText();
                int length = value.length();

                String valueForCalculate = addOrderView.getQuantityField().getText();
                char keyPressed = e.getKeyChar();

                // Reproduc stergerea cu backspace
                if (keyPressed == '\b') {
                    addOrderView.getQuantityField().setText(addOrderView.getQuantityField().getText().substring(0, length));

                    if (length != 0) {
                        valueForCalculate = valueForCalculate.substring(0, length);
                    }
                }
                // Accept doar numere
                else if (keyPressed >= '0' && keyPressed <= '9') {
                    addOrderView.getQuantityField().setEditable(true);
                    addOrderView.getQuantityField().setText(addOrderView.getQuantityField().getText());
                    valueForCalculate = valueForCalculate + keyPressed;
                } else {

                    /// Afisez eroare
                    JOptionPane.showMessageDialog(null, "Quantity accepts only numbers",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    addOrderView.getQuantityField().setEditable(false);
                    addOrderView.getQuantityField().setText(addOrderView.getQuantityField().getText());

                }

                String selectedProduct = addOrderView.getComboBoxProducts().getSelectedItem().toString();
                for (Product product : products) {
                    if (product.getName().equals(selectedProduct)) {
                        addOrderView.getInStockField().setText(product.getQuantity().toString());
                        addOrderView.getProductPriceField().setText(product.getPrice().toString());
                        Integer quantity = getQuantity(valueForCalculate);

                        Double totalPrice = quantity * product.getPrice();
                        addOrderView.getPayOrderPriceField().setText(totalPrice.toString());
                    }
                }
            }
        });


        addOrderView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (products.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No Products",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Product productForOrder = null;
                String selectedProduct = addOrderView.getComboBoxProducts().getSelectedItem().toString();
                for (Product product : products) {
                    if (product.getName().equals(selectedProduct)) {
                        productForOrder = product;
                    }
                }

                Integer quantity = getQuantity(addOrderView.getQuantityField().getText());
                if (quantity > productForOrder.getQuantity()) {
                    JOptionPane.showMessageDialog(null, "Order quantity > Product quantity",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                productForOrder.setQuantity(productForOrder.getQuantity() - quantity);
                productDAO.updateById(productForOrder.getId(), productForOrder);

                WareHouseOrder wareHouseOrder = new WareHouseOrder();
                wareHouseOrder.setClientId(clientId);
                wareHouseOrder.setProductId(productForOrder.getId());
                wareHouseOrder.setQuantity(quantity);

                orderDAO.create(wareHouseOrder);

                Integer idOrder = orderDAO.getLastId();

                // Convertesc data la data locala dupa zona geografica
                Bill bill = new Bill(idOrder, new Date().toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDateTime());

                billDAO.create(bill);
                addOrderView.setVisible(false);
                addOrderView.dispose();

                AllOrdersController allOrdersController = new AllOrdersController(clientId);
            }
        });
    }

    public Integer getQuantity(String string) {
        Integer quantity = 0;

        if (!string.isEmpty()) {
            quantity = Integer.parseInt(string);
        }

        return quantity;
    }
}
