/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_db;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.velocypack.VPackSlice;
import com.arangodb.velocypack.exception.VPackException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class UpgrademarksController implements Initializable {

    /**
     * Initializes the controller class.
     */
    School_Management_DB main;
    @FXML
    public CheckBox bangla1st;
    @FXML
    public CheckBox bangla2nd;
    @FXML
    public CheckBox english1st;
    @FXML
    public CheckBox english2nd;
    @FXML
    public CheckBox generalmath;
    @FXML
    public CheckBox physics;
    @FXML
   public  CheckBox chemistry;
    @FXML
    public CheckBox religiousedu;
    @FXML
    public CheckBox socialscience;
    @FXML
    public CheckBox highermath;
    @FXML
    public CheckBox biology;
    @FXML
    public CheckBox computerscience;
    @FXML
    public CheckBox agriculture;
    @FXML
    public CheckBox homeeconomics;
    @FXML
    public CheckBox statistics;
    @FXML
    public TextField stid11;
    @FXML
    public TextField stid12;
    @FXML
    public TextField stid13;
    @FXML
    public TextField stid14;
    @FXML
    public TextField stid15;
    @FXML
    public TextField stid16;
    @FXML
    public TextField stid17;
    @FXML
    public TextField stid18;
    @FXML
    public TextField stid19;
    @FXML
    public TextField stid110;
    @FXML
    public TextField stid111;
    @FXML
    public TextField stid112;
    @FXML
    public TextField stid113;
    @FXML
    public TextField stid114;
    @FXML
    public TextField stid1;
    @FXML
    public TextField stid;
    @FXML
    public Label label1;
    @FXML
    public Label label2;
    @FXML
    public Label label3;
    @FXML
    public Label label4;
    @FXML
    public Label label5;
    @FXML
    public Label label6;
    @FXML
    public Label label7;
    @FXML
    public Label label8;
    @FXML
    public Label label9;
    @FXML
    public Label label10;
    @FXML
    public Label label11;
    @FXML
    public Label label12;
    @FXML
    public Label label13;
    @FXML
    public Label label14;
    @FXML
    public Label label15;
    ArangoDB arangoDB;
    VPackSlice myDocument ;
    VPackSlice myDocument1 ;
    VPackSlice myDocument2;
    String dbName = "newDB";
    String collectionName = "StudentTable";
    public float str;
    String sew;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arangoDB = new ArangoDB.Builder().user("root").password("").build();
       
          
    }    
    public void setMain(School_Management_DB scene){
        main=scene;
        
    } 
    public void visible11()
    {
        sew=stid.getText();
       try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(sew,
          VPackSlice.class);
        str=myDocument2.get("Bengali 1st Paper").getAsFloat();
           //System.out.println(str);
        if (str==10.00){
            label1.setVisible(true);
        }
        else{
            stid11.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
        
    }
    public void visible12()
    {
        try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Bengali 2nd Paper").getAsFloat();
        if (str==10.00){
            label2.setVisible(true);
        }
        else{
            stid12.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible13()
    {
        try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("English 1st Paper").getAsFloat();
        if (str==10.00){
            label3.setVisible(true);
        }
        else{
            stid13.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible14()
    {
       try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("English 2nd Paper").getAsFloat();
        if (str==10.00){
            label4.setVisible(true);
        }
        else{
            stid14.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible15()
    {
        try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("General Math").getAsFloat();
       if (str==10.00){
            label5.setVisible(true);
        }
        else{
            stid15.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible16()
    {
        try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Physics").getAsFloat();
        if (str==10.00){
            label6.setVisible(true);
        }
        else{
            stid16.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible17()
    {
        try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Chemistry").getAsFloat();
        if (str==10.00){
            label7.setVisible(true);
        }
        else{
            stid17.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible18()
    {
       try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Religious Education").getAsFloat();
        if (str==10.00){
            label8.setVisible(true);
        }
        else{
            stid18.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible19()
    {
        try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Social Science").getAsFloat();
        if (str==10.00){
            label9.setVisible(true);
        }
        else{
            stid19.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible110()
    {
       try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Higher Math").getAsFloat();
        if (str==10.00){
            label10.setVisible(true);
        }
        else{
            stid110.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible111()
    {
        try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Biology").getAsFloat();
        if (str==10.00){
            label11.setVisible(true);
        }
        else{
            stid111.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible112()
    {
        try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Computer Science").getAsFloat();
        if (str==10.00){
            label12.setVisible(true);
        }
        else{
            stid112.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible113()
    {
        try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Agriculture").getAsFloat();
        if (str==10.00){
            label13.setVisible(true);
        }
        else{
            stid113.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible114()
    {
       try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Home Economics").getAsFloat();
        if (str==10.00){
            label14.setVisible(true);
        }
        else{
            stid114.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    public void visible1()
    {
        try {
       myDocument2 = arangoDB.db(dbName).collection(collectionName).getDocument(stid.getText(),
          VPackSlice.class);
        str=myDocument2.get("Statistics").getAsFloat();
        if (str==10.00){
            label15.setVisible(true);
        }
        else{
            stid11.setVisible(true);
        }
        
        
      } catch (ArangoDBException | VPackException e) {
        System.err.println("Failed to get document: myKey; " + e.getMessage());
      }
    }
    
    public void upgradesuccess() throws IOException
    {
        BaseDocument myObject = new BaseDocument();
        
        if(stid11.isVisible()==true){
            if (stid11.getText()!=" "){
            myObject.addAttribute("Bengali 1st Paper", stid11.getText());
            }
        } 
        
          if(stid12.isVisible()==true){
              if (stid12.getText()!=" "){
            myObject.addAttribute("Bengali 2nd Paper", stid12.getText());
              }
        } 
        if(stid13.isVisible()==true){
            if (stid13.getText()!=" "){
            myObject.addAttribute("English 1st Paper", stid13.getText());
            }
        } 
        if(stid14.isVisible()==true){
            if (stid14.getText()!=" "){
            myObject.addAttribute("English 2nd Paper", stid14.getText());
            }
        } 
        if(stid15.isVisible()==true){
            if (stid15.getText()!=" "){
            myObject.addAttribute("General Math", stid15.getText());
            }
        } 
        if(stid16.isVisible()==true){
            if (stid16.getText()!=" "){
            myObject.addAttribute("Physics", stid16.getText());
            }
        } 
        if(stid17.isVisible()==true){
            if (stid17.getText()!=" "){
            myObject.addAttribute("Chemistry", stid17.getText());
            }
        } 
       if(stid18.isVisible()==true){
           if (stid18.getText()!=" "){
            myObject.addAttribute("Religious Education", stid18.getText());
           }
        } 
        if(stid19.isVisible()==true){
            if (stid19.getText()!=" "){
            myObject.addAttribute("Social Science", stid19.getText());
            }
        } 
        if(stid110.isVisible()==true){
            if (stid110.getText()!=" "){
            myObject.addAttribute("Higher Math", stid110.getText());
            }
        } 
        if(stid111.isVisible()==true){
            if (stid111.getText()!=" "){
            myObject.addAttribute("Biology", stid111.getText());
            }
        } 
        if(stid112.isVisible()==true){
            if (stid112.getText()!=" "){
            myObject.addAttribute("Computer Science", stid112.getText());
            }
        } 
        if(stid113.isVisible()==true){
            if (stid113.getText()!=" "){
            myObject.addAttribute("Agriculture", stid113.getText());
            }
        } 
        if(stid114.isVisible()==true){
            if (stid114.getText()!=" "){
            myObject.addAttribute("Home Economics", stid114.getText());
            }
        } 
        if(stid1.isVisible()==true){
            if (stid1.getText()!=" "){
            myObject.addAttribute("Statistics",stid1.getText());
            }
        }
        
        
        try {
            arangoDB.db(dbName).collection(collectionName).updateDocument(stid.getText(), myObject);
          } catch (ArangoDBException e) {
            System.err.println("Failed to update document. " + e.getMessage());
          }
        main.upgradesuccess1();
    }
}
