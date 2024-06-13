package com.example.SpingJPATest.Common;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGenericRepository<T, ID> implements GenericRepository<T, ID> {

    protected Connection connection;
    protected String tableName;

    public AbstractGenericRepository(Connection connection, String tableName) {
        this.connection = connection;
        this.tableName = tableName;
    }

    @Override
    public T findById(ID id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public void save(T entity) {
        String sql = generateInsertSQL();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            setInsertParameters(statement, entity);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        String sql = generateUpdateSQL();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            setUpdateParameters(statement, entity);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(ID id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected abstract String generateInsertSQL();

    protected abstract String generateUpdateSQL();

    protected abstract void setInsertParameters(PreparedStatement statement, T entity) throws SQLException;

    protected abstract void setUpdateParameters(PreparedStatement statement, T entity) throws SQLException;

    protected String getTableName() {
        return tableName;
    }

    protected Connection getConnection() {
        return connection;
    }
}
