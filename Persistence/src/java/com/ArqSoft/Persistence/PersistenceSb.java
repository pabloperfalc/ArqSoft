/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSoft.Persistence;

import com.ArqSoft.DTOs.Command;
import com.ArqSoft.DTOs.User;
import com.ArqSoft.Entities.CommandEntity;
import com.ArqSoft.Entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cauito
 */
@Stateless
//@LocalBean
public class PersistenceSb {

    @PersistenceContext
    EntityManager em;

    
    public List<com.ArqSoft.DTOs.Command> getCommandList(int room) {
        List<CommandEntity> list = (List<CommandEntity>) em.createNativeQuery("select * from arqsoft.commandentity where id ="+room, CommandEntity.class).getResultList();
        List<Command> returnList = new ArrayList<>();
        for (CommandEntity comm : list) {
            returnList.add(map(comm));
        }
        return returnList;
    }
    
    private Command map(CommandEntity comm) {
        Command ret = new Command();
        ret.setId(comm.getId());
        ret.setCommandAction(comm.getCommandAction());
        return ret;
    }

    /*@Override
    public void setCommandToRoom(int idRoom, int idCommand) {
        
        Command comm = map(this.obtenerCommand(idCommand));
        
    }
    
    private CommandEntity obtenerCommand(int idCommand){
    CommandEntity command = (CommandEntity) em.createNativeQuery("select * from arqsoft.commandentity where id ="+idCommand, CommandEntity.class).getSingleResult();
    return command;
    }*/

    
    public User SearchByName(String name) {
        UserEntity userAux = (UserEntity)em.createNativeQuery("select * from arqsoft.userentity where username="+name,UserEntity.class).getSingleResult();
        User userRet = new User(userAux.getName(), userAux.getPassword());        
        userRet.setId(userAux.getId());        
        return userRet;
    }
}
