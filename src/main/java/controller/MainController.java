package controller;

import gui.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * UI principal page
 */

public class MainController {

    private MainView mainView;

    /**
     * UI page with all clients, all products and all bills, depending on which one is accessed through the corresponding button
     */
    public MainController() {
        mainView = new MainView();

        mainView.getClientsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setVisible(false);
                mainView.dispose();
                AllClientController allClientController = new AllClientController();
            }
        });

        mainView.getProductsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setVisible(false);
                mainView.dispose();
                AllProductsController allProductsController = new AllProductsController();
            }
        });

        mainView.getBillsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setVisible(false);
                mainView.dispose();
                AllBillsController allBillsController = new AllBillsController();
            }
        });
    }

}
