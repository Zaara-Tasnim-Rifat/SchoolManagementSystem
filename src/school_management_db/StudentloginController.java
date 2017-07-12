/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_db;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.velocypack.VPackSlice;
import com.arangodb.velocypack.exception.VPackException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author User
 */
public class StudentloginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    School_Management_DB main;
    @FXML
    private Font x1;
    @FXML
    public TextField id;
    @FXML
    public PasswordField pass;
    @FXML
    public Label label1;
    //public String studentno;
    String dbName = "newDB";
    String collectionName = "StudentTable";
    ArangoDB arangoDB;
    VPackSlice myDocument;
    String str;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arangoDB = new ArangoDB.Builder().user("root").password("").build();
    } 
    
    public void setMain(School_Management_DB scene){
        main=scene;
        
    } 
    @FXML
    public void studentlogin() throws IOException, Exception{
        
        
        if (arangoDB.db(dbName).collection(collectionName).documentExists(id.getText())==false)
        {
            label1.setVisible(true);
            
        }
        else{
            myDocument = arangoDB.db(dbName).collection(collectionName).getDocument(id.getText(),
              VPackSlice.class);
        str=myDocument.get("Password").getAsString();
        if (str.compareTo(pass.getText())!=0){
            label1.setVisible(true);
            
        }
        else{
            main.studentno=id.getText();
            main.showstudenthomepage();
        }
        }
          
        
    }
    
}
