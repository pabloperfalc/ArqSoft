/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author pabloperfalc
 */
@Stateless
@LocalBean
public class TestSessionBean {

    // asdqweasdqweAdd business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void HelloWorld(){
    
        System.out.println("Hello World!!!! yeahaaaaaa");
    }
    
    public void NewOne(){
    
        System.out.println("This is the new one, HELLO WORLDDDDD");
    }
}
