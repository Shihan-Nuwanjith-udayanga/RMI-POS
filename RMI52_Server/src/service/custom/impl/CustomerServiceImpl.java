/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom.impl;

import service.custom.CustomerService;
import business.BOFactory;
import business.BOTypes;
import business.custom.CustomerBO;
import dto.CustomDTO;
import dto.CustomerDTO;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observer;
import reservation.impl.ReservationImpl;

/**
 *
 * @author sanu
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {

    CustomerBO bo = (CustomerBO) BOFactory.getInstance().getBO(BOTypes.CUSTOMER);
    private static ArrayList<Observer> allCustomerObservers = new ArrayList<>();
    private static ReservationImpl<CustomerService> customerReservation= new ReservationImpl<CustomerService>();

    public CustomerServiceImpl() throws Exception {

    }

    public boolean addCustomer(CustomerDTO c) throws Exception {
        boolean addCustomer = bo.addCustomer(c);
        if (addCustomer) {
            notifyAllObservers(c.getId() + "Was aded to the Database..!");
            return true;
        }
        return false;
    }

    public boolean deleteCustomer(String id) throws Exception {
        boolean deleteCustomer = bo.deleteCustomer(id);
        if (deleteCustomer) {
            notifyAllObservers(id + " was deleted from the database,,!");
            return true;
        }
        return false;
    }

    public boolean updateCustomer(CustomerDTO c) throws Exception {
        boolean updateCustomer = bo.updateCustomer(c);
        if (updateCustomer) {
            notifyAllObservers(c.getId() + "Was Deleted from the database..!");
            return true;
        }
        return false;
    }

    public CustomerDTO searchCustomer(String id) throws Exception {
        return bo.searchCustomer(id);
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        return bo.getAllCustomers();
    }

    public ArrayList<CustomDTO> getAllCustomerItemDetails() throws Exception {
        return bo.getAllCustomerItemDetails();
    }

    @Override
    public void registerObserver(Observer ob) throws Exception {
        allCustomerObservers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) throws Exception {
        allCustomerObservers.remove(ob);
    }

    @Override
    public void notifyAllObservers(String message) throws Exception {
        for (Observer ob : allCustomerObservers) { 
           new Thread(
           new Runnable() {
               @Override
               public void run() {
                   try {
                       ob.update(message);
                   } catch (Exception ex) {
                       Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
           ).start();

        }
    }

    @Override
    public boolean reserve(Object key) throws Exception {
       return customerReservation.reserve(key, this);
    }

    @Override
    public boolean release(Object key) throws Exception {
         return customerReservation.realease(key, this);
    }
}
