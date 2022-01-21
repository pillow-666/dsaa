package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Excercise extends Application {
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Button button = new Button("button");
        Button button1 = new Button("new scene");
        button.setOnAction(event -> {

            AnchorPane an = new AnchorPane();
            an.getChildren().add(button1);
            an.setPrefHeight(500);
            an.setPrefWidth(500);

            Scene scene = new Scene(an);;
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initOwner(primaryStage);
            stage.show();

        });

        AnchorPane an = new AnchorPane();
        an.getChildren().add(button);

        Scene scene = new Scene(an, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
