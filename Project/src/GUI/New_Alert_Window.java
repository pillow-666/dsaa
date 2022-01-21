package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

// the new open window
public class New_Alert_Window {

    // variable to be return to the main window
    static boolean answer;

    public static boolean display(String title, String message) {
        //Stage
        Stage window = new Stage();

        // ban the other action to other window until this window is close
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle(title);
        window.setMinWidth(250);

        //Label
        Label label = new Label();
        label.setText(message);

        //Button
        /*Button closeButton = new Button("Close the window");
        closeButton.setOnAction(event -> window.close());*/

        Button yesButton = new Button("是");
        yesButton.setOnAction(event -> {
            answer = true;
            window.close();
        });

        Button noButton = new Button("否");
        noButton.setOnAction(event -> {
            answer = false;
            window.close();
        });

        //Layout
        VBox layout = new VBox(15);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        //Scene
        Scene scene = new Scene(layout, 250, 120);
        window.setScene(scene);
        window.showAndWait();       // display the scene and need to be close to return

        return answer;
    }



}
