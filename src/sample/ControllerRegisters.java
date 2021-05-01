package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;

public class ControllerRegisters {
    @FXML
    private Button cancelButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label registerUserLabel;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField usernameTextField;


    public void registrationButtonOnAction(ActionEvent event){
        registrationMessageLabel.setText("Usuario cadastrado com sucesso!");
    }

    public void registerUserOnAction(){
        if (setPasswordField.getText().equals(confirmPasswordField.getText())){
            registerUser();
            registerUserLabel.setText("Senhas iguais!");
        }else {
            registerUserLabel.setText("Senhas divergentes!");
            registrationMessageLabel.setText("Usuario não cadastrado!");
        }
    }
    public void cancelButtonOnAction(ActionEvent event){
        Main.changeScrenn("main");
    }
    public void registerUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String userName = usernameTextField.getText();
        String password = setPasswordField.getText();

        String insertFields = "INSERT INTO user_account(firstName, lastName, userName, passwordUser) VALUES ('";
        String insertValues = firstName + "','" + lastName + "','" + userName + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            registrationMessageLabel.setText("Usuario registrado com sucesso!");

        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
