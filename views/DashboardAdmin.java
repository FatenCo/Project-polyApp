/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
/**
 *
 * @author Molka
 */
public class DashboardAdmin implements Initializable {

    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    




    
   

    @FXML
    private void GererPacks(ActionEvent event) {
    }

    @FXML
    private void GererVoyages(ActionEvent event) {
    }

    @FXML
    private void GererJoueurs(ActionEvent event) {
    }
    @FXML
    private void Utilisateur(ActionEvent event) throws IOException {
       AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/Gestion_user.fxml"));
        rootPane.getChildren().setAll(pane);  
    }
    
    
    
}


