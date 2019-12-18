/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connector.ProxyHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.ItemDTO;
import service.custom.ItemService;

/**
 *
 * @author sanu
 */
public class ItemController {

//    ItemBO itemBO = new ItemBOImpl();
    ItemService service = ProxyHandler.getInstance().getItemService();

    public ItemController() {

    }

    public boolean addItem(ItemDTO i) throws ClassNotFoundException, SQLException, Exception {
        return service.addItem(i);
    }

    public boolean deleteItem(String id) throws ClassNotFoundException, SQLException, Exception {
        return service.deleteItem(id);
    }

    public boolean updateItem(ItemDTO i) throws ClassNotFoundException, SQLException, Exception {
        return service.updateItem(i);
    }

    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException, Exception {
        return service.searchItem(id);
    }

    public ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException, Exception {
        return service.getAllItems();
    }
}
