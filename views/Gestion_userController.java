/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import utils.DataSource;
import modeles.Admin;
import modeles.User;
import modeles.Enseignant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.ServiceUser;

/**
 *
 * @author Faty
 */
public class Gestion_userController implements Initializable {

    @FXML
    private TableColumn<User, Integer> cl_id_user;
    @FXML
    private TableColumn<User, String> cl_nom_user;
    @FXML
    private TableColumn<User, String> cl_prenom_user;
    
    @FXML
    private TableColumn<User, String> cl_email_user;
    @FXML
    private TableColumn<User, String> cl_mdp_user;
    @FXML
    private TableView<User> table;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    
    @FXML
    private TextField id;
    @FXML
    private Button up;
    @FXML
    private Button del;
    @FXML
    private Button btn_rech;
    @FXML
    private TextField recherche_user;
    @FXML
    private TableView<User> table1;
    @FXML
    private TableColumn<User, Integer> cl_id_user1;
    @FXML
    private TableColumn<User, String> cl_nom_user1;
    @FXML
    private TableColumn<User, String> cl_prenom_user1;
    
    @FXML
    private TableColumn<User, String> cl_email_user1;
    @FXML
    private TableColumn<User, String> cl_mdp_user1;
    @FXML
    private TableColumn<User, String> cl_role;
    @FXML
    private TextField pass;
    @FXML
    private Button add;
    @FXML
    private TextField mail;
    @FXML
    private AnchorPane rootPane;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setDisable(true);
        table1.setVisible(false);
        showUser();
        
    }
 
public  void showUser(){
    ServiceUser sp = new ServiceUser();
    ObservableList<User>list = sp.getAll();
    cl_id_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
    cl_nom_user.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
    cl_prenom_user.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
  
    cl_email_user.setCellValueFactory(new PropertyValueFactory<>("email_user"));
    cl_mdp_user.setCellValueFactory(new PropertyValueFactory<>("mdp_user"));
    cl_role.setCellValueFactory(new PropertyValueFactory<>("role"));
    table.setItems(list);
}
    @FXML
    private void handleMouseAction(MouseEvent event) {
         User user = table.getSelectionModel().getSelectedItem();
         id.setText(""+user.getId_user());
         nom.setText(""+user.getNom_user());
         prenom.setText(""+user.getPrenom_user());
         
         id.setDisable(true);
         
    }

    @FXML
    private void update(ActionEvent event) {
        
       int  id_u  = Integer.parseInt(id.getText());
       ServiceUser sp = new ServiceUser();
       int options = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Vous etes sure de Modifier" ,"SERIOUS QUESTION", options, 3);
        if (result == JOptionPane.YES_OPTION) {
         User a = new User(id_u,nom.getText(), prenom.getText());
        sp.modifier(a);
        showUser();
        } else if (result == JOptionPane.NO_OPTION) {
           showUser();
        } 
       
     
        
    }

    @FXML
    private void delete(ActionEvent event) {
        int  id_u  = Integer.parseInt(id.getText());
        ServiceUser sp = new ServiceUser();
        User a = new User(id_u);
        int options = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Vous etes sure de Supprimer  cet utilisateur" ,"SERIOUS QUESTION", options, 3);
        if (result == JOptionPane.YES_OPTION) {
        sp.supprimer(a);
        showUser();
        } else if (result == JOptionPane.NO_OPTION) {
           showUser();
        } 
        
        
    }

    public void recherche(ActionEvent event){
    ServiceUser sp = new ServiceUser();
    
    ObservableList<User>list = sp.getUser(recherche_user.getText());
    cl_id_user1.setCellValueFactory(new PropertyValueFactory<>("id_user"));
    cl_nom_user1.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
    cl_prenom_user1.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));

    cl_email_user1.setCellValueFactory(new PropertyValueFactory<>("email_user"));
    cl_mdp_user1.setCellValueFactory(new PropertyValueFactory<>("mdp_user"));
    
    table1.setItems(list);
    }
    
    @FXML
    private void EnterRecherche(ActionEvent event) {
        String h = "";
        recherche_user.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    recherche(event);
                    if (recherche_user.getText().equals(h)) {
                        table1.setVisible(false);
                        table.setVisible(true);
                    } else {
                        table1.setVisible(true);
                    }
                }
            }
        });
    }

    @FXML
    private void handleMouseAction1(MouseEvent event) {
        User user = table1.getSelectionModel().getSelectedItem();
         id.setText(""+user.getId_user());
         nom.setText(""+user.getNom_user());
         prenom.setText(""+user.getPrenom_user());
         
         id.setDisable(true);
    }

    @FXML
    private void ADD(ActionEvent event) {
        
        
        if (prenom.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("What's your name ?");
            alert.showAndWait();
            return;
        }
        if (nom.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("What's your name ?");
            alert.showAndWait();
            return;
        }
        if (mail.getText().isEmpty()
                || !mail.getText().contains("@")
                || !mail.getText().contains(".")
                || mail.getText().indexOf("#", 0) >= 0
                || mail.getText().indexOf("&", 0) >= 0
                || mail.getText().indexOf("(", 0) >= 0
                || mail.getText().indexOf("Â§", 0) >= 0
                || mail.getText().indexOf("!", 0) >= 0
                || mail.getText().indexOf("Ã§", 0) >= 0
                || mail.getText().indexOf("Ã ", 0) >= 0
                || mail.getText().indexOf("Ã©", 0) >= 0
                || mail.getText().indexOf(")", 0) >= 0
                || mail.getText().indexOf("{", 0) >= 0
                || mail.getText().indexOf("}", 0) >= 0
                || mail.getText().indexOf("|", 0) >= 0
                || mail.getText().indexOf("$", 0) >= 0
                || mail.getText().indexOf("*", 0) >= 0
                || mail.getText().indexOf("â‚¬", 0) >= 0
                || mail.getText().indexOf("`", 0) >= 0
                || mail.getText().indexOf("\'", 0) >= 0
                || mail.getText().indexOf("\"", 0) >= 0
                || mail.getText().indexOf("%", 0) >= 0
                || mail.getText().indexOf("+", 0) >= 0
                || mail.getText().indexOf("=", 0) >= 0
                || mail.getText().indexOf("/", 0) >= 0
                || mail.getText().indexOf("\\", 0) >= 0
                || mail.getText().indexOf(":", 0) >= 0
                || mail.getText().indexOf(",", 0) >= 0
                || mail.getText().indexOf("?", 0) >= 0
                || mail.getText().indexOf(";", 0) >= 0
                || mail.getText().indexOf("Â°", 0) >= 0
                || mail.getText().indexOf("<", 0) >= 0
                || mail.getText().indexOf(">", 0) >= 0) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("Invalid mail !");
            alert.showAndWait();
            return;
        }
        if (pass.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText("What's your password ?");
            alert.showAndWait();
            return;
        }
          ServiceUser sp = new ServiceUser();
         
          User m = new Enseignant(prenom.getText(), nom.getText(), mail.getText(), pass.getText());
         System.out.println("user added");
          sp.ajouter(m);
   
         showUser();
        
    }

    @FXML
    private void diselect(ActionEvent event) {
        id.setText("");
         nom.setText("");
         prenom.setText("");
     
         id.setDisable(true);
         
    }

    @FXML
    private void ActionDashboard(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/DashboardAdmin.fxml"));
        rootPane.getChildren().setAll(pane);  
    }

    

}
