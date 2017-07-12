/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_db;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ApplicationformController implements Initializable {

    /**
     * Initializes the controller class.
     */
    School_Management_DB main;
    @FXML
    public Button btn1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setMain(School_Management_DB scene){
        main=scene;
        
    }
    public void nextpage() throws IOException{
        main.showsecondpage();
    }
}
