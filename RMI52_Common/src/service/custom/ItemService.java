/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom;

import dto.ItemDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import service.SuperService;

/**
 *
 * @author sanu
 */
public interface ItemService extends SuperService{

    public boolean addItem(ItemDTO i)  throws Exception;

    public boolean deleteItem(String id)  throws Exception;

    public boolean updateItem(ItemDTO i)  throws Exception;

    public ItemDTO searchItem(String id) throws Exception;

    public ArrayList<ItemDTO> getAllItems() throws Exception;
}
