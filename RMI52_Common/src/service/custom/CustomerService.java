/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom;

import dto.CustomDTO;
import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import service.SuperService;

/**
 *
 * @author sanu
 */
public interface CustomerService extends SuperService{
     public boolean addCustomer(CustomerDTO c) throws Exception;
     public boolean deleteCustomer(String id)  throws Exception;
      public boolean updateCustomer(CustomerDTO c)  throws Exception ;
      public CustomerDTO searchCustomer(String id)  throws Exception ;
       public ArrayList<CustomerDTO> getAllCustomers()  throws Exception;
        public ArrayList<CustomDTO> getAllCustomerItemDetails() throws Exception;
}
