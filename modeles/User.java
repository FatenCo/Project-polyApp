/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;



public class User {

    private int id_user;
    private String nom_user;
    private String prenom_user;
   
    private String email_user;
    private String mdp_user;
    private String role ;
    private String pdp ;
    public User() {
    }
    

    public User(int id_user, String nom_user, String prenom_user, String email_user, String mdp_user) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
       
        this.email_user = email_user;
        this.mdp_user = mdp_user;
    }

    public User(String nom_user, String prenom_user,  String email_user, String mdp_user) {
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
       
        this.email_user = email_user;
        this.mdp_user = mdp_user;
    }

   

    public User(int id_user, String nom_user, String prenom_user) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
       
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

 

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getMdp_user() {
        return mdp_user;
    }

    public void setMdp_user(String mdp_user) {
        this.mdp_user = mdp_user;
    }


    

    public User(String email_user, String mdp_user) {
        this.email_user = email_user;
        this.mdp_user = mdp_user;
    }

    public User(int id_user) {
        this.id_user = id_user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int id_user, String nom_user, String prenom_user, String email_user, String mdp_user, String pdp) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
      
        this.email_user = email_user;
        this.mdp_user = mdp_user;
        this.pdp = pdp;
    }

    public User(String nom_user, String prenom_user, String email_user, String mdp_user, String pdp) {
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        
        this.email_user = email_user;
        this.mdp_user = mdp_user;
        this.pdp = pdp;
    }

    public String getPdp() {
        return pdp;
    }

    public void setPdp(String pdp) {
        this.pdp = pdp;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", nom_user=" + nom_user + ", prenom_user=" + prenom_user + ", email_user=" + email_user + ", mdp_user=" + mdp_user + ", role=" + role + ", pdp=" + pdp + '}';
    }
    

}
