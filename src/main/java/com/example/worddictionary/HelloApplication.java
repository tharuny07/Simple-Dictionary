package com.example.worddictionary;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Group root;
    @Override
    public void start(Stage stage) throws IOException {
        root=new Group();
        stage.setTitle("word dictionary");
        DictionaryPage page=new DictionaryPage();
        root.getChildren().add(page.root);
        Scene scene = new Scene(root, 500, 500);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}