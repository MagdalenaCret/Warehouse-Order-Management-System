package controller;

import dao.BillDAO;
import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import gui.AllBillView;
import gui.MainView;
import model.Bill;
import model.Client;
import model.Product;
import model.WareHouseOrder;
import view.BillView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for view bill UI page
 */
public class AllBillsController {
    /**
     * The UI for add bill
     */
    private AllBillView allBillView;
    /**
     * The order DAO used to bring information about orders
     */
    private OrderDAO orderDAO;
    /**
     * Product DAO used for adding products
     */
    private ProductDAO productDAO;
    /**
     * Order DAO used for save bills
     */
    private BillDAO billDAO;

    /**
     *  Product DAO used for adding details about clients
     */
    private ClientDAO clientDAO;


    public AllBillsController() {
        allBillView = new AllBillView();
        orderDAO = new OrderDAO();
        productDAO = new ProductDAO();
        billDAO = new BillDAO();
        clientDAO = new ClientDAO();

        allBillView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allBillView.setVisible(false);
                allBillView.dispose();
                MainController mainController = new MainController();
            }
        });

        showBills();
    }

    private void showBills() {

        List<Bill> bills = billDAO.findAll();
        List<BillView> billViews = new ArrayList<>();

        for (Bill bill : bills) {
            WareHouseOrder wareHouseOrder = orderDAO.findById(bill.orderId());
            if(wareHouseOrder!=null)
            {
                BillView billView = new BillView();

                billView.setQuantity(wareHouseOrder.getQuantity());
                billView.setGeneratedDate(bill.generatedDate());

                Client client = clientDAO.findById(wareHouseOrder.getClientId());
                Product product = productDAO.findById(wareHouseOrder.getProductId());

                billView.setFirstName(client.getFirstName());
                billView.setLastName(client.getLastName());
                billView.setMail(client.getEmail());
                billView.setProductName(product.getName());

                billView.setPrice(product.getPrice() * wareHouseOrder.getQuantity());
                billViews.add(billView);
            }
        }

        allBillView.displayBills(billViews);
    }
}
