/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.rmi.server.UnicastRemoteObject;
import service.ServiceFactory;
import service.SuperService;
import service.custom.impl.CustomerServiceImpl;
import service.custom.impl.ItemServiceImpl;

/**
 *
 * @author sanu
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    private static ServiceFactoryImpl serviceFactory;

    private ServiceFactoryImpl() throws Exception {
    }

    public static ServiceFactoryImpl getInstance() throws Exception {
        return (serviceFactory == null) ? (serviceFactory = new ServiceFactoryImpl()) : serviceFactory;

    }

    @Override
    public SuperService getService(ServiceTypes types) throws Exception {
        switch (types) {
            case CUSTOME:
                return new CustomerServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            default:
                return null;

        }

    }
}
