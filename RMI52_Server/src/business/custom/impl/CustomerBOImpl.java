/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom.impl;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.DAOTypes;
import dao.custom.CustomerDAO;
import dao.custom.QueryDAO;
import db.DBConnection;
import dto.CustomDTO;
import dto.CustomerDTO;
import entity.CustomEntity;
import entity.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sanu
 */
public class CustomerBOImpl implements CustomerBO {

    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);
    QueryDAO qdo = (QueryDAO) DAOFactory.getInstance().getDAO(DAOTypes.QUERY);

    public boolean addCustomer(CustomerDTO c) throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dao.setConnection(connection);
            return dao.add(new Customer(c.getId(), c.getName(), c.getAddress(), c.getSalary()));
        }
    }

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dao.setConnection(connection);
            return dao.delete(id);
        }

    }

    public boolean updateCustomer(CustomerDTO c) throws SQLException, ClassNotFoundException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dao.setConnection(connection);
            return dao.update(new Customer(c.getId(), c.getName(), c.getAddress(), c.getSalary()));
        }
    }

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dao.setConnection(connection);
            Customer c = dao.search(id);
            return new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary());
        }
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException, Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            dao.setConnection(connection);
            ArrayList<Customer> all = dao.getAll();
            ArrayList<CustomerDTO> allCus = new ArrayList();
            for (Customer c : all) {
                allCus.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress(), c.getSalary()));
            }
            return allCus;
        }
    }

    @Override
    public ArrayList<CustomDTO> getAllCustomerItemDetails() throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            qdo.setConnection(connection);
            ArrayList<CustomEntity> allCustomerItemDetails = qdo.getAllCustomerItemDetails();
            ArrayList<CustomDTO> allCustomDetails = new ArrayList();
            for (CustomEntity a : allCustomerItemDetails) {
                allCustomDetails.add(new CustomDTO(a.getName(), a.getCode(), a.getDescription(), a.getUnitPrice()));
            }
            return allCustomDetails;
        }
    }
}
