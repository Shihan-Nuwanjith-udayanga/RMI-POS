/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.rmi.Remote;

/**
 *
 * @author sanu
 */
public interface Subject extends Remote{
    public void registerObserver(Observer ob)throws Exception;
    public void removeObserver(Observer ob)throws Exception;
    public void notifyAllObservers(String message)throws Exception;
}
