/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;
import utils.DataSource;

import modeles.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.ServiceUser;

 
 
/**
 * FXML Controller class
 *
 * @author Faty
 */
public class ProfilEnseignantController implements Initializable {
    public static int idcli = 0;
    SignInEnseignantController s = new SignInEnseignantController();   
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField pwd;
    @FXML
    private TextField mail;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button upd;
    @FXML
    private TextField id;
   
    Connection mc ; 
    
    PreparedStatement ste2,ste;
   
    @FXML
    private Button acceuilbtn;
    @FXML
    private AnchorPane rootPane2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     Select();
    }   

    @FXML
    private void upd(ActionEvent event) {
        int  id_u  = Integer.parseInt(id.getText());
       ServiceUser sp = new ServiceUser();
       int options = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Vous etes sure de Modifier?" ,"SERIOUS QUESTION", options, 3);
        if (result == JOptionPane.YES_OPTION) {
         User a = new User(id_u,nom.getText(), prenom.getText(),  mail.getText() , pwd.getText() );
         sp.modifier(a);
       
        } else if (result == JOptionPane.NO_OPTION) {
           
        } 
    }

   
    public void Select(){
        
         mc = DataSource.getInstance().getCnx();
        String sql="SELECT * FROM user where id_user = "+idcli+" " ;

        try{
        ste2 = mc.prepareStatement(sql);
         
        ResultSet rs=ste2.executeQuery();
           while(rs.next()){             
              
                       id.setText(""+rs.getInt(1));
                       nom.setText(rs.getString(2));
                       prenom.setText(rs.getString(3));
                       pwd.setText(rs.getString(5));
                       mail.setText(rs.getString(4));
                       
           }
        }catch (SQLException ex) {
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        
} 

    @FXML
    private void ActionAcceuilbtn(ActionEvent event) throws IOException {
      AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/InterfaceEnseignant.fxml"));
        rootPane2.getChildren().setAll(pane);
    }
    
    }
    
