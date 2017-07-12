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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author User
 */
public class OptionForTeacherController implements Initializable {

    /**
     * Initializes the controller class.
     */
    School_Management_DB main;
    String dbName = "newDB";
    String collectionName = "StudentInfo";
    ArangoDB arangoDB;
    int k;
    int l;
    int kl;
    int cnt;
    String sw;
    int year;
    int[] ara=new int[1000];
    VPackSlice myDocument;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arangoDB = new ArangoDB.Builder().user("root").password("").build();
    }    
    public void setMain(School_Management_DB scene){
        main=scene;
        
    }
    public String getSaltString() {
        String SALTCHARS = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    public void sselection() throws IOException
    {
        int c = 0;
        for (int i=0;i<1000;i++){
            ara[i]=0;
        }
        try {
           VPackSlice myDocument1 = arangoDB.db(dbName).collection(collectionName).getDocument("myKey",
                 VPackSlice.class);
            
            k=  myDocument1.get("a").getAsInt();
            
            System.out.println(k);
          } catch (ArangoDBException e) {
            System.err.println("Failed to get document: myKey; " + e.getMessage());
          }
        cnt=0;
        for (int i=1; ;i++)
        {
            Random rand = new Random();
            int r=rand.nextInt(k);
            //System.out.println(r);
            if (ara[r+1]==0){
                cnt++;
                ara[r+1]=1;
                Date date = new Date();
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                year  = localDate.getYear();
                sw=Integer.toString(r+1);
                //System.out.println(sw);
                try {
                    myDocument = arangoDB.db(dbName).collection("StudentInfo").getDocument(sw,
                          VPackSlice.class);
                     String ew=  myDocument.get("Class").getAsString();
                     c=Integer.parseInt(ew);
                     //System.out.println(c);
                   } catch (ArangoDBException e) {
                     System.err.println("Failed to get document: myKey; " + e.getMessage());
                   }
                try {
                    VPackSlice myDocument2 = arangoDB.db(dbName).collection("StudentNumber").getDocument("myKey",
                          VPackSlice.class);

                     kl=  myDocument2.get(Integer.toString(c)).getAsInt()+1;

                     //System.out.println(str);
                   } catch (ArangoDBException e) {
                     System.err.println("Failed to get document: myKey; " + e.getMessage());
                   }
                String key;
                if (c<10){
                    if (kl<10){
                     key= Integer.toString(year)+"0"+Integer.toString(c)+"0"+Integer.toString(kl);
                    }
                    else{
                        key= Integer.toString(year)+"0"+Integer.toString(c)+Integer.toString(kl);
                    }
                }
                else{
                    if (kl<10){
                     key= Integer.toString(year)+Integer.toString(c)+"0"+Integer.toString(kl);
                    }
                    else{
                        key= Integer.toString(year)+Integer.toString(c)+Integer.toString(kl);
                    }
                     //key= Integer.toString(year)+Integer.toString(c)+Integer.toString(kl);
                }
                BaseDocument myObject3 = new BaseDocument();
                myObject3.addAttribute(Integer.toString(c),kl);
                     try {
                       arangoDB.db("newDB").collection("StudentNumber").updateDocument("myKey", myObject3);
                     } catch (ArangoDBException e) {
                       System.err.println("Failed to update document. " + e.getMessage());
                     }
                BaseDocument myObject = new BaseDocument();
                
                myObject.setKey(key);
                myObject.addAttribute("Session",myDocument.get("Session"));
                myObject.addAttribute("Class",myDocument.get("Class"));
                myObject.addAttribute("Shift",myDocument.get("Shift"));
                myObject.addAttribute("Student's Name",myDocument.get("Student's Name"));
                myObject.addAttribute("Father's Name",myDocument.get("Student's Father"));
                myObject.addAttribute("Father's Profession",myDocument.get("Student's Profession"));
                myObject.addAttribute("Father's Income",myDocument.get("Father's Income"));
                myObject.addAttribute("Father's NID",myDocument.get("Father's NID"));
                myObject.addAttribute("Mother's Name",myDocument.get("Mother's Name"));
                myObject.addAttribute("Mother's Profession",myDocument.get("Mother's Profession"));
                myObject.addAttribute("Mother's Income",myDocument.get("Mother's Income"));
                myObject.addAttribute("Mother's NID",myDocument.get("Mother's NID"));
                myObject.addAttribute("Date Of Birth",myDocument.get("Date Of Birth"));
                myObject.addAttribute("Religion",myDocument.get("Religion"));
                myObject.addAttribute("Birth Registration",myDocument.get("Birth Registration"));
                myObject.addAttribute("Gender",myDocument.get("Gender"));
                myObject.addAttribute("Blood Group",myDocument.get("Blood Group"));
                myObject.addAttribute("Present House No",myDocument.get("Present House No"));
                myObject.addAttribute("Present Road No",myDocument.get("Present Road No"));
                myObject.addAttribute("Present Thana",myDocument.get("Present Thana"));
                myObject.addAttribute("Present District",myDocument.get("Present District"));
                myObject.addAttribute("Present Division",myDocument.get("Present Division"));
                myObject.addAttribute("Permanent House No",myDocument.get("Permanent House No"));
                myObject.addAttribute("Permanent Road No",myDocument.get("Permanent Road No"));
                myObject.addAttribute("Permanent Thana",myDocument.get("Permanent Thana"));
                myObject.addAttribute("Permanent District",myDocument.get("Permanent District"));
                myObject.addAttribute("Permanent Division",myDocument.get("Permanent Division"));
                myObject.addAttribute("Previous School",myDocument.get("Previous School"));
                myObject.addAttribute("JSC Registrtion No",myDocument.get("JSC Registration No"));
                myObject.addAttribute("JSC ROll No",myDocument.get("JSC Roll No0"));
                myObject.addAttribute("JSC Board",myDocument.get("JSC Board"));
                myObject.addAttribute("JSC GPA",myDocument.get("JSC GPA"));
                myObject.addAttribute("JSC Year",myDocument.get("JSC Year"));
                myObject.addAttribute("Password",getSaltString());
                myObject.addAttribute("Bengali 1st Paper", 10.00);
                myObject.addAttribute("Bengali 2nd Paper", 10.00);
                myObject.addAttribute("English 1st Paper", 10.00);
                myObject.addAttribute("English 2nd Paper", 10.00);
                myObject.addAttribute("General Math", 10.00);
                myObject.addAttribute("Physics", 10.00);
                myObject.addAttribute("Chemistry", 10.00);
                myObject.addAttribute("Religious Education", 10.00);
                myObject.addAttribute("Social Science", 10.00);
                myObject.addAttribute("Higher Math", 10.00);
                myObject.addAttribute("Biology", 10.00);
                myObject.addAttribute("Computer Science", 10.00);
                myObject.addAttribute("Agriculture", 10.00);
                myObject.addAttribute("Home Economics", 10.00);
                myObject.addAttribute("Statistics", 10.00);
                try {
                arangoDB.db("newDB").collection("StudentTable").insertDocument(myObject);
                System.out.println("Document created");
                } catch (ArangoDBException e) {
                  System.err.println("Failed to create document. " + e.getMessage());
                }
                BaseDocument myObject2 = new BaseDocument();
                
                myObject2.setKey(key);
                myObject2.addAttribute("January","unpaid");
                myObject2.addAttribute("February","unpaid");
                myObject2.addAttribute("March","unpaid");
                myObject2.addAttribute("April","unpaid");
                myObject2.addAttribute("May","unpaid");
                myObject2.addAttribute("June","unpaid");
                myObject2.addAttribute("July","unpaid");
                myObject2.addAttribute("August","unpaid");
                myObject2.addAttribute("September","unpaid");
                myObject2.addAttribute("October","unpaid");
                myObject2.addAttribute("November","unpaid");
                myObject2.addAttribute("December","unpaid");
                
                try {
                arangoDB.db("newDB").collection("TuitionTable").insertDocument(myObject2);
                System.out.println("Document created");
                } catch (ArangoDBException e) {
                  System.err.println("Failed to create document. " + e.getMessage());
                }
                   
                if (cnt==k/2){
                    
                    break;
                }
            }
            
                
        }
        for (int j=1;j<=k;j++){
            String hey=Integer.toString(j);
            try {
                    arangoDB.db("newDB").collection("StudentInfo").deleteDocument(hey);
                  } catch (ArangoDBException e) {
                    System.err.println("Failed to delete document. " + e.getMessage());
                  }
        }
        BaseDocument myObject1=new BaseDocument();
        myObject1.addAttribute("a",0);
        try {
          arangoDB.db(dbName).collection("StudentInfo").updateDocument("myKey", myObject1);
        } catch (ArangoDBException e) {
          System.err.println("Failed to update document. " + e.getMessage());
        }
        main.showsuccessselection();
        
    }
    
    public void updatemarks() throws IOException
    {
        main.showupgradepage();
    }
    public void logout() throws IOException
    {
        main.showhomepage();
    }
}
