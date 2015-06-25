/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSoft.DTOs;

import java.io.Serializable;

/**
 *
 * @author pabloperfalc
 */
public class QueueCommand implements Serializable{
    
    private int roomId;

    /**
     * Get the value of RoomId
     *
     * @return the value of RoomId
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Set the value of RoomId
     *
     * @param RoomId new value of RoomId
     */
    public void setRoomId(int RoomId) {
        this.roomId = RoomId;
    }

    private int commandId;

    /**
     * Get the value of commandId
     *
     * @return the value of commandId
     */
    public int getCommandId() {
        return commandId;
    }

    /**
     * Set the value of commandId
     *
     * @param commandId new value of commandId
     */
    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

}
