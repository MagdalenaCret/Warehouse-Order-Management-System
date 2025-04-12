package controller;

import dao.ClientDAO;
import dao.ProductDAO;
import gui.ClientAddView;
import gui.ProductAddView;
import model.Client;
import model.Product;
import validate.Validator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controller for add product UI page, that add products in database based on the fields was introduced in UI
 */
public class ProductAddController {
    /**
     * The UI for add product
     */
    private ProductAddView productAddView;
    /**
     * Client DAO used for create a product
     */
    private ProductDAO productDAO;
    public ProductAddController()
    {
        productAddView = new ProductAddView();
        productDAO = new ProductDAO();

        productAddView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productAddView.setVisible(false);
                productAddView.dispose();

                AllProductsController allProductsController = new AllProductsController();
            }
        });

        productAddView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer quantity;
                Double price;
                try {
                    quantity = Integer.parseInt(productAddView.getQuantityField().getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Quantity",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    price = Double.parseDouble(productAddView.getPriceField().getText());
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
                if (Validator.isTextFieldEmpty(productAddView.getNameFiled(), "Please fill in the text field - Name!") == 1) {
                    return;
                }
                if (Validator.isTextFieldEmpty(productAddView.getDescriptionField(), "Please fill in the text field - Description!") == 1) {
                    return;
                }




                Product product = new Product();
                product.setName(productAddView.getNameFiled().getText());
                product.setDescription(productAddView.getDescriptionField().getText());
                product.setQuantity(quantity);
                product.setPrice(price);

                productDAO.create(product);

                productAddView.setVisible(false);
                productAddView.dispose();

                AllProductsController allProductsController = new AllProductsController();
            }
        });
    }
}
