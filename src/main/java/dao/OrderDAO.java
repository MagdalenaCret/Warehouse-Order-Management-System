package dao;

import connection.ConnectionFactory;
import model.WareHouseOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

/**
 * The OrderDAO class provides methods to perform CRUD operations for order entities in the database.
 * This class extends the AbstractDAO class to inherit common database access functionality.
 */
public class OrderDAO extends AbstractDAO<WareHouseOrder> {

    private static final String GET_ORDER_BY_CLIENT_ID = "SELECT * FROM WareHouseOrder WHERE clientid = %s";

    /**
     * Retrieves all orders from the database based on the ID of the client who placed the order
     * @param clientId
     * @return
     */
    public List<WareHouseOrder> findByClientId(Integer clientId) {
        String query = String.format(GET_ORDER_BY_CLIENT_ID, clientId);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "order" + "DAO:findByClientId,query=" + query + "  " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
