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
import java.io.IOException;
import java.util.Collection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class School_Management_DB extends Application {
     public Stage mainStage;
     public static String studentno;
    @Override
    public void start(Stage primaryStage) throws Exception {
        ArangoDB arangoDB = new ArangoDB.Builder().user("root").password("").build();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        mainStage=primaryStage;
        FXMLDocumentController controller=loader.getController();
        controller.setMain(this);
        primaryStage.setScene(scene);
        primaryStage.show();
        String dbName = "newDB";
         Collection<String> str=arangoDB.getDatabases();
         
             if (str.contains("newDB")){
                 //System.out.println("yes");
             }
             else{
	  try {
	    arangoDB.createDatabase(dbName);
	    System.out.println("Database created: " + dbName);
	  } catch (ArangoDBException e) {
	    //System.err.println("Failed to create database: " + dbName + "; " + e.getMessage());
	  }
          }
         Collection<CollectionEntity> collections = arangoDB.db("newDB").getCollections();
         if (collections.contains("StudentInfo")){
             
         }
         else{
         try {
         CollectionEntity myArangoCollection = arangoDB.db("newDB").createCollection("StudentInfo");
         System.out.println("Collection created: " + myArangoCollection.getName());
         } catch (ArangoDBException e) {
         //System.err.println("Failed to create collection: "  + "; " + e.getMessage());
         }
         BaseDocument myObject1 = new BaseDocument();
         myObject1.setKey("myKey");
         //myObject.addAttribute("Password", saltStr);
         myObject1.addAttribute("a",0);
         //myObject.addAttribute("b", 42);
         try {
         arangoDB.db("newDB").collection("StudentInfo").insertDocument(myObject1);
         System.out.println("Document created");
         } catch (ArangoDBException e) {
         //System.err.println("Failed to create document. " + e.getMessage());
         }
         }
         if (collections.contains("StudentTable")){
             
         }
         else{
         try {
         CollectionEntity myArangoCollection = arangoDB.db("newDB").createCollection("StudentTable");
         System.out.println("Collection created: " + myArangoCollection.getName());
         } catch (ArangoDBException e) {
         //System.err.println("Failed to create collection: "  + "; " + e.getMessage());
         }
         }
         if (collections.contains("StudentNumber")){
             
         }
         else{
         try {
         CollectionEntity myArangoCollection = arangoDB.db("newDB").createCollection("StudentNumber");
         System.out.println("Collection created: " + myArangoCollection.getName());
         } catch (ArangoDBException e) {
         //System.err.println("Failed to create collection: "  + "; " + e.getMessage());
         }
         BaseDocument myObject = new BaseDocument();
         myObject.setKey("myKey");
         //myObject.addAttribute("Password", saltStr);
         myObject.addAttribute("1",0);
         myObject.addAttribute("2",0);
         myObject.addAttribute("3",0);
         myObject.addAttribute("4",0);
         myObject.addAttribute("5",0);
         myObject.addAttribute("6",0);
         myObject.addAttribute("7",0);
         myObject.addAttribute("8",0);
         myObject.addAttribute("9",0);
         myObject.addAttribute("10",0);
         //myObject.addAttribute("b", 42);
         try {
         arangoDB.db("newDB").collection("StudentNumber").insertDocument(myObject);
         System.out.println("Document created");
         } catch (ArangoDBException e) {
         //System.err.println("Failed to create document. " + e.getMessage());
         }
         }
         if (collections.contains("TeacherTable")){
             
         }
         else{
         try {
         CollectionEntity myArangoCollection = arangoDB.db("newDB").createCollection("TeacherTable");
         System.out.println("Collection created: " + myArangoCollection.getName());
         } catch (ArangoDBException e) {
         //System.err.println("Failed to create collection: "  + "; " + e.getMessage());
         }
         }
         if (collections.contains("TuitionTable")){
             
         }
         else{
         try {
         CollectionEntity myArangoCollection = arangoDB.db("newDB").createCollection("TuitionTable");
         System.out.println("Collection created: " + myArangoCollection.getName());
         } catch (ArangoDBException e) {
         //System.err.println("Failed to create collection: "  + "; " + e.getMessage());
         }
         BaseDocument myObject1 = new BaseDocument();
         myObject1.setKey("1");
         //myObject.addAttribute("Password", saltStr);
         myObject1.addAttribute("Password","a");
         //myObject.addAttribute("b", 42);
         try {
         arangoDB.db("newDB").collection("TeacherTable").insertDocument(myObject1);
         System.out.println("Document created");
         } catch (ArangoDBException e) {
         //System.err.println("Failed to create document. " + e.getMessage());
         }
         }
         
         
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void showteacherloginpage() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("teacherLogin.fxml"));
        Parent root = loader.load();
        TeacherLoginController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    } 
    public void subject() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("subjectChoice.fxml"));
        Parent root = loader.load();
        SubjectChoiceController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    } 
    public void upgradesuccess1() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("upgradesuccess.fxml"));
        Parent root = loader.load();
        UpgradesuccessController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    } 
    public void successpay() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("paysuccess.fxml"));
        Parent root = loader.load();
        PaysuccessController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    } 
    public void showhomepage() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    } 
    public void teacherOptionPage() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("optionForTeacher.fxml"));
        Parent root = loader.load();
        OptionForTeacherController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    } 
    public void showsuccessApply() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("successApply.fxml"));
        Parent root = loader.load();
        SuccessApplyController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    } 
    public void showstudentloginpage() throws IOException{
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("studentlogin.fxml"));
        Parent root = loader.load();
        StudentloginController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    } 
   public void showapplypage() throws IOException{
        
       
        
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("apply.fxml"));
        Parent root = loader.load();
        ApplyController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    } 

    public void showsecondpage() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("applysecond.fxml"));
        Parent root = loader.load();
        ApplysecondController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void showregisterpage() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("register.fxml"));
        Parent root = loader.load();
        RegisterController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void showpaypage() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("payfees.fxml"));
        Parent root = loader.load();
        PayfeesController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void showupgradepage() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("upgrademarks.fxml"));
        Parent root = loader.load();
        UpgrademarksController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void showresult() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("resultshow.fxml"));
        Parent root = loader.load();
        ResultshowController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void showsuccessselection() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("SuccesSelection.fxml"));
        Parent root = loader.load();
        SuccesSelectionController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public void showstudenthomepage() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("studenthomepage.fxml"));
        Parent root = loader.load();
        StudenthomepageController  controller=loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
    
}
