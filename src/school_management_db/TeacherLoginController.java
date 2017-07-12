/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_db;

import com.arangodb.ArangoDB;
import com.arangodb.velocypack.VPackSlice;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Zaara Tasnim Rifat
 */
public class TeacherLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    School_Management_DB main;
    String dbName = "newDB";
    String collectionName = "TeacherTable";
    ArangoDB arangoDB;
    VPackSlice myDocument;
    String str;
    @FXML
    public TextField id;
    @FXML
    public PasswordField pass;
    @FXML
    public Label label1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arangoDB = new ArangoDB.Builder().user("root").password("").build();
    }    
    public void setMain(School_Management_DB scene){
        main=scene;
        
    } 
    
    public void optionForTeacher() throws IOException
    {
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
            main.teacherOptionPage();
        }
        }
    }
}
