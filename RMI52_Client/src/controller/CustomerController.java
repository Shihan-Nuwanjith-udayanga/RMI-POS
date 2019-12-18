/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connector.ProxyHandler;
import dto.CustomDTO;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import service.custom.CustomerService;

/**
 *
 * @author sanu
 */
public class CustomerController {

    CustomerService service = ProxyHandler.getInstance().getCustomerService();

    public CustomerController() {

    }

    public boolean addCustomer(CustomerDTO c) throws ClassNotFoundException, SQLException, Exception {
        return service.addCustomer(c);
    }

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        return service.deleteCustomer(id);
    }

    public boolean updateCustomer(CustomerDTO c) throws SQLException, ClassNotFoundException, Exception {
        return service.updateCustomer(c);
    }

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException, Exception {
        return service.searchCustomer(id);
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException, Exception {
        return service.getAllCustomers();
    }

    public ArrayList<CustomDTO> getAllCustomerItemDetails() throws Exception {
        return service.getAllCustomerItemDetails();

    }
}
