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
import javafx.scene.control.MenuItem;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
    
    School_Management_DB main;
   
    @FXML
    public Button btn1;
    @FXML
    public Button menu1;
    @FXML
    public Button menu2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void setMain(School_Management_DB scene){
        main=scene;
        
    } 
    public void applyaction() throws IOException{
        main.showapplypage();
    }
    public void login1() throws IOException{
        main.showteacherloginpage();
    }
    public void login2() throws IOException{
        main.showstudentloginpage();
    }
    
    
}
