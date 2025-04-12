package controller;

import dao.ClientDAO;
import dao.ProductDAO;
import gui.ClientView;
import gui.ProductView;
import model.Product;
import validate.Validator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controller for view details about only product in UI page
 */

public class ProductViewController {
    /**
     * The UI for add products
     */
    private ProductView productView;
    /**
     * Product DAO used for bring information about a product
     */
    private ProductDAO productDAO;
    /**
     * Used for edit a product
     */
    private Product product;

    public ProductViewController(int productId) {
        productView = new ProductView();
        productDAO = new ProductDAO();
        product = productDAO.findById(productId);

        productView.getNameFiled().setText(product.getName());
        productView.getDescriptionField().setText(product.getDescription());
        productView.getQuantityField().setText(product.getQuantity().toString());
        productView.getPriceField().setText(product.getPrice().toString());

        productView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productView.setVisible(false);
                productView.dispose();

                AllProductsController allProductsController = new AllProductsController();
            }
        });

        productView.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer quantity;
                Double price;
                try {
                    quantity = Integer.parseInt(productView.getQuantityField().getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Quantity",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    price = Double.parseDouble(productView.getPriceField().getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Price",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (quantity <=0)
                {
                    JOptionPane.showMessageDialog(null, "Quantity > 0",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (price <=0)
                {
                    JOptionPane.showMessageDialog(null, "Price > 0",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Validator.isTextFieldEmpty(productView.getNameFiled(), "Please fill in the text field - Name!") == 1) {
                    return;
                }
                if (Validator.isTextFieldEmpty(productView.getDescriptionField(), "Please fill in the text field - Description!") == 1) {
                    return;
                }



                product.setName(productView.getNameFiled().getText());
                product.setDescription(productView.getDescriptionField().getText());
                product.setQuantity(quantity);
                product.setPrice(price);

                productDAO.updateById(product.getId(), product);


                JOptionPane.showMessageDialog(null, "Update successfully",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
            }
        });


    }
}
