package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private static Stage stage;

    private static Scene mainScene;
    private static Scene registersScene;
    private static Scene rootPage;
    private static Scene editUsers;


    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("sample.fxml"));
        mainScene = new Scene(fxmlMain,600,400);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        Parent fxmlRegisters = FXMLLoader.load(getClass().getResource("registers.fxml"));
        registersScene = new Scene(fxmlRegisters,700,600);

        Parent fxmlRootPage = FXMLLoader.load(getClass().getResource("rootPage.fxml"));
        rootPage = new Scene(fxmlRootPage,600,564);

        Parent fxmlEditUsers = FXMLLoader.load(getClass().getResource("editUsers.fxml"));
        editUsers = new Scene(fxmlEditUsers,676,464);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void changeScrenn(String scr){
        switch (scr){
            case "main":
                stage.setScene(mainScene);
                break;
            case "registers":
                stage.setScene(registersScene);
                break;
            case "rootPage":
                stage.setScene(rootPage);
                break;
            case "edit":
                stage.setScene(editUsers);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
