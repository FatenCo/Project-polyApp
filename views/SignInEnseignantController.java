/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;
import utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Faty
 */
public class SignInEnseignantController implements Initializable {

    @FXML
    private Button login_membre_btn;
    @FXML
    private PasswordField mdp_membre;
    @FXML
    private TextField email_membre;
    @FXML
    private Button switch_signup_membre_btn;
    
    
    Connection cn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private  void action_login_membre(ActionEvent event ) {
        String sql = "Select * from user where email_user = ? and mdp_user =?   ";
        cn = DataSource.getInstance().getCnx();
        try {
            String newMD = "";
            String mdp = Hash();
            pst = cn.prepareStatement(sql);
            pst.setString(1, email_membre.getText());
            pst.setString(2, mdp + mdp_membre.getText());
            

            rs = pst.executeQuery();
            if (rs.next()) {
                ProfilEnseignantController.idcli = rs.getInt(1);
                System.out.println(ProfilEnseignantController.idcli);
                JOptionPane.showMessageDialog(null, "E-mail et Password sont Correct");
                root = FXMLLoader.load(getClass().getResource("/views/InterfaceEnseignant.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
               
            } else {
                JOptionPane.showMessageDialog(null, "Invalid E-mail Or Password");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public String Hash() throws Exception {

        String mdp_user = "";

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(mdp_user.getBytes());

        byte byteData[] = md.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();

    }

    @FXML
    private void switch_signup_membre(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SingUpEnseignant.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void passReset(MouseEvent event) {
        
    
    }

    @FXML
    private void action_forgot_pass(ActionEvent event) {
    
         
    }


}
