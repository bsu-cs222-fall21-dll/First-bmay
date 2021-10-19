package com.example.projectoneptwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

public class GUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Wikipedia Parser");

        Label labelfirst= new Label("Enter your name");
        Label label= new Label();

        Button button= new Button("Submit");
        TextField text= new TextField();

        button.setOnAction(event ->
                {
                    try {
                        InputStream jsonData = wikipediaCollect.buildConnection(text.getText());
                        wikipediaParser.parse(jsonData);
                        secondScene(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        stage.setScene(scene);
        stage.show();
    }

    public static void secondScene(Stage stage) throws IOException{

        int rev;
        String time;
        String user;
        String holder;

        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 240);
        stage.setTitle("Wikipedia result");
        VBox vbox = new VBox(30);

        Label label = new Label("Wiki search");

        vbox.getChildren().add(label);

        vbox.setAlignment(Pos.CENTER);

        ArrayDeque<wikiNode> list = wikipediaParser.getParseData();
        wikiNode wiki;
        for (int i = 0; i < list.size(); i++) {
            wiki = list.remove();
            /*
            rev = wiki.getRevisions();
            time = wiki.getTimeStamp();
            user = wiki.getUserName();

            holder = rev + " " + time + " " + user;
            */
            vbox.getChildren().add(wiki);
        }

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
