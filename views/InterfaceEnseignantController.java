/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Pane;

import javafx.scene.media.*;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Mega Pc
 */
public class InterfaceEnseignantController implements Initializable {

    @FXML
    private AnchorPane rootPane3;
    @FXML
    private Pane paneId;
    @FXML
    private Button profilbtn;
    @FXML
    private Button packsbtn;
    @FXML
    private Button logoffbtn1;
     @FXML
    private MediaView mediaView;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    private Button testbtn;
    @FXML
    private Button test2btn;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }

    @FXML
    private void ActionProfilbtn(ActionEvent event) throws IOException {
        System.out.println("here");
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/views/ProfilEnseignant.fxml"));
        rootPane3.getChildren().setAll(pane);
    }

  

    @FXML
    private void ActionLogOffbtn(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/SingUpEnseignant.fxml"));
        rootPane3.getChildren().setAll(pane);
    }
    
       @FXML
    private void ActionTestdesbtn(ActionEvent event) {
 

    }

    @FXML
    private void ActionTestbtn(ActionEvent event) {
       
    }

    
    
}
