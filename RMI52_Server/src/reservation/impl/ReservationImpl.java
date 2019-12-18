/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.impl;

import java.util.HashMap;

/**
 *
 * @author sanu
 */
public class ReservationImpl<T> {

    private HashMap<Object, T> reservationMap = new HashMap();

    public boolean reserve(Object key, T service) {
        //check if the key exsists on the map
        if (reservationMap.containsKey(key)) {
            //if exsists check whether services also match with each other
            return reservationMap.get(key)==service;
        } else {
            //otherwise reserved as a new reservation
            reservationMap.put(key, service);
            return true;
        }

    }

    public boolean realease(Object key, T service) {
        //check the key and services are both matching or not
        if (reservationMap.containsKey(key) && reservationMap.get(key)==service) {
            reservationMap.remove(key);// if matching remove the key and value from the map
            return true;
        }
        return false;
    }
}
