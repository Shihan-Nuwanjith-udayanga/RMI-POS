/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom.impl;

import service.custom.ItemService;
import business.BOFactory;
import business.BOTypes;
import business.custom.ItemBO;
import dto.ItemDTO;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observer;

/**
 *
 * @author sanu
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService {

    ItemBO bo = (ItemBO) BOFactory.getInstance().getBO(BOTypes.ITEM);
    private static ArrayList<Observer> itemObservers = new ArrayList();

    public ItemServiceImpl() throws Exception {

    }

    public boolean addItem(ItemDTO i) throws Exception {
        boolean addItem = bo.addItem(i);
        if (addItem) {
            notifyAllObservers(i.getCode() + " was aded to the database..!");
            return true;
        }
        return false;
    }

    public boolean deleteItem(String id) throws Exception {
        boolean deleteItem = bo.deleteItem(id);
        if (deleteItem) {
            notifyAllObservers(id + " was deleted from the database..!");
            return true;
        }
        return false;
    }

    public boolean updateItem(ItemDTO i) throws Exception {
        boolean updateItem = bo.updateItem(i);
        if (updateItem) {
            notifyAllObservers(i.getCode() + " was updated ..!");
            return true;
        }
        return false;
    }

    public ItemDTO searchItem(String id) throws Exception {
        return bo.searchItem(id);
    }

    public ArrayList<ItemDTO> getAllItems() throws Exception {
        return bo.getAllItems();
    }

    @Override
    public void registerObserver(Observer ob) throws Exception {
        itemObservers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) throws Exception {
        itemObservers.remove(ob);
    }

    @Override
    public void notifyAllObservers(String message) throws Exception {
        for (Observer ob : itemObservers) {
            new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    try {
                        ob.update(message);
                    } catch (Exception ex) {
                        Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            ).start();
        }
    }

    @Override
    public boolean reserve(Object key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
