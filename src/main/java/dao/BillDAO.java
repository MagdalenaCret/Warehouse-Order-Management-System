package dao;

import connection.ConnectionFactory;
import model.Bill;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The BillDAO class provides an implementation of the Data Access Object (DAO) pattern.
 * This class definesoperations (Create, Find All) for bills.
 * This class was implemented separately with the create and find all methods
 * and did not extend the class AbstractDAO, like the other DAO classes, in order to prevent updates and deletions from being performed on it.
 */
public class BillDAO {

    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private static final String INSERT_BILL = "INSERT INTO log (orderid, generatedDate) VALUES (?, ?)";
    private static final String GET_ALL_BILL = "SELECT * FROM log";

    /**
     * Creates a new bill in the database.
     * @param bill
     */

    public void create(Bill bill) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(INSERT_BILL);

            statement.setObject(1, bill.orderId());
            statement.setObject(2, bill.generatedDate());
            statement.executeUpdate();
            return;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "BillDAO:create " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    /**
     * Retrieves all bills from the database.
     * @return
     */
    public List<Bill> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(GET_ALL_BILL);
            resultSet = statement.executeQuery();

            List<Bill> bills = new ArrayList<>();

            while (resultSet.next()) {
                Integer idOrder = (Integer) resultSet.getObject("orderid");
                LocalDateTime generatedDate = (LocalDateTime) resultSet.getObject("generatedDate");

                bills.add(new Bill(idOrder, generatedDate));
            }

            return bills;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "BillDAO:findAll,query=" + GET_ALL_BILL + "  " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
