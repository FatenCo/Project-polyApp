/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

/**
 *
 * @author Faty
 */
public class Admin extends User {

    public Admin(int id_user, String nom_user, String prenom_user,  String email_user, String mdp_user) {
        super(id_user, nom_user, prenom_user, email_user, mdp_user);
    }

    public Admin(String nom_user, String prenom_user, String email_user, String mdp_user) {
        super(nom_user, prenom_user,  email_user, mdp_user);
    }

    public Admin(int id_user, String nom_user, String prenom_user) {
        super(id_user, nom_user, prenom_user);
    }

    

    public Admin() {
    }

    public Admin(String email_user, String mdp_user) {
        super(email_user, mdp_user);
    }

    public Admin(int id_user) {
        super(id_user);
    }
    
}
