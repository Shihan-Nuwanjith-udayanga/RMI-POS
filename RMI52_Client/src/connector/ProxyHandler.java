/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ServiceFactory;
import service.ServiceFactory.ServiceTypes;
import service.custom.CustomerService;
import service.custom.ItemService;

/**
 *
 * @author sanu
 */
public class ProxyHandler {

    private static ProxyHandler ph;
    private CustomerService customerService;
    private ItemService itemService;

    private ProxyHandler() {
        try {
            ServiceFactory lookup = (ServiceFactory) Naming.lookup("rmi://localhost:5050/POS");
            customerService = (CustomerService) lookup.getService(ServiceTypes.CUSTOME);
            itemService = (ItemService) lookup.getService(ServiceTypes.ITEM);
        } catch (NotBoundException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ProxyHandler getInstance() {
        return (ph == null) ? (ph = new ProxyHandler()) : ph;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public ItemService getItemService() {
        return itemService;
    }

}
