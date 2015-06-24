/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSoft.persistencia;

import Entities.Command;
import Entities.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author cauito
 */
@Remote
public interface IRemotePersistence {
     public List<Command> getCommandList(int room);
     //public void setCommandToRoom(int idRoom,int idCommand);
     public User SearchByName(String name);
}
