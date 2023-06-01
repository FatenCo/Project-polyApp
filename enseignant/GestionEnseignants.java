/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enseignant;

import modeles.Admin;
import modeles.User;

import services.ServiceUser;
import utils.DataSource;

/**
 *
 * @author 
 */
public class GestionEnseignants {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DataSource c =DataSource.getInstance();
          ServiceUser su = new ServiceUser();
          
    //       User u = new Admin ("Admin","Admin","adminpolytech@gmail.com","0000");
          
  //     su.ajouter(u);
        
        // TODO code application logic here
    }
    
} 
