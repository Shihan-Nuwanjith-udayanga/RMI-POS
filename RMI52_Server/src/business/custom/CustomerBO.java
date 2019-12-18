/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom;

import business.SuperBO;
import dto.CustomDTO;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sanu
 */
public interface CustomerBO extends SuperBO{

    public boolean addCustomer(CustomerDTO c) throws ClassNotFoundException, SQLException,Exception;

    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException,Exception;

    public boolean updateCustomer(CustomerDTO c) throws SQLException, ClassNotFoundException,Exception;

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException,Exception;

    public ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException,Exception;
    
    public ArrayList<CustomDTO> getAllCustomerItemDetails()throws Exception;
}
