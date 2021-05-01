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

public class ControllerRootPage {

    @FXML
    private Button editUsersButton;
    @FXML
    private Button exitRootPageButton;
    @FXML
    private Button registerUsersButton;

    public void registersUsersButtonOnAction(ActionEvent action){
        Main.changeScrenn("registers");
    }

    public void editUsersButtonOnAction(ActionEvent action){
        Main.changeScrenn("edit");
    }

    public void exitRootPageButtonOnAction(ActionEvent action){
        Main.changeScrenn("main");
    }

}
