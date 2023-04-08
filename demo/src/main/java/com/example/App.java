package com.example;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
// import javafx.scene.input.KeyCode;
// import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
// import java.util.HashSet;
// import java.util.Set; -- not being used

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    PrimaryController controller;

    @FXML
    private TextField inputTextField;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        
        Parent root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        
        scene = new Scene(root);
        stage.setScene(scene);
        root.requestFocus();
        
        
        
        scene.setOnKeyPressed(e -> controller.checkKeyPresses(e.getCode()));
        scene.setOnKeyReleased(e -> {
            controller.setShiftPressed(false);
        });
        stage.setTitle("ETERNITY by Team B");
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}