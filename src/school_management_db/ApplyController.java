/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management_db;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.CollectionEntity;
import com.arangodb.velocypack.VPackSlice;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ApplyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    School_Management_DB main;
    @FXML
    public Button submit;
    @FXML
    public TextField session;
    @FXML
    public TextField cl;
    @FXML
    public TextField shift;
    @FXML
    public TextField sname;
    @FXML
    public TextField fname;
    @FXML
    public TextField fprof;
    @FXML
    public TextField fincome;
    @FXML
    public TextField fnid;
    @FXML
    public TextField mname;
    @FXML
    public TextField mprof;
    @FXML
    public TextField mincome;
    @FXML
    public TextField mnid;
    @FXML
    public TextField birthdate;
    @FXML
    public TextField religion;
    @FXML
    public TextField birthreg;
    @FXML
    public TextField gender;
    @FXML
    public TextField blood;
    @FXML
    public TextField presenthno;
    @FXML
    public TextField presentthana;
    @FXML
    public TextField presentrno;
    @FXML
    public TextField presentdis;
    @FXML
    public TextField presentdiv;
    @FXML
    public TextField perhno;
    @FXML
    public TextField perrno;
    @FXML
    public TextField perthana;
    @FXML
    public TextField perdis;
    @FXML
    public TextField perdiv;
    @FXML
    public TextField prevschool;
    @FXML
    public TextField jscreg;
    @FXML
    public TextField jscroll;
    @FXML
    public TextField jscboard;
    @FXML
    public TextField jscgpa;
    @FXML
    public TextField jscyear;
    @FXML
    public CheckBox same;
    String dbName = "newDB";
    String collectionName = "StudentInfo";
    ArangoDB arangoDB;
    int k;
    int l;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arangoDB = new ArangoDB.Builder().user("root").password("").build();
        
    }    
    public void setMain(School_Management_DB scene){
        main=scene;
        
    }
    public void sameaddress()
    {
        perdis.setText(presentdis.getText());
        perdiv.setText(presentdiv.getText());
        perhno.setText(presenthno.getText());
        perrno.setText(presentrno.getText());
        perthana.setText(presentthana.getText());
    }
    public void nextpage() throws IOException{
         try {
            VPackSlice myDocument = arangoDB.db(dbName).collection(collectionName).getDocument("myKey",
                 VPackSlice.class);
            
            k=  myDocument.get("a").getAsInt()+1;
            
            //System.out.println(str);
          } catch (ArangoDBException e) {
            System.err.println("Failed to get document: myKey; " + e.getMessage());
          } 
        BaseDocument myObject = new BaseDocument();
        
        myObject.setKey(Integer.toString(k));
        myObject.addAttribute("Session",session.getText());
        myObject.addAttribute("Class",cl.getText());
        myObject.addAttribute("Shift",shift.getText());
        myObject.addAttribute("Student's Name",sname.getText());
        myObject.addAttribute("Father's Name",fname.getText());
        myObject.addAttribute("Father's Profession",fprof.getText());
        myObject.addAttribute("Father's Income",fincome.getText());
        myObject.addAttribute("Father's NID",fnid.getText());
        myObject.addAttribute("Mother's Name",mname.getText());
        myObject.addAttribute("Mother's Profession",mprof.getText());
        myObject.addAttribute("Mother's Income",mincome.getText());
        myObject.addAttribute("Mother's NID",mnid.getText());
        myObject.addAttribute("Date Of Birth",birthdate.getText());
        myObject.addAttribute("Religion",religion.getText());
        myObject.addAttribute("Birth Registration",birthreg.getText());
        myObject.addAttribute("Gender",gender.getText());
        myObject.addAttribute("Blood Group",blood.getText());
        myObject.addAttribute("Present House No",presenthno.getText());
        myObject.addAttribute("Present Road No",presentrno.getText());
        myObject.addAttribute("Present Thana",presentthana.getText());
        myObject.addAttribute("Present District",presentdis.getText());
        myObject.addAttribute("Present Division",presentdiv.getText());
        myObject.addAttribute("Permanent House No",perhno.getText());
        myObject.addAttribute("Permanent Road No",perrno.getText());
        myObject.addAttribute("Permanent Thana",perthana.getText());
        myObject.addAttribute("Permanent District",perdis.getText());
        myObject.addAttribute("Permanent Division",perdiv.getText());
        myObject.addAttribute("Previous School",prevschool.getText());
        myObject.addAttribute("JSC Registrtion No",jscreg.getText());
        myObject.addAttribute("JSC ROll No",jscroll.getText());
        myObject.addAttribute("JSC Board",jscboard.getText());
        myObject.addAttribute("JSC GPA",jscgpa.getText());
        myObject.addAttribute("JSC Year",jscyear.getText());
        
        try {
          arangoDB.db("newDB").collection("StudentInfo").insertDocument(myObject);
          System.out.println("Document created");
        } catch (ArangoDBException e) {
          System.err.println("Failed to create document. " + e.getMessage());
        }
        BaseDocument myObject1 = new BaseDocument();
        myObject1.addAttribute("a",k);
        
        try {
          arangoDB.db(dbName).collection(collectionName).updateDocument("myKey", myObject1);
        } catch (ArangoDBException e) {
          System.err.println("Failed to update document. " + e.getMessage());
        }
        main.showsuccessApply();
    }
    
}
