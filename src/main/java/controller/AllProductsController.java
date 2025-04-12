package controller;

import dao.ProductDAO;
import gui.AllProductView;
import model.Client;
import model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 *  Controller for view products UI page
 */
public class AllProductsController {
    /**
     * The UI for add product
     */
    private AllProductView allProductView;
    /**
     * Product DAO used to save products
     */
    private ProductDAO productDAO;

    public AllProductsController() {
        allProductView = new AllProductView();
        productDAO = new ProductDAO();

        allProductView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allProductView.setVisible(false);
                allProductView.dispose();
                MainController mainController = new MainController();
            }
        });


        allProductView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allProductView.setVisible(false);
                allProductView.dispose();

                ProductAddController productAddController = new ProductAddController();
            }
        });
        showProducts();
    }

    private void showProducts() {
        List<Product> products = productDAO.findAll();
        allProductView.displayProducts(products, createViewAction(products), createDeleteAction(products));
    }

    private ActionListener createViewAction(List<Product> products) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Iau butonul care a creat ActionEvent
                JButton jButton = (JButton) e.getSource();
                Integer indexOfClient = allProductView.getViewButtons().indexOf(jButton);

                Product product = products.get(indexOfClient);
                Integer id = product.getId();

                // Trimit id-ul client-ului
                ProductViewController productViewController = new ProductViewController(id);
                allProductView.setVisible(false);
                allProductView.dispose();

            }
        };
    }

    private ActionListener createDeleteAction(List<Product> products) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Iau butonul care a creat ActionEvent
                JButton jButton = (JButton) e.getSource();
                Integer indexOfClient = allProductView.getDeleteButtons().indexOf(jButton);

                Product product = products.get(indexOfClient);

                int input = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete " + product.getName() + "?", "Delete Product",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

                // S-a apasat ok
                if (input == 0) {

                    productDAO.delete(product);
                    showProducts();
                }
            }
        };
    }
}
