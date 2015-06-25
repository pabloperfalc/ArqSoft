/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSoft.DTOs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cauito
 */

public class Room implements Serializable {
    
    
    private Long id;

    private List<Command> commandList = new ArrayList<>();

    
    
    public Room() {
       
    }  
    
    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String commands = "";
        for(Command c: commandList){
        commands = commands + c + "\n";
    }
        return "Habitación " + id + " Comandos: " + commands;
    }
    
}
