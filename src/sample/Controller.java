package sample;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

public class Controller{

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField inputPasswordField;


    public void loginButtonOnAction(ActionEvent event) {
        if(userTextField.getText().equals("root") && inputPasswordField.getText().equals("1234")){
            loginMessageLabel.setText("Login efetuado com sucesso!");
            Main.changeScrenn("rootPage");
        } else{
            loginMessageLabel.setText("Insira o Usuario e a Senha.");
        }
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void registerButtonOnAction(ActionEvent event){
        Main.changeScrenn("registers");
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account where userName = '" + userTextField.getText() + "'AND passwordUser = '" + inputPasswordField.getText() + "'";


        try {

            Statement statement = connectDB.createStatement();
            try (ResultSet queryResult = statement.executeQuery(verifyLogin)) {

                while (queryResult.next()) {
                    if ((queryResult.getInt(1) == 1)) {
                        loginMessageLabel.setText("Bem vindo!");
                    } else if (userTextField.getText().equals("root") && inputPasswordField.getText().equals("1234")) {
                        Main.changeScrenn("rootPage");
                    } else {
                        loginMessageLabel.setText("Login invalido!");
                    }
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    public void createAccountForm(){
        try{

            Parent root = FXMLLoader.load(getClass().getResource("registers.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root,700,600));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
