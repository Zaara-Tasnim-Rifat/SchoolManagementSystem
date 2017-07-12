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

/**
 * FXML Controller class
 *
 * @author User
 */
public class ResultshowController implements Initializable {

    /**
     * Initializes the controller class.
     */
    School_Management_DB main;
    ArangoDB arangoDB;
    VPackSlice myDocument2;
    @FXML
    public Label labels1;
    @FXML
    public Label labelc1;
    @FXML
    public Label labels2;
    @FXML
    public Label labelc2;
    @FXML
    public Label labels3;
    @FXML
    public Label labelc3;
    @FXML
    public Label labels4;
    @FXML
    public Label labelc4;
    @FXML
    public Label labels5;
    @FXML
    public Label labelc5;
    @FXML
    public Label labels6;
    @FXML
    public Label labelc6;
    @FXML
    public Label labels7;
    @FXML
    public Label labelc7;
    @FXML
    public Label labels8;
    @FXML
    public Label labelc8;
    @FXML
    public Label labels9;
    @FXML
    public Label labelc9;
    @FXML
    public Label labels10;
    @FXML
    public Label labelc10;
    @FXML
    public Label labels11;
    @FXML
    public Label labelc11;
    @FXML
    public Label labels12;
    @FXML
    public Label labelc12;
    @FXML
    public Label labels13;
    @FXML
    public Label labelc13;
    @FXML
    public Label labels14;
    @FXML
    public Label labelc14;
    @FXML
    public Label labels15;
    @FXML
    public Label labelc15;
    @FXML
    public Label stno;
    public float r;
    public String str;
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        arangoDB = new ArangoDB.Builder().user("root").password("").build();
        stno.setText(main.studentno);
         //System.out.println(main.studentno);
        try {
       myDocument2 = arangoDB.db("newDB").collection("StudentTable").getDocument(main.studentno,
          VPackSlice.class);
        r=myDocument2.get("Bengali 1st Paper").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Bengali 1st Paper").getAsString();
            labels1.setVisible(true);
            labelc1.setText(str);
            labelc1.setVisible(true);
        }
        r=myDocument2.get("Bengali 2nd Paper").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Bengali 2nd Paper").getAsString();
            labels2.setVisible(true);
            labelc2.setText(str);
            labelc2.setVisible(true);
        }
        r=myDocument2.get("English 1st Paper").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("English 1st Paper").getAsString();
            labels3.setVisible(true);
            labelc3.setText(str);
            labelc3.setVisible(true);
        }
        r=myDocument2.get("English 2nd Paper").getAsFloat();
       
        if(r!=10.00 && r!=20.00){
             str=myDocument2.get("English 2nd Paper").getAsString();
            labels4.setVisible(true);
            labelc4.setText(str);
            labelc4.setVisible(true);
        }
        r=myDocument2.get("General Math").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("General Math").getAsString();
            labels5.setVisible(true);
            labelc5.setText(str);
            labelc5.setVisible(true);
        }
        r=myDocument2.get("Physics").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Physics").getAsString();
            labels6.setVisible(true);
            labelc6.setText(str);
            labelc6.setVisible(true);
        }
        r=myDocument2.get("Chemistry").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Chemistry").getAsString();
            labels7.setVisible(true);
            labelc7.setText(str);
            labelc7.setVisible(true);
        }
        r=myDocument2.get("Religious Education").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Religious Education").getAsString();
            labels8.setVisible(true);
            labelc8.setText(str);
            labelc8.setVisible(true);
        }
        r=myDocument2.get("Social Science").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Social Science").getAsString();
            labels9.setVisible(true);
            labelc9.setText(str);
            labelc9.setVisible(true);
        }
        r=myDocument2.get("Higher Math").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Higher Math").getAsString();
            labels10.setVisible(true);
            labelc10.setText(str);
            labelc10.setVisible(true);
        }
        r=myDocument2.get("Biology").getAsFloat();
        
       if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Biology").getAsString();
            labels11.setVisible(true);
            labelc11.setText(str);
            labelc11.setVisible(true);
        }
        r=myDocument2.get("Computer Science").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Computer Science").getAsString();
            labels12.setVisible(true);
            labelc12.setText(str);
            labelc12.setVisible(true);
        }
        r=myDocument2.get("Agriculture").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Agriculture").getAsString();
            labels13.setVisible(true);
            labelc13.setText(str);
            labelc13.setVisible(true);
        }
        r=myDocument2.get("Home Economics").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Home Economics").getAsString();
            labels14.setVisible(true);
            labelc14.setText(str);
            labelc14.setVisible(true);
        }
        r=myDocument2.get("Statistics").getAsFloat();
        
        if(r!=10.00 && r!=20.00){
            str=myDocument2.get("Statistics").getAsString();
            labels15.setVisible(true);
            labelc15.setText(str);
            labelc15.setVisible(true);
        }
        
        } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }    
    public void setMain(School_Management_DB scene){
        main=scene;
        
    }    
    public void backpage() throws IOException
    {
        main.showstudenthomepage();
    }
    
}
