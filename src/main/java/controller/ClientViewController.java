package controller;

import dao.ClientDAO;
import gui.AllClientsView;
import gui.ClientView;
import model.Client;
import validate.Validator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
/**
 * Controller for view details about only client in UI page
 */

public class ClientViewController {
    /**
     * The UI for add clients
     */
    private ClientView clientView;
    /**
     * Client DAO used for bring information about a client
     */
    private ClientDAO clientDAO;
    /**
     * Used for edit a client
     */
    private Client client;

    public ClientViewController(int clientId) {
        clientView = new ClientView();
        clientDAO = new ClientDAO();
        client = clientDAO.findById(clientId);

        clientView.getFirstNameFiled().setText(client.getFirstName());
        clientView.getLastNameField().setText(client.getLastName());
        clientView.getMailField().setText(client.getEmail());
        clientView.getPhoneField().setText(client.getNumberOfPhone());

        if (client.getGender() == 0) {
            clientView.getImageGenderField().setIcon(new ImageIcon(getClass().getResource("/woman_view.png")));
        } else {
            clientView.getImageGenderField().setIcon(new ImageIcon(getClass().getResource("/man_view.png")));
        }

        clientView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientView.setVisible(false);
                clientView.dispose();

                AllClientController allClientController = new AllClientController();
            }
        });

        clientView.getViewOrdersButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientView.setVisible(false);
                clientView.dispose();

                AllOrdersController allOrdersController = new AllOrdersController(client.getId());
            }
        });

        clientView.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Validator.validateMail(clientView.getMailField().getText())) {
                    JOptionPane.showMessageDialog(null, "Invalid Mail",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Validator.isTextFieldEmpty(clientView.getFirstNameFiled(), "Please fill in the text field - First Name!") == 1) {
                    return;
                }
                if (Validator.isTextFieldEmpty(clientView.getLastNameField(), "Please fill in the text field - Last Name!") == 1) {
                    return;
                }
                if (Validator.isTextFieldEmpty(clientView.getPhoneField(), "Please fill in the text field - Phone Number!") == 1) {
                    return;
                }
                if (!Validator.validateFieldLetter(clientView.getFirstNameFiled())) {
                    JOptionPane.showMessageDialog(null, "Invalid First Name!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!Validator.validateFieldLetter(clientView.getLastNameField())) {
                    JOptionPane.showMessageDialog(null, "Invalid Last Name!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!Validator.validateFieldPhone(clientView.getPhoneField())) {
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }




                client.setFirstName(clientView.getFirstNameFiled().getText());
                client.setLastName(clientView.getLastNameField().getText());
                client.setEmail(clientView.getMailField().getText());
                client.setNumberOfPhone(clientView.getPhoneField().getText());

                clientDAO.updateById(client.getId(), client);


                JOptionPane.showMessageDialog(null, "Update successfully",
                        "INFO", JOptionPane.INFORMATION_MESSAGE);
            }
        });


    }
}
