package dao;

import connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The AbstractDAO class provides a generic implementation of the Data Access Object (DAO) pattern.
 * This abstract class defines common CRUD operations (Create, Find All, Update, Delete) for database entities.
 * Subclasses should extend this class and implement specific operations for different entities.
 * @param <T>
 */
public class AbstractDAO<T> {

    private static final String GET_ALL_FORMAT = "SELECT * FROM %s";
    private static final String DELETE_QUERY = "DELETE FROM %s where id = %s";
    private static final String GET_BY_ID_QUERY = "SELECT * FROM %s where id = %s";
    private static final String UPDATE_BY_ID_QUERY_START = "UPDATE %s SET ";
    private static final String LAST_ID_QUERY_START = "SELECT MAX(id) as max_id FROM %s";
    private static final String INSERT_QUERY_START = "INSERT INTO %s ";
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;

    private final String typeName;

    /**
     * Constructs an AbstractDAO with the specified database connection.
     */

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        typeName = type.getSimpleName();
    }

    /**
     * Retrieves all entities from the database.
     * @return a list of all entities
     */
    public List<T> findAll() {
        String query = String.format(GET_ALL_FORMAT, typeName);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, typeName + "DAO:findAll,query=" + query + "  " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * The method take the result extracted from database query and create the java objects.
     * ResultSet is a class that contains the result from database using table form and the results are taken using an
     * iteration using the next method.
     * Using the reflection the mathod build the object T using the default constructor and the setters.
     * @param resultSet
     * @return
     */
    protected List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *  Deletes an entity from the database.
     * @param t the entity will be deleted.
     */
    public void delete(T t) {
        Connection connection = null;
        PreparedStatement statement = null;


        try {
            Object idValue = null;
            for (Field field : t.getClass().getDeclaredFields()) {
                if (field.getName().equals("id")) {
                    field.setAccessible(true);
                    idValue = field.get(t);
                }
            }

            String query = String.format(DELETE_QUERY, typeName, idValue);

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, typeName + "DAO:Delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

    }

    /**
     * Retrieves all entities from the database by id.
     * @param id entity's id
     * @return a list of all entities by id
     */

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = String.format(GET_BY_ID_QUERY, typeName, id);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, typeName + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Updates an existing entity in the database by entity's id.
     * @param id entity's id
     * @param t the entity to be updated
     */
    public void updateById(int id, T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String updateQuery = String.format(UPDATE_BY_ID_QUERY_START, typeName);
        try {

            for (Field field : type.getDeclaredFields()) {
                if (field.getName().equals("id"))
                    continue;

                updateQuery += field.getName() + "=?,";
            }

            // Sterg ultima virgula
            updateQuery = updateQuery.substring(0, updateQuery.length() - 1);
            updateQuery += " WHERE id=?";

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(updateQuery);


            int i = 1;
            for (Field field : t.getClass().getDeclaredFields()) {
                if (field.getName().equals("id"))
                    continue;

                field.setAccessible(true);
                Object value;
                value = field.get(t);
                statement.setObject(i, value);
                i++;
            }

            statement.setObject(i, id);
            statement.executeUpdate();
            return;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, typeName + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return;
    }

    /**
     * Creates a new entity in the database.
     * @param t the entity to be created
     */
    public void create(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String insertQuery = String.format(INSERT_QUERY_START, typeName);
        try {

            insertQuery += "(";
            String values = "";
            for (Field field : type.getDeclaredFields()) {
                if (field.getName().equals("id"))
                    continue;

                insertQuery += field.getName() + ",";
                values += "?,";
            }

            // Sterg ultima virgula
            insertQuery = insertQuery.substring(0, insertQuery.length() - 1);
            values = values.substring(0, values.length() - 1);

            insertQuery += ") VALUES (" + values +")";

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(insertQuery);


            int i = 1;
            for (Field field : t.getClass().getDeclaredFields()) {
                if (field.getName().equals("id"))
                    continue;

                field.setAccessible(true);
                Object value;
                value = field.get(t);
                statement.setObject(i, value);
                i++;
            }

            statement.executeUpdate();
            return;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, typeName + "DAO:create " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return;
    }

    public Integer getLastId() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String updateQuery = String.format(LAST_ID_QUERY_START, typeName);
        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(updateQuery);
            resultSet = statement.executeQuery();
            resultSet.next();

            return (Integer) resultSet.getObject("max_id");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, typeName + "DAO:getLastId " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }


}
