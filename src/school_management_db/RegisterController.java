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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author User
 */
public class RegisterController implements Initializable {

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
    public TextField stid;
    @FXML
    public RadioButton ophighermath;
    @FXML
    public RadioButton opbiology;
    @FXML
    public RadioButton opcomputerscience;
    @FXML
    public RadioButton opagriculture;
    @FXML
    public RadioButton ophomeeconomics;
    @FXML
    public RadioButton opstatistics;
    @FXML
    public Label student;
   
    ArangoDB arangoDB;
    VPackSlice myDocument ;
    String dbName = "newDB";
    String collectionName = "StudentTable";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arangoDB = new ArangoDB.Builder().user("root").password("").build();
        student.setText(main.studentno);
        ToggleGroup group=new ToggleGroup();
        opagriculture.setToggleGroup(group);
        opbiology.setToggleGroup(group);
        ophighermath.setToggleGroup(group);
        ophomeeconomics.setToggleGroup(group);
        opstatistics.setToggleGroup(group);
        opcomputerscience.setToggleGroup(group);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (group.getSelectedToggle() != null) {
          //System.out.println(group.getSelectedToggle().getUserData().toString());
        }
      }
    });
    }    
    public void setMain(School_Management_DB scene){
        main=scene;
        
    } 
    public void subjectchoice() throws IOException
    {
        BaseDocument myObject = new BaseDocument();
        if (bangla1st.isSelected()){
            myObject.addAttribute("Bengali 1st Paper", 20.00);
        } 
        if (bangla2nd.isSelected()){
            myObject.addAttribute("Bengali 2nd Paper", 20.00);
        } 
        if (english1st.isSelected()){
            myObject.addAttribute("English 1st Paper", 20.00);
        } 
        if (english2nd.isSelected()){
            myObject.addAttribute("English 2nd Paper", 20.00);
        } 
        if (generalmath.isSelected()){
            myObject.addAttribute("General Math", 20.00);
        } 
        if (physics.isSelected()){
            myObject.addAttribute("Physics", 20.00);
        } 
        if (chemistry.isSelected()){
            myObject.addAttribute("Chemistry", 20.00);
        } 
        if (religiousedu.isSelected()){
            myObject.addAttribute("Religious Education", 20.00);
        } 
        if (socialscience.isSelected()){
            myObject.addAttribute("Social Science", 20.00);
        } 
        if (highermath.isSelected()){
            myObject.addAttribute("Higher Math", 20.00);
        } 
        if (biology.isSelected()){
            myObject.addAttribute("Biology", 20.00);
        } 
        if (computerscience.isSelected()){
            myObject.addAttribute("Computer Science", 20.00);
        } 
        if (agriculture.isSelected()){
            myObject.addAttribute("Agriculture", 20.00);
        } 
        if (homeeconomics.isSelected()){
            myObject.addAttribute("Home Economics", 20.00);
        } 
        if (ophighermath.isSelected()){
            myObject.addAttribute("Higher Math", 20.00);
        } 
        if (opbiology.isSelected()){
            myObject.addAttribute("Biology", 20.00);
        } 
        if (opcomputerscience.isSelected()){
            myObject.addAttribute("Computer Science", 20.00);
        } 
        if (opagriculture.isSelected()){
            myObject.addAttribute("Agriculture", 20.00);
        } 
        if (ophomeeconomics.isSelected()){
            myObject.addAttribute("Home Economics", 20.00);
        }
        if (opstatistics.isSelected()){
            myObject.addAttribute("Statistics", 20.00);
        }
        
        
        try {
            arangoDB.db(dbName).collection(collectionName).updateDocument(main.studentno, myObject);
          } catch (ArangoDBException e) {
            System.err.println("Failed to update document. " + e.getMessage());
          }
        main.subject();
    }
}
