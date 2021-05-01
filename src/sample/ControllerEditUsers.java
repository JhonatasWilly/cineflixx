package sample;

import javafx.fxml.FXML;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;


public class ControllerEditUsers {

    @FXML
    private Label listUsersLabel;
    @FXML
    private Label listLastNameLabel;
    @FXML
    private Label listUserNamesLabel;
    @FXML
    private  Button exitRootPageButton;

    // A listagem de usuarios deveria ter sido feito com TableView, porém, devido a atraso no trabalho listei em
    // algumas label só pra mostrar que realmente está conseguindo mostrar os usuarios cadastrados.

    public void listUsersButtonOnAction() {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        try {

            Statement stmt = connectDB.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM user_account");
            while (rs.next()) {
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String userName = rs.getString("userName");
                listUsersLabel.setText(firstName);
                listLastNameLabel.setText(lastName);
                listUserNamesLabel.setText(userName);
            }
            connectDB.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void exitRootPageButtonOnAction(){
        Main.changeScrenn("main");
    }
}
