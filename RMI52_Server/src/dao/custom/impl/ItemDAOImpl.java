/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Item;
import java.sql.Connection;

/**
 *
 * @author sanu
 */
public class ItemDAOImpl implements ItemDAO {

    private Connection connection;

    @Override
    public boolean add(Item i) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("INSERT INTO Item VALUES(?,?,?,?)",connection,
                i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("DELETE FROM  Item WHERE code=?", connection,id);
    }

    @Override
    public boolean update(Item i) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("UPDATE  Item SET code=?,description=?,qtyOnHand=?,unitPrice=?  WHERE code=?",connection,
                i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice(), i.getCode());
    }

    @Override
    public Item search(String id) throws ClassNotFoundException, SQLException {
        ResultSet r = CrudUtil.execute("SELECT * FROM Item WHERE code=?", connection,id);
        if (r.next()) {
            return new Item(r.getString(1), r.getString(2), r.getInt(3), r.getDouble(4));
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws ClassNotFoundException, SQLException {
        ResultSet r = CrudUtil.execute("SELECT * FROM Item",connection);
        ArrayList<Item> allItems = new ArrayList<>();
        while (r.next()) {
            allItems.add(new Item(r.getString(1), r.getString(2), r.getInt(3), r.getDouble(4)));
        }
        return allItems;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }

}
