/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import java.rmi.Remote;

/**
 *
 * @author sanu
 */
public interface ServiceFactory extends Remote{
    
      public enum ServiceTypes {
        CUSTOME, ITEM;
    }
    public SuperService getService(ServiceTypes types)throws Exception;
}
