/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_db;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class PayfeesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    School_Management_DB main;
    @FXML
    public MenuItem jan1;
    @FXML
    public MenuItem jan2;
    @FXML
    public MenuItem jan3;
    @FXML
    public MenuItem jan4;
    @FXML
    public MenuItem jan5;
    @FXML
    public MenuItem jan6;
    @FXML
    public MenuItem jan7;
    @FXML
    public MenuItem jan8;
    @FXML
    public MenuItem jan9;
    @FXML
    public MenuItem jan10;
    @FXML
    public MenuItem jan11;
    @FXML
    public MenuItem jan12;
    @FXML
    public MenuButton jan;
    @FXML
    public TextField stid;
    @FXML
    public TextField baccount;
    String dbName = "newDB";
    String collectionName = "TuitionTable";
    ArangoDB arangoDB;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arangoDB = new ArangoDB.Builder().user("root").password("").build();
    }    
    public void setMain(School_Management_DB scene){
        main=scene;
        
    } 
    public void january()
    {
        jan.setText(jan1.getText());
    }
    public void February()
    {
        jan.setText(jan2.getText());
    }
    public void March()
    {
        jan.setText(jan3.getText());
    }
    public void April()
    {
        jan.setText(jan4.getText());
    }
    public void May()
    {
        jan.setText(jan5.getText());
    }
    public void June()
    {
        jan.setText(jan6.getText());
    }
    public void July()
    {
        jan.setText(jan7.getText());
    }
    public void August()
    {
        jan.setText(jan8.getText());
    }
    public void September()
    {
        jan.setText(jan9.getText());
    }
    public void October()
    {
        jan.setText(jan10.getText());
    }
    public void November()
    {
        jan.setText(jan11.getText());
    }
    public void December()
    {
        jan.setText(jan12.getText());
    }
    
    public void pay() throws IOException
    {
        BaseDocument myObject=new BaseDocument();
        myObject.addAttribute(jan.getText(), "paid");
        try {
          arangoDB.db(dbName).collection(collectionName).updateDocument(stid.getText(), myObject);
        } catch (ArangoDBException e) {
          System.err.println("Failed to update document. " + e.getMessage());
        }
        main.successpay();
    }
    
    
}
