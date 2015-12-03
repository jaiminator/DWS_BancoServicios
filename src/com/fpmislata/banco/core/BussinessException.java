/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class BussinessException extends Exception {
    private List<BussinessMessage> bussinessMessages = new ArrayList<>();
    private String fieldName;
    private String mensaje;

    public BussinessException(String fieldName, String mensaje) {
        BussinessMessage bussinessMessage = new BussinessMessage(fieldName, mensaje);
        this.bussinessMessages.add(bussinessMessage);
    }
    
    public BussinessException(List<BussinessMessage> bussinessMessages){
        this.bussinessMessages = bussinessMessages;
    }

    public List<BussinessMessage> getBussinessMessages() {
        return bussinessMessages;
    }

    public void setBussinessMessages(List<BussinessMessage> bussinessMessages) {
        this.bussinessMessages = bussinessMessages;
    }
    
}
