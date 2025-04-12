package controller;

import dao.OrderDAO;
import dao.ProductDAO;
import gui.AddOrderView;
import gui.AllOrdersView;
import model.WareHouseOrder;
import model.Product;
import view.OrderView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *  Controller for view orders UI page
 */
public class AllOrdersController {
    /**
     * The UI for add order
     */
    private AllOrdersView allOrdersView;
    /**
     * Order DAO used for save orders
     */
    private OrderDAO orderDAO;
    /**
     * Product DAO used to bring the details about a client
     */
    private ProductDAO productDAO;
    /**
     * Client id used to know for what client is order made
     */
    private Integer clientId;

    public AllOrdersController(Integer idClient) {
        allOrdersView = new AllOrdersView();
        orderDAO = new OrderDAO();
        productDAO = new ProductDAO();
        clientId = idClient;

        allOrdersView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allOrdersView.setVisible(false);
                allOrdersView.dispose();
                ClientViewController clientViewController = new ClientViewController(idClient);
            }
        });


        allOrdersView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allOrdersView.setVisible(false);
                allOrdersView.dispose();

                AddOrderController addOrderController = new AddOrderController(clientId);
            }
        });
        showOrders();
    }

    private void showOrders() {
        List<WareHouseOrder> orders = orderDAO.findByClientId(clientId);

        List<OrderView> orderViews = new ArrayList<>();

        Double allPrice = 0.0;
        for(WareHouseOrder order: orders)
        {
            Product product = productDAO.findById(order.getProductId());
            OrderView orderView = new OrderView();
            orderView.setQuantity(order.getQuantity());
            orderView.setProductName(product.getName());

            Double price = order.getQuantity() * product.getPrice();
            orderView.setOrderPrice(price);


            orderViews.add(orderView);
            allPrice += price;

        }

        allOrdersView.displayOrders(orderViews, createDeleteAction(orders));
    }

    private ActionListener createDeleteAction(List<WareHouseOrder> orders) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Iau butonul care a creat ActionEvent
                JButton jButton = (JButton) e.getSource();
                Integer indexOfOrder = allOrdersView.getDeleteButtons().indexOf(jButton);

                WareHouseOrder order = orders.get(indexOfOrder);

                int input = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete the order?", "Delete Order",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

                // S-a apasat ok
                if (input == 0) {

                    Product product = productDAO.findById(order.getProductId());
                    product.setQuantity(product.getQuantity() + order.getQuantity());
                    productDAO.updateById(product.getId(), product);

                    orderDAO.delete(order);
                    showOrders();
                }
            }
        };
    }
}
