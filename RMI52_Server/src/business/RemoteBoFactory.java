/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.rmi.Remote;

/**
 *
 * @author sanu
 */
public interface RemoteBoFactory extends Remote{
    public SuperBO getBO(BOTypes types) throws Exception;
}
