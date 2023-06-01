/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

/**
 *
 * @author Molka
 */
public class Enseignant extends User {

    public Enseignant(int id_user, String nom_user, String prenom_user,  String email_user, String mdp_user) {
        super(id_user, nom_user, prenom_user, email_user, mdp_user);
    }

    public Enseignant(String nom_user, String prenom_user,  String email_user, String mdp_user) {
        super(nom_user, prenom_user,  email_user, mdp_user);
    }

    public Enseignant() {
    }

    public Enseignant(String email_user, String mdp_user) {
        super(email_user, mdp_user);
    }

    public Enseignant(int id_user, String nom_user, String prenom_user,  String email_user, String mdp_user, String pdp) {
        super(id_user, nom_user, prenom_user,  email_user, mdp_user, pdp);
    }

    public Enseignant(String nom_user, String prenom_user,  String email_user, String mdp_user, String pdp) {
        super(nom_user, prenom_user,  email_user, mdp_user, pdp);
    }
}
