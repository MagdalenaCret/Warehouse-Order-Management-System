package controller;

import dao.ClientDAO;
import gui.ClientAddView;
import model.Client;
import validate.Validator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller for add order UI page, that add orders in database based on the fields was introduced in UI
 */
public class ClientAddController {
    /**
     * The UI for add order
     */
    private ClientAddView clientAddView;
    /**
     * Client DAO used for create a client
     */
    private ClientDAO clientDAO;
    public ClientAddController()
    {
        clientAddView = new ClientAddView();
        clientDAO = new ClientDAO();

        clientAddView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientAddView.setVisible(false);
                clientAddView.dispose();

                AllClientController allClientController = new AllClientController();
            }
        });

        clientAddView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Validator.validateMail(clientAddView.getMailField().getText())) {
                    JOptionPane.showMessageDialog(null, "Invalid Mail",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (Validator.isTextFieldEmpty(clientAddView.getFirstNameFiled(), "Please fill in the text field - First Name!") == 1) {
                   return;
                }
                if (Validator.isTextFieldEmpty(clientAddView.getLastNameField(), "Please fill in the text field - Last Name!") == 1) {
                    return;
                }
                if (Validator.isTextFieldEmpty(clientAddView.getPhoneField(), "Please fill in the text field - Phone Number!") == 1) {
                    return;
                }
                if (!Validator.validateFieldLetter(clientAddView.getFirstNameFiled())) {
                    JOptionPane.showMessageDialog(null, "Invalid First Name!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!Validator.validateFieldLetter(clientAddView.getLastNameField())) {
                    JOptionPane.showMessageDialog(null, "Invalid Last Name!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!Validator.validateFieldPhone(clientAddView.getPhoneField())) {
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }



                Client client = new Client();

                // TO DO - Phone + filed-uri goale

                client.setFirstName(clientAddView.getFirstNameFiled().getText());
                client.setLastName(clientAddView.getLastNameField().getText());
                client.setEmail(clientAddView.getMailField().getText());
                client.setNumberOfPhone(clientAddView.getPhoneField().getText());

                if(clientAddView.getComboBox().getSelectedItem().toString().equals("MALE"))
                {
                    client.setGender(1);
                }
                else{
                    client.setGender(0);
                }

                clientDAO.create(client);

                clientAddView.setVisible(false);
                clientAddView.dispose();

                AllClientController allClientController = new AllClientController();
            }
        });
    }
}
