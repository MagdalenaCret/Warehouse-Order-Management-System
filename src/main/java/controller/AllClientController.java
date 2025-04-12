package controller;

import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import gui.AllClientsView;
import model.Client;
import model.Product;
import model.WareHouseOrder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * Controller for view client UI page
 */

public class AllClientController {
    /**
     * The UI for add product
     */
    private AllClientsView allClientsView;
    /**
     * Client DAO used for save clients
     */
    private ClientDAO clientDAO;
    /**
     * Order DAO used for delete order in case that a client was deleted
     */
    private OrderDAO orderDAO;
    /**
     * Product DAO used to update quantity for products when a client was deleted, implicit the order of this client was deleted
     */
    private ProductDAO productDAO;

    public AllClientController() {
        allClientsView = new AllClientsView();
        clientDAO = new ClientDAO();
        orderDAO = new OrderDAO();
        productDAO = new ProductDAO();

        allClientsView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allClientsView.setVisible(false);
                allClientsView.dispose();
                MainController mainController = new MainController();
            }
        });


        allClientsView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allClientsView.setVisible(false);
                allClientsView.dispose();

                ClientAddController clientAddController = new ClientAddController();
            }
        });
        showClients();
    }

    private void showClients() {
        List<Client> clients = clientDAO.findAll();
        allClientsView.displayClients(clients, createViewAction(clients), createDeleteAction(clients));
    }

    private ActionListener createViewAction(List<Client> clients) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Iau butonul care a creat ActionEvent
                JButton jButton = (JButton) e.getSource();
                Integer indexOfClient = allClientsView.getViewButtons().indexOf(jButton);

                Client client = clients.get(indexOfClient);
                Integer id = client.getId();

                // Trimit id-ul client-ului
                ClientViewController clientViewController = new ClientViewController(id);
                allClientsView.setVisible(false);
                allClientsView.dispose();

            }
        };
    }

    private ActionListener createDeleteAction(List<Client> clients) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Iau butonul care a creat ActionEvent
                JButton jButton = (JButton) e.getSource();
                Integer indexOfClient = allClientsView.getDeleteButtons().indexOf(jButton);

                Client client = clients.get(indexOfClient);

                int input = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete " + client.getFirstName() + "?", "Delete Client",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

                // S-a apasat ok
                if (input == 0) {


                    List<WareHouseOrder> orders = orderDAO.findByClientId(client.getId());
                    for (WareHouseOrder order : orders) {
                        Product product = productDAO.findById(order.getProductId());
                        product.setQuantity(product.getQuantity() + order.getQuantity());
                        productDAO.updateById(product.getId(), product);
                        orderDAO.delete(order);
                    }

                    clientDAO.delete(client);
                    showClients();
                }
            }
        };
    }
}
