/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import Entities.Command;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author cauito
 */
@Remote
public interface ICommand {
    List<Command> getCommandList(String room);
}
